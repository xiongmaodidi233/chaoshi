package chaoshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chaoshi.table.Huiyuan;
import chaoshi.table.Kucun;



public class HuiyuanDao {
	public static List<Huiyuan> allHuiyuanList(){
		try {
			List<Huiyuan> list = new ArrayList<>();
			String sql = "select * from Huiyuan";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Huiyuan huiyuan = convertHuiyuan(rs);
				
				list.add(huiyuan);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HuiyuanDao.allKucunList error: "+e.getMessage());
			return null;
		}
	}
	
	
	private static Huiyuan convertHuiyuan(ResultSet rs){
		Huiyuan huiyuan = new Huiyuan();
		//student.setId(rs.getLong("id"));
		try {
			huiyuan.setKehuNum(rs.getString("kehuNum"));
			huiyuan.setKehuName(rs.getString("kehuName"));
			huiyuan.setPhone(rs.getString("phone"));
			huiyuan.setDizhi(rs.getString("dizhi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return huiyuan;
	}

	public static Huiyuan findByNum(String kehuNum)
	{	
		Huiyuan huiyuan=null;
		try {
			String sql="select * from huiyuan where kehuNum='" + kehuNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			if(rs.next()){
				huiyuan = convertHuiyuan(rs);
			}
			rs.close();
			BaseDao.dbClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return huiyuan;
	}
	
	public static List<Huiyuan> findByNumLike(String kehuNum){
		try {
			List<Huiyuan> list = new ArrayList<>();
			String sql="select * from huiyuan where kehuNum like '%" + kehuNum+"%'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Huiyuan huiyuan = convertHuiyuan(rs);
				
				list.add(huiyuan);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HuiyuanDao.allHuiyuanList error: "+e.getMessage());
			return null;
		}
	}
	
	
	
	
	public static List<Huiyuan> findByClass(String kehuNum){
		try {
			List<Huiyuan> list = new ArrayList<>();

			String sql = "select * from huiyuan where kehuNum='" + kehuNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Huiyuan huiyuan = convertHuiyuan(rs);
				list.add(huiyuan);
				
			}
			rs.close();
			BaseDao.dbClose();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HuiyuanDao.allStudentList error: "+e.getMessage());
			return null;
		}
	}
	public static int addOneHuiyuan(Huiyuan hy) 
	{	
		String sql="insert into huiyuan values('" + hy.getKehuNum()+"','"
				+ hy.getKehuName()+"','"+ hy.getPhone()+"','"+ hy.getDizhi()+"')";
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("添加成功！");
		BaseDao.dbClose();
		return r;
	}
	
	public static int updateCusAndid(Huiyuan cus) 
	{	
		String sql="update huiyuan set KehuName='" + cus.getKehuName()+"',Phone='" +cus.getPhone()+"',Dizhi='" + cus.getDizhi()+"' where kehuNum='"+ cus.getKehuNum()+"'";
		System.out.print(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("修改电话成功！");
		if(r==1) System.out.println("修改地址成功！");
		BaseDao.dbClose();
		return r;
	}
	
	
	
	
	
	public static void deleteOneHuiyuan(String kehuNum) 
	{	
		String sql="delete from huiyuan where kehuNum='" + kehuNum+"'";
		System.out.println(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("删除成功！");
		BaseDao.dbClose();
	}
}
