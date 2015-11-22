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
			sql = "create table OrderPO(id bigint auto_increment primary key,sendername text,sendaddress text,senderunit text,senderphone "
					+ "text,sendercellphone text,receivername text,receiveraddress text,receiverunit text,receiverphone text,receivercellphone "
					+ "text,numbers double,weight double,volume double,productname text,productsize double,packagefee double,totalfee double,ordercode "
					+ "text,ordertype blob,codeofreceving text,receiver text,receivingtime bigint,documentstate blob)";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResultMessage.success;
		
	}
	
	public static ResultMessage delete(long id){
		dbh=new DBHelper();
		sql="delete from OrganizationPO where id=?";
		pst=dbh.prepare(sql);
		try{
			pst.setLong(1, id);
			int result;
			result=pst.executeUpdate();
			if(result!=0){
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static ResultMessage update(long id,String name,Organizationtype type){
		try{
			byte[] typebytes = Serialize.Object2Bytes(type);
			dbh = new DBHelper();
			sql = "update OrganizationPO set name=?,type=? where id=?";
			pst = dbh.prepare(sql);
			pst.setString(1, name);
			pst.setBytes(2, typebytes);
			pst.setLong(3,id);
			int result;
			result = pst.executeUpdate();
			if (result != 0) {
				return ResultMessage.success;
			}
			ret.close();
			dbh.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
	
	public static List<OrganizationPO> fuzzySearch(String name){
		List<OrganizationPO> list=new ArrayList<OrganizationPO>();
		OrganizationPO po;
		dbh=new DBHelper();
		sql="select id,name,type from OrganizationPO where name like ?";
		pst = dbh.prepare(sql);
		try {
			pst.setString(1,"%"+name+"%");	//模糊查找时两边加%
			ret=pst.executeQuery();
			while(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getLong(1),ret.getString(2),type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<OrganizationPO> fuzzySearchbytype(Organizationtype typeget) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(typeget);

			OrganizationPO po;
			dbh = new DBHelper();
			sql = "select id,name,type from OrganizationPO where type=?";
			pst = dbh.prepare(sql);

			pst.setBytes(1, typebyte);
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes = ret.getBytes(3);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new OrganizationPO(ret.getLong(1), ret.getString(2), type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<OrganizationPO> fuzzySearchbyboth(String name, Organizationtype typeget) {
		List<OrganizationPO> list = new ArrayList<OrganizationPO>();
		try {
			byte[] typebyte = Serialize.Object2Bytes(typeget);

			OrganizationPO po;
			dbh = new DBHelper();
			sql = "select id,name,type from OrganizationPO where type=? and name like ?";
			pst = dbh.prepare(sql);

			pst.setBytes(1, typebyte);
			pst.setString(2, "%" + name + "%"); // 模糊查找时两边加%
			ret = pst.executeQuery();
			while (ret.next()) {
				byte[] typebytes = ret.getBytes(3);
				Organizationtype type = (Organizationtype) Serialize.Bytes2Object(typebytes);
				po = new OrganizationPO(ret.getLong(1), ret.getString(2), type);
				list.add(po);
			}
			ret.close();
			dbh.close();// 关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static OrganizationPO search(long id){
		OrganizationPO po=null;
		dbh=new DBHelper();
		sql="select id,name,type from OrganizationPO where id = ?";
		pst = dbh.prepare(sql);
		try {
			pst.setLong(1,id);	
			ret=pst.executeQuery();
			if(ret.next()){
				byte[] typebytes=ret.getBytes(3);
				Organizationtype type=(Organizationtype) Serialize.Bytes2Object(typebytes);
				po=new OrganizationPO(ret.getLong(1),ret.getString(2),type);
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
		sql="select max(id) from OrganizationPO";
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
//		if(write("南京",Organizationtype.hall)==ResultMessage.success){
//			System.out.println("write success");
//		}
//		if(getLastId()==2){
//			System.out.println("getLastId success");
//		}
//		if(delete(2)==ResultMessage.success){
//			System.out.println("delete success");
//		}
//		if(update(1,"上海",Organizationtype.transfercenter)==ResultMessage.success){
//			System.out.println("update success");
//		}
//		if(search(1)!=null){
//			System.out.println("seach success");
//		}
//		if(fuzzySearch("上海").size()>0){
//			System.out.println("fuzzysearch success");
//		}
//		if(fuzzySearchbytype(Organizationtype.transfercenter).size()>0){
//			System.out.println("fuzzySearchbyypte success");
//		}
//		if(fuzzySearchbyboth("上海",Organizationtype.transfercenter).size()>0){
//			System.out.println("fuzzySearchbyboth success");
//		}
	}
}
