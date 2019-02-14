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
		//UIUtil.setUIFont(new FontUIResource("����",Font.PLAIN,20));
		initComponents();
	}
	
	//��ʼ�����
	private void initComponents() {
		lb_user = new JLabel();
		tf_user = new JTextField();
		lb_pass = new JLabel();
		pf_pass = new JPasswordField();
		btn_ok = new JButton();
		btn_cancel = new JButton();

		//======== this ========
		setTitle("��¼");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 2));

		//---- lb_user ----
		lb_user.setText("�û�����");
		lb_user.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lb_user);
		contentPane.add(tf_user);

		//---- lb_pass ----
		lb_pass.setText("���룺");
		lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lb_pass);
		contentPane.add(pf_pass);

		//---- btn_ok ----
		btn_ok.setText("ȷ��");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		});
		contentPane.add(btn_ok);

		//---- btn_cancel ----
		btn_cancel.setText("ȡ��");
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
	
	//"ȷ��"��ť��Ӧ�¼�
	private void btn_okActionPerformed(ActionEvent e) {
		String user = tf_user.getText();	//����û���
		String pass =new String(pf_pass.getPassword());//�������
		String username = "";
		int is_admin;
		
		//δ�����û���
		if (user.equals("")) {
			JOptionPane.showMessageDialog(this,"�û���������Ϊ�գ�");
		    return;
		}
		
		try { 
			//�����ݿ��в�ѯ
			String sqlStr="select * from user where name=" + "'" + user + "' and pass=" + "'" + pass + "'";
		  	ResultSet result = BaseDao.executeQuery(sqlStr);		  	
		  	if(result.next())	{
			  	username=result.getString("name");
			  	is_admin = result.getInt("is_admin");
			  				}
		  	else {
		  		JOptionPane.showMessageDialog(this,"�û��������벻��ȷ!");
		  		
		  		return;
		  	}
		  	BaseDao.dbClose();
		  	GlobalVar.login_user = username;	//��¼��ǰ�û�
		  	
		  	//����������
		  	MainFrame mainframe = new MainFrame();	
		  	mainframe.setPurView((byte)is_admin);
		  	this.dispose();
		}
		catch(Exception ex)	{
			ex.printStackTrace();
		}
	}
	
	//"ȡ��"��ť��Ӧ�¼�
	private void btn_cancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public static  void main(String args[]) {

		(new Login()).setVisible(true);
	}
}
