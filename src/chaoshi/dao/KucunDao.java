package chaoshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chaoshi.table.Kucun;
import chaoshi.table.Shangpin;


public class KucunDao {
	public static List<Kucun> allKucunList(){
		try {
			List<Kucun> list = new ArrayList<>();
			String sql = "select * from Kucun";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Kucun kucun = convertKucun(rs);
				
				list.add(kucun);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("KucunDao.allKucunList error: "+e.getMessage());
			return null;
		}
	}
	
	
	private static Kucun convertKucun(ResultSet rs){
		Kucun kucun = new Kucun();
		//student.setId(rs.getLong("id"));
		try {
			kucun.setShangpinNum(rs.getString("shangpinNum"));
			kucun.setKucunshuliang(rs.getDouble("kucunshuliang"));
			kucun.setRukushijian(rs.getString("rukushijian"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kucun;
	}

	public static Kucun findByNum(String shangpinNum)
	{	
		Kucun kucun=null;
		try {
			String sql="select * from kucun where shangpinNum='" + shangpinNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			if(rs.next()){
				kucun = convertKucun(rs);
			}
			rs.close();
			BaseDao.dbClose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kucun;
	}
	
	public static List<Kucun> findByNumLike(String shangpinNum){
		try {
			List<Kucun> list = new ArrayList<>();
			String sql="select * from kucun where shangpinNum like '%" + shangpinNum+"%'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Kucun shangpin = convertKucun(rs);
				
				list.add(shangpin);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("KucunDao.allKucunList error: "+e.getMessage());
			return null;
		}
	}
	
	
	public static List<Kucun> findByClass(String shangpinNum){
		try {
			List<Kucun> list = new ArrayList<>();

			String sql = "select * from kucun where shangpinNum='" + shangpinNum+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			while(rs.next()){
				Kucun kucun = convertKucun(rs);
				list.add(kucun);
				
			}
			rs.close();
			BaseDao.dbClose();
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("KucunDao.allStudentList error: "+e.getMessage());
			return null;
		}
	}
	public static int addOneKucun(Kucun kc) 
	{	
		String sql="insert into kucun values('" + kc.getShangpinNum()+"','"
				+ kc.getKucunshuliang()+"','"+ kc.getRukushijian()+"')";
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("添加成功！");
		BaseDao.dbClose();
		return r;
	}
	

	public static int updateCusAndid(Kucun cus) 
	{	
		String sql="update kucun set Kucunshuliang='" + cus.getKucunshuliang()+"',Rukushijian='" +cus.getRukushijian()+"' where ShangpinNum='"+ cus.getShangpinNum()+"'";
		System.out.print(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("修改电话成功！");
		if(r==1) System.out.println("修改地址成功！");
		BaseDao.dbClose();
		return r;
	}
	
	
	
	public static void deleteOneKucun(String shangpinNum) 
	{	
		String sql="delete from kucun where shangpinNum='" + shangpinNum+"'";
		System.out.println(sql);
		int r=BaseDao.executeUpdate(sql);
		if(r==1) System.out.println("删除成功！");
		BaseDao.dbClose();
	}
}
