package chaoshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;






import chaoshi.dao.BaseDao;
import chaoshi.table.Shangpin;



public class ShangpinDao {
	
	private static Connection conn ;
	private static Statement stmt;
	public static void dbConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/chaoshi?useUnicode=true&characterEncoding=utf-8";
			String username = "root"; 
			String password = "root"; 
		    conn =DriverManager.getConnection(url,username,password); 
		    stmt =conn.createStatement(); 
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static void dbClose(){
		try {
			stmt.close();
		    conn.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
	public static List<Shangpin> allShangpinList(){
		try {
			List<Shangpin> list = new ArrayList<>();
			String sql = "select * from Shangpin";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Shangpin shangpin = convertShangpin(rs);
				
				list.add(shangpin);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ShangpinDao.allShangpinList error: "+e.getMessage());
			return null;
		}
	}
	
	
	private static Shangpin convertShangpin(ResultSet rs){
		Shangpin shangpin = new Shangpin();
		//student.setId(rs.getLong("id"));
		try {
			shangpin.setShangpinNum(rs.getString("shangpinNum"));
			shangpin.setShangpinId(rs.getString("shangpinId"));
			shangpin.setLeixing(rs.getString("leixing"));
			shangpin.setPinpai(rs.getString("pinpai"));
			shangpin.setJinjia(rs.getDouble("jinjia"));
			shangpin.setShoujia(rs.getDouble("shoujia"));
			shangpin.setZhekou(rs.getDouble("zhekou"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shangpin;
	}

	public static Shangpin findByNum(String shangpinNum)
	{	
		Shangpin shangpin=null;
		try {
			String sql="select * from shangpin where shangpinNum='" + shangpinNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			if(rs.next()){
				shangpin = convertShangpin(rs);
			}
			rs.close();
			BaseDao.dbClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shangpin;
	}
	
	public static List<Shangpin> findByNumLike(String shangpinNum){
		try {
			List<Shangpin> list = new ArrayList<>();
			String sql="select * from shangpin where shangpinNum like '%" + shangpinNum+"%'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Shangpin shangpin = convertShangpin(rs);
				
				list.add(shangpin);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ShangpinDao.allShangpinList error: "+e.getMessage());
			return null;
		}
	}
	
	
	public static List<Shangpin> findByClass(String shangpinNum){
		try {
			List<Shangpin> list = new ArrayList<>();

			String sql = "select * from shangpin where shangpinNum='" + shangpinNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Shangpin shangpin = convertShangpin(rs);
				list.add(shangpin);
				
			}
			rs.close();
			BaseDao.dbClose();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ShangpinDao.allShangpinList error: "+e.getMessage());
			return null;
		}
	}
	public static int addOneShangpin(Shangpin stu) 
	{	
		String sql="insert into shangpin values('" + stu.getShangpinNum()+"','"
				+ stu.getShangpinId()+"','"+ stu.getLeixing()+"','"+ stu.getPinpai()+"','"
				+ stu.getJinjia()+"','"+ stu.getShoujia()+"','"+ stu.getZhekou()+"')";
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("添加成功！");
		BaseDao.dbClose();
		return r;
	}
	
	public static int updateCusAndid(Shangpin cus) 
	{	
		String sql="update shangpin set ShangpinId='" + cus.getShangpinId()+"',Leixing='" +cus.getLeixing()+"',Pinpai='" + cus.getPinpai()+"',Jinjia='" + cus.getJinjia()+"',Shoujia='" + cus.getShoujia()+"',Zhekou='" + cus.getZhekou()+"' where ShangpinNum='"+ cus.getShangpinNum()+"'";
		System.out.print(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("修改电话成功！");
		if(r==1) System.out.println("修改地址成功！");
		BaseDao.dbClose();
		return r;
	}
	
	
	
	
	public static void deleteOneShangpin(String shangpinNum) 
	{	
		String sql="delete from shangpin where shangpinNum='" + shangpinNum+"'";
		System.out.println(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("删除成功！");
		BaseDao.dbClose();
	}
	
	
	

	
	
	
	
}
