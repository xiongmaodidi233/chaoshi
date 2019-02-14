package chaoshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import chaoshi.table.Zj;

public class ZjDao {
	public static List<Zj> ZjList(){
		try {
			List<Zj> list = new ArrayList<>();
			String sql = "select shangpin.shangpinNum,shangpin.jinjia,"
					+ "kucun.kucunshuliang,sum(shangpin.jinjia*kucun.kucunshuliang)"
					+ " from kucun,shangpin where kucun.shangpinNum=shangpin.shangpinNum group by shangpin.shangpinNum,shangpin.jinjia,kucun.kucunshuliang";
			ResultSet rs=BaseDao.executeQuery(sql);
			System.out.print(sql);
			while(rs.next()){
				Zj a = convertZj(rs);
				
				list.add(a);
				
			}
			rs.close();
			BaseDao.dbClose();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("StudentDao.allStudentList error: "+e.getMessage());
			return null;
		}
	}
	
	
	private static Zj convertZj(ResultSet rs){
		Zj a = new Zj();
		//student.setId(rs.getLong("id"));
		try {
			a.setSpbh(rs.getString("shangpinNum"));
			a.setJj(rs.getString("jinjia"));
			a.setSl(rs.getString("kucunshuliang"));
			a.setZj(rs.getString("sum(shangpin.jinjia*kucun.kucunshuliang)"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	public static List<Zj> findByNum(String b)
	{	
		Zj  a=null;
		try {
			List<Zj> list= new ArrayList<>();
			String sql="select * from Zj where spbh='" +b+"'";
			ResultSet rs=BaseDao.executeQuery(sql);
			if(rs.next()){
				a = convertZj(rs);
				list.add(a);			
			}
			rs.close();
			BaseDao.dbClose();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
