package chaoshi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	private static String driver = "com.mysql.jdbc.Driver";	
	//private static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver"//���ݿ�����
	private static String url = "jdbc:mysql://127.0.0.1:3306/chaoshi?characterEncoding=gbk";		//����url
	//private static String url ="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=student";
	private static String dbUser = "root";								           //���ݿ��û���
	private static String dbPwd = "root";								                  //���ݿ�����
	private static Connection conn = null;
	private static Statement stmt = null;
	public static void dbConnect()
	{
		try {
			if (conn == null) {
				Class.forName(driver);										//�������ݿ�����								
				conn = DriverManager.getConnection(url, dbUser, dbPwd);		//�������ݿ�����
			} else
				return;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	/**
	 * ִ�����ݿ��ѯ����
	 * @param sql
	 * @return
	 */
	public static ResultSet executeQuery(String sql) {
		try {
			if (conn == null)
				dbConnect();
			return conn.createStatement().executeQuery(sql);			//ִ�����ݿ��ѯ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally{
			
		}
	}

	/**
	 * ִ�����ݿ���²���
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {

		try {
			if (conn == null)
				dbConnect();
			return conn.createStatement().executeUpdate(sql);				//ִ�����ݿ����
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {
			
		}
	}

	public static void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static Statement dbConnectForTransaction()
	{

		try {
			if (conn == null) {
				Class.forName(driver);										//�������ݿ�����								
				conn = DriverManager.getConnection(url, dbUser, dbPwd);		//�������ݿ�����
				conn.setAutoCommit(false);
				stmt=conn.createStatement();
			} else
				return null;
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return stmt;


	}
	
	public static void transactionCommit() 
	{
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void transactionRollback()

	{
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dbCloseForTransaction()
	{
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn = null;
		}
		
	}

}
