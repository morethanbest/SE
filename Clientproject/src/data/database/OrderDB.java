package data.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.OrderPO;
import po.Ordertype;
import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

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
					+ "text,numbers double,weight double,volume double,productname text,productsize double,packagefee double,totalfee double,ordercode "
					+ "text,ordertype blob,codeofreceiving text,receiver text,receivingtime bigint,documentstate blob)";
			pst = dbh.prepare(sql);
			pst.executeUpdate();

			OrderPO po=new OrderPO(1,"孙超","南京市栖霞区南京大学仙林校区","南京大学","57575757","13123456789","孙康","南京市栖霞区南京师范大学","南京师范大学",
					"56565656","13234567890",1,5,3,"iphone6",4,5,10,"0000000001",Ordertype.fast);
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
			double productsize=po.getProductsize();
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
			sql = "insert into OrderPO values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pst.setDouble(15,productsize);
			pst.setDouble(16,packagefee);
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
			sql = "update OrderPO set documentstate=? where ordercode =?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			pst.setString(2, ordercode);
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
					+ "receivercellphone,numbers,weight,volume,productname,productsize,packagefee,totalfee,ordercode,ordertype,codeofreceiving,"
					+ "receiver,receivingtime,documentstate from OrderPO where documentstate = ?";
			pst = dbh.prepare(sql);
			pst.setBytes(1, statebytes);
			ret = pst.executeQuery();
			while (ret.next()) {
				Ordertype type = (Ordertype) Serialize.Bytes2Object(ret.getBytes(20));
				Formstate documentstate = (Formstate) Serialize.Bytes2Object(ret.getBytes(24));
				po = new OrderPO(ret.getLong(1), ret.getString(2), ret.getString(3), ret.getString(4), ret.getString(5),
						ret.getString(6), ret.getString(7), ret.getString(8), ret.getString(9), ret.getString(10),
						ret.getString(11), ret.getDouble(12), ret.getDouble(13), ret.getDouble(14), ret.getString(15),
						ret.getDouble(16), ret.getDouble(17), ret.getDouble(18), ret.getString(19), type,
						ret.getString(21), ret.getString(22), ret.getLong(23), documentstate);
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
				+ "receivercellphone,numbers,weight,volume,productname,productsize,packagefee,totalfee,ordercode,ordertype,codeofreceiving,"
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
				double productsize=ret.getDouble(16);
				double packagefee=ret.getDouble(17);
				double totalfee=ret.getDouble(18);
				String ordercode=ret.getString(19);
				Ordertype ordertype=(Ordertype)Serialize.Bytes2Object(ret.getBytes(20));
				String codeofreceiving=ret.getString(21);
				String receiver=ret.getString(22);
				long receivingtime=ret.getLong(23);
				Formstate documentstate=(Formstate)Serialize.Bytes2Object(ret.getBytes(24));
				po=new OrderPO(id,sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,receiveraddress,
						receiverunit,receiverphone,receivercellphone,numbers,weight,volume,productname,productsize,packagefee,
						totalfee,ordercode,ordertype,codeofreceiving,receiver,receivingtime,documentstate);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return po;		//查不到时返回null
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
				"56565656","13234567890",1,5,3,"iphone6",4,5,10,"0000000001",Ordertype.fast))==ResultMessage.success){
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
