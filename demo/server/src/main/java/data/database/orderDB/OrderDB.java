package data.database.orderDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import data.database.DBHelper;
import data.database.Serialize;
import po.Formstate;
import po.OrderPO;
import po.Ordertype;
import po.ResultMessage;

public class OrderDB {
	static String sql = null;
	static DBHelper dbh = null;
	static ResultSet ret = null;
	static PreparedStatement pst=null;
	public static void initialize(){
		dbh=new DBHelper();
		sql="drop table OrderPO";
		pst=dbh.prepare(sql);
		try{
			pst.executeUpdate();
			sql = "create table OrderPO(id bigint auto_increment primary key,orgcode text,sendername text,senderaddress text,senderunit text,senderphone "
					+ "text,sendercellphone text,receivername text,receiveraddress text,receiverunit text,receiverphone text,receivercellphone "
					+ "text,numbers double,weight double,volume double,productname text,packagetype text,totalfee double,ordercode "
					+ "text,ordertype blob,codeofreceiving text,receiver text,receivingtime bigint,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();

			OrderPO po=new OrderPO("025000","孙超","南京市栖霞区南京大学仙林校区","南京大学","57575757","13123456789","孙康","南京市栖霞区南京师范大学","南京师范大学",
					"56565656","13234567890",1,5,3,"iphone6","快递袋",5,"0000000000",Ordertype.fast,Formstate.waiting);
			write(po);
			dbh.close();// 关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static ResultMessage write(OrderPO po) {
		try {
			String sendername=po.getSendername();
			String senderaddress=po.getSenderaddress();
			String senderunit=po.getSenderunit();
			String senderphone=po.getSenderphone();
			String sendercellphone=po.getSendercellphone();
			String receivername=po.getReceivername();
			String receiveraddress=po.getReceiveraddress();
			String receiverunit=po.getReceiverunit();
			String receiverphone=po.getReceiverphone();
			String receivercellphone=po.getReceivercellphone();
			double numbers=po.getNumbers();
			double weight=po.getWeight();
			double volume=po.getVolume();
			String productname=po.getProductname();
			String packagetype=po.getPackagetype();
			double totalfee=po.getTotalfee();
			String ordercode=po.getOrdercode();
			Ordertype ordertype=po.getOrdertype();
			String codeofreceiving=po.getCodeofreceiving();
			String receiver=po.getReceiver();
			long receivingtime=po.getReceivingtime();
			Formstate documentstate=po.getDocumentstate();	
			byte[] typebyte=Serialize.Object2Bytes(ordertype);
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			
			dbh = new DBHelper();
			sql = "insert into OrderPO values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrgcode());
			pst.setString(2, sendername);
			pst.setString(3, senderaddress);
			pst.setString(4, senderunit);
			pst.setString(5, senderphone);
			pst.setString(6, sendercellphone);
			pst.setString(7, receivername);
			pst.setString(8, receiveraddress);
			pst.setString(9, receiverunit);
			pst.setString(10, receiverphone);
			pst.setString(11, receivercellphone);
			pst.setDouble(12,numbers);
			pst.setDouble(13,weight);
			pst.setDouble(14,volume);
			pst.setString(15, productname);
			pst.setString(16,packagetype);
			pst.setDouble(17,totalfee);
			pst.setString(18, ordercode);
			pst.setBytes(19, typebyte);
			pst.setString(20, codeofreceiving);
			pst.setString(21, receiver);
			pst.setLong(22, receivingtime);
			pst.setBytes(23, statebytes);
			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
			return ResultMessage.success;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResultMessage.failure;
		
	}
	

	
	public static ResultMessage update(OrderPO po){
		try {
			
			String ordercode=po.getOrdercode();
			Formstate documentstate=po.getDocumentstate();	
			byte[] statebytes = Serialize.Object2Bytes(documentstate);
			
			dbh = new DBHelper();
			sql = "update OrderPO set orgcode=?,sendername=?,senderaddress=?,senderunit=?,senderphone=?,sendercellphone=?,receivername=?,"
					+ "receiveraddress=?,receiverunit=?,receiverphone=?,receivercellphone=?,numbers=?,weight=?,volume=?,productname=?"
					+ ",packagetype=?,totalfee=?,ordertype=?,codeofreceiving=?,receiver=?,receivingtime=?,documentstate=? "
					+ "where ordercode =?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getOrgcode());
			pst.setString(2, po.getSendername());
			pst.setString(3, po.getSenderaddress());
			pst.setString(4, po.getSenderunit());
			pst.setString(5, po.getSenderphone());
			pst.setString(6, po.getSendercellphone());
			pst.setString(7, po.getReceivername());
			pst.setString(8, po.getReceiveraddress());
			pst.setString(9, po.getReceiverunit());
			pst.setString(10, po.getReceiverphone());
			pst.setString(11, po.getReceivercellphone());
			pst.setDouble(12, po.getNumbers());
			pst.setDouble(13, po.getWeight());
			pst.setDouble(14, po.getVolume());
			pst.setString(15, po.getProductname());
			pst.setString(16, po.getPackagetype());
			pst.setDouble(17, po.getTotalfee());
			byte[] typebytes = Serialize.Object2Bytes(po.getOrdertype());
			pst.setBytes(18, typebytes);
			pst.setString(19, po.getCodeofreceiving());
			pst.setString(20, po.getReceiver());
			pst.setLong(21, po.getReceivingtime());
			pst.setBytes(22, statebytes);
			pst.setString(23, ordercode);
			int result = pst.executeUpdate();
			if (result == -1) {
				dbh.close();// 关闭连接
				return ResultMessage.failure;
			}
			dbh.close();// 关闭连接
			return ResultMessage.success;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResultMessage.failure;
	}
	
	public static List<OrderPO> fuzzySearch(Formstate state){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(state);
			sql = "select orgcode,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,receiverunit,receiverphone,"
					+ "receivercellphone,numbers,weight,volume,productname,packagetype,totalfee,ordercode,ordertype,codeofreceiving,"
					+ "receiver,receivingtime,documentstate from OrderPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				Ordertype type = (Ordertype) Serialize.Bytes2Object(ret.getBytes(19));
				Formstate documentstate = (Formstate) Serialize.Bytes2Object(ret.getBytes(23));
				po = new OrderPO(ret.getString(1), ret.getString(2), ret.getString(3), ret.getString(4), ret.getString(5),
						ret.getString(6), ret.getString(7), ret.getString(8), ret.getString(9), ret.getString(10),
						ret.getString(11), ret.getDouble(12), ret.getDouble(13), ret.getDouble(14), ret.getString(15),
						ret.getString(16), ret.getDouble(17), ret.getString(18), type,
						ret.getString(20), ret.getString(21), ret.getLong(22), documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrderPO> fuzzySearch(Formstate state,String orgcode){
		List<OrderPO> list=new ArrayList<OrderPO>();
		OrderPO po;
		dbh=new DBHelper();
		try {
			byte[] statebytes = Serialize.Object2Bytes(state);
			sql = "select orgcode,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,receiverunit,receiverphone,"
					+ "receivercellphone,numbers,weight,volume,productname,packagetype,totalfee,ordercode,ordertype,codeofreceiving,"
					+ "receiver,receivingtime,documentstate from OrderPO where documentstate = ? and orgcode = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, orgcode);
			ret = pst.executeQuery();
			while (ret.next()) {
				if(!ret.getString(18).startsWith(orgcode)){
					continue;
				}
				Ordertype type = (Ordertype) Serialize.Bytes2Object(ret.getBytes(19));
				Formstate documentstate = (Formstate) Serialize.Bytes2Object(ret.getBytes(23));
				po = new OrderPO(ret.getString(3), ret.getString(2), ret.getString(3), ret.getString(4), ret.getString(5),
						ret.getString(6), ret.getString(7), ret.getString(8), ret.getString(9), ret.getString(10),
						ret.getString(11), ret.getDouble(12), ret.getDouble(13), ret.getDouble(14), ret.getString(15),
						ret.getString(16), ret.getDouble(17), ret.getString(18), type,
						ret.getString(20), ret.getString(21), ret.getLong(22), documentstate);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	public static OrderPO search(String ordernum){
		OrderPO po=null;
		dbh=new DBHelper();
		sql="select orgcode,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,receiverunit,receiverphone,"
				+ "receivercellphone,numbers,weight,volume,productname,packagetype,totalfee,ordercode,ordertype,codeofreceiving,"
				+ "receiver,receivingtime,documentstate from OrderPO where ordercode = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,ordernum);	
			ret=pst.executeQuery();
			if(ret.next()){
				String sendername=ret.getString(2);
				String senderaddress=ret.getString(3);
				String senderunit=ret.getString(4);
				String senderphone=ret.getString(5);
				String sendercellphone=ret.getString(6);
				String receivername=ret.getString(7);
				String receiveraddress=ret.getString(8);
				String receiverunit=ret.getString(9);
				String receiverphone=ret.getString(10);
				String receivercellphone=ret.getString(11);
				double numbers=ret.getDouble(12);
				double weight=ret.getDouble(13);
				double volume=ret.getDouble(14);
				String productname=ret.getString(15);
				String packagetype=ret.getString(16);
				double totalfee=ret.getDouble(17);
				String ordercode=ret.getString(18);
				Ordertype ordertype=(Ordertype)Serialize.Bytes2Object(ret.getBytes(19));
				String codeofreceiving=ret.getString(20);
				String receiver=ret.getString(21);
				long receivingtime=ret.getLong(22);
				Formstate documentstate=(Formstate)Serialize.Bytes2Object(ret.getBytes(23));
				po=new OrderPO(ret.getString(1),sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,
						receiverunit,receiverphone,receivercellphone,numbers,weight,volume,productname,packagetype,
						totalfee,ordercode,ordertype,codeofreceiving,receiver,receivingtime,documentstate);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		//查不到时返回null
	}
	
	public static double getWeight(String ordernum){
		double weight=0;
		dbh=new DBHelper();
		sql="select weight from OrderPO where ordercode = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,ordernum);	
			ret=pst.executeQuery();
			if(ret.next()){
				weight=ret.getDouble(1);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weight;
	}
	
	public static long getLastId(String orgcode){
		long lastId=-1;
		dbh=new DBHelper();
		sql="select ordercode from OrderPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			while(ret.next()){
				lastId++;
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastId;
	}
	public static void main(String[] args) {
		initialize();
		System.out.println("test");

//		if(getLastId("025")==1){
			System.out.println(getLastId("025"));
//		}

		if(update(new OrderPO("025000","孙超","南京市栖霞区南京大学仙林校区","南京大学","57575757","13123456789","孙康","南京市栖霞区南京师范大学","南京师范大学",
				"56565656","13234567890",1,5,3,"iphone6","快递袋",5,"0000000001",Ordertype.fast,Formstate.waiting))==ResultMessage.success){
			System.out.println("update success");
		}
		if(search("0000000001")!=null){
			System.out.println("search success");
		}
		if(fuzzySearch(Formstate.waiting).size()>0){
			System.out.println("fuzzysearch success");
		}

	}
}
