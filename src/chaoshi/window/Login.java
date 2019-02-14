package chaoshi.window;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import chaoshi.dao.BaseDao;
import chaoshi.util.GlobalVar;


public class Login extends JFrame {
	private JLabel lb_user;
	private JTextField tf_user;
	private JLabel lb_pass;
	private JPasswordField pf_pass;
	private JButton btn_ok;
	private JButton btn_cancel;
	
	public Login() {
		//UIUtil.setUIFont(new FontUIResource("宋体",Font.PLAIN,20));
		initComponents();
	}
	
	//初始化组件
	private void initComponents() {
		lb_user = new JLabel();
		tf_user = new JTextField();
		lb_pass = new JLabel();
		pf_pass = new JPasswordField();
		btn_ok = new JButton();
		btn_cancel = new JButton();

		//======== this ========
		setTitle("登录");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 2));

		//---- lb_user ----
		lb_user.setText("用户名：");
		lb_user.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lb_user);
		contentPane.add(tf_user);

		//---- lb_pass ----
		lb_pass.setText("密码：");
		lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lb_pass);
		contentPane.add(pf_pass);

		//---- btn_ok ----
		btn_ok.setText("确定");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		});
		contentPane.add(btn_ok);

		//---- btn_cancel ----
		btn_cancel.setText("取消");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cancelActionPerformed(e);
			}
		});
		contentPane.add(btn_cancel);
		setSize(350, 190);
		//setSize(205, 120);
		setLocationRelativeTo(getOwner());
	}
	
	//"确定"按钮响应事件
	private void btn_okActionPerformed(ActionEvent e) {
		String user = tf_user.getText();	//获得用户名
		String pass =new String(pf_pass.getPassword());//获得密码
		String username = "";
		int is_admin;
		
		//未输入用户名
		if (user.equals("")) {
			JOptionPane.showMessageDialog(this,"用户名不允许为空！");
		    return;
		}
		
		try { 
			//在数据库中查询
			String sqlStr="select * from user where name=" + "'" + user + "' and pass=" + "'" + pass + "'";
		  	ResultSet result = BaseDao.executeQuery(sqlStr);		  	
		  	if(result.next())	{
			  	username=result.getString("name");
			  	is_admin = result.getInt("is_admin");
			  				}
		  	else {
		  		JOptionPane.showMessageDialog(this,"用户名或密码不正确!");
		  		
		  		return;
		  	}
		  	BaseDao.dbClose();
		  	GlobalVar.login_user = username;	//记录当前用户
		  	
		  	//进入主界面
		  	MainFrame mainframe = new MainFrame();	
		  	mainframe.setPurView((byte)is_admin);
		  	this.dispose();
		}
		catch(Exception ex)	{
			ex.printStackTrace();
		}
	}
	
	//"取消"按钮响应事件
	private void btn_cancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public static  void main(String args[]) {

		(new Login()).setVisible(true);
	}
}
