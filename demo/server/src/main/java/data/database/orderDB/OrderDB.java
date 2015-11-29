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
			sql = "create table OrderPO(id bigint auto_increment primary key,sendername text,senderaddress text,senderunit text,senderphone "
					+ "text,sendercellphone text,receivername text,receiveraddress text,receiverunit text,receiverphone text,receivercellphone "
					+ "text,numbers double,weight double,volume double,productname text,packagefee double,totalfee double,ordercode "
					+ "text,ordertype blob,codeofreceiving text,receiver text,receivingtime bigint,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();

			OrderPO po=new OrderPO(1,"孙超","南京市栖霞区南京大学仙林校区","南京大学","57575757","13123456789","孙康","南京市栖霞区南京师范大学","南京师范大学",
					"56565656","13234567890",1,5,3,"iphone6",4,5,"0000000001",Ordertype.fast);
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
			double packagefee=po.getPackagefee();
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
			sql = "insert into OrderPO values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst = dbh.prepare(sql);

			pst.setString(1, sendername);
			pst.setString(2, senderaddress);
			pst.setString(3, senderunit);
			pst.setString(4, senderphone);
			pst.setString(5, sendercellphone);
			pst.setString(6, receivername);
			pst.setString(7, receiveraddress);
			pst.setString(8, receiverunit);
			pst.setString(9, receiverphone);
			pst.setString(10, receivercellphone);
			pst.setDouble(11,numbers);
			pst.setDouble(12,weight);
			pst.setDouble(13,volume);
			pst.setString(14, productname);
			pst.setDouble(15,packagefee);
			pst.setDouble(16,totalfee);
			pst.setString(17, ordercode);
			pst.setBytes(18, typebyte);
			pst.setString(19, codeofreceiving);
			pst.setString(20, receiver);
			pst.setLong(21, receivingtime);
			pst.setBytes(22, statebytes);
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
			sql = "update OrderPO set sendername=?,senderaddress=?,senderunit=?,senderphone=?,sendercellphone=?,receivername=?,"
					+ "receiveraddress=?,receiverunit=?,receiverphone=?,receivercellphone=?,numbers=?,weight=?,volume=?,productname=?"
					+ ",packagefee=?,totalfee=?,ordertype=?,codeofreceiving=?,receiver=?,receivingtime=?,documentstate=? "
					+ "where ordercode =?";
			pst = dbh.prepare(sql);
			pst.setString(1, po.getSendername());
			pst.setString(2, po.getSenderaddress());
			pst.setString(3, po.getSenderunit());
			pst.setString(4, po.getSenderphone());
			pst.setString(5, po.getSendercellphone());
			pst.setString(6, po.getReceivername());
			pst.setString(7, po.getReceiveraddress());
			pst.setString(8, po.getReceiverunit());
			pst.setString(9, po.getReceiverphone());
			pst.setString(10, po.getReceivercellphone());
			pst.setDouble(11, po.getNumbers());
			pst.setDouble(12, po.getWeight());
			pst.setDouble(13, po.getVolume());
			pst.setString(14, po.getProductname());
			pst.setDouble(15, po.getPackagefee());
			pst.setDouble(16, po.getTotalfee());
			byte[] typebytes = Serialize.Object2Bytes(po.getOrdertype());
			pst.setBytes(17, typebytes);
			pst.setString(18, po.getCodeofreceiving());
			pst.setString(19, po.getReceiver());
			pst.setLong(20, po.getReceivingtime());
			pst.setBytes(21, statebytes);
			pst.setString(22, ordercode);
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
			sql = "select id,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,receiverunit,receiverphone,"
					+ "receivercellphone,numbers,weight,volume,productname,packagefee,totalfee,ordercode,ordertype,codeofreceiving,"
					+ "receiver,receivingtime,documentstate from OrderPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				Ordertype type = (Ordertype) Serialize.Bytes2Object(ret.getBytes(19));
				Formstate documentstate = (Formstate) Serialize.Bytes2Object(ret.getBytes(23));
				po = new OrderPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4), ret.getString(5),
						ret.getString(6), ret.getString(7), ret.getString(8), ret.getString(9), ret.getString(10),
						ret.getString(11), ret.getDouble(12), ret.getDouble(13), ret.getDouble(14), ret.getString(15),
						ret.getDouble(16), ret.getDouble(17), ret.getString(18), type,
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
		sql="select id,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,receiverunit,receiverphone,"
				+ "receivercellphone,numbers,weight,volume,productname,packagefee,totalfee,ordercode,ordertype,codeofreceiving,"
				+ "receiver,receivingtime,documentstate from OrderPO where ordercode = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,ordernum);	
			ret=pst.executeQuery();
			if(ret.next()){
				long id=ret.getLong(1);
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
				double packagefee=ret.getDouble(16);
				double totalfee=ret.getDouble(17);
				String ordercode=ret.getString(18);
				Ordertype ordertype=(Ordertype)Serialize.Bytes2Object(ret.getBytes(19));
				String codeofreceiving=ret.getString(20);
				String receiver=ret.getString(21);
				long receivingtime=ret.getLong(22);
				Formstate documentstate=(Formstate)Serialize.Bytes2Object(ret.getBytes(23));
				po=new OrderPO(id,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,
						receiverunit,receiverphone,receivercellphone,numbers,weight,volume,productname,packagefee,
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
	
	public static long getLastId(){
		long lastId=0;
		dbh=new DBHelper();
		sql="select max(id) from OrderPO";
		pst = dbh.prepare(sql);
		try {
			ret=pst.executeQuery();
			if(ret.next()){
				lastId=ret.getLong(1);
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

		if(getLastId()==1){
			System.out.println("getLastId success");
		}

		if(update(new OrderPO(1,"孙超","南京市栖霞区南京大学仙林校区","南京大学","57575757","13123456789","孙康","南京市栖霞区南京师范大学","南京师范大学",
				"56565656","13234567890",1,5,3,"iphone6",4,5,"0000000001",Ordertype.fast))==ResultMessage.success){
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
