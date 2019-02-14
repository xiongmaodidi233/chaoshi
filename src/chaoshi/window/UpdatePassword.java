package chaoshi.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import chaoshi.dao.BaseDao;
import chaoshi.util.GlobalVar;


public class UpdatePassword extends JFrame {
	public UpdatePassword() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		label2 = new JLabel();
		tf_pass1 = new JPasswordField();
		label1 = new JLabel();
		tf_pass2 = new JPasswordField();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setResizable(false);
		setTitle("\u4fee\u6539\u5bc6\u7801");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new GridLayout(2, 2));

				//---- label2 ----
				label2.setText("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801\uff1a");
				label2.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(label2);
				contentPanel.add(tf_pass1);

				//---- label1 ----
				label1.setText("\u518d\u6b21\u786e\u8ba4\u65b0\u5bc6\u7801\uff1a");
				label1.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(label1);
				contentPanel.add(tf_pass2);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("\u786e\u5b9a");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButtonActionPerformed(e);
					}
				});
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("\u53d6\u6d88");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonActionPerformed(e);
					}
				});
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(350, 155);
		setLocationRelativeTo(getOwner());
		setVisible(true);
		
	}

	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel label2;
	private JPasswordField tf_pass1;
	private JLabel label1;
	private JPasswordField tf_pass2;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	
	private void okButtonActionPerformed(ActionEvent e) {
		String pass1 = new String(tf_pass1.getPassword());	//获取第一次输入密码
		String pass2 = new String(tf_pass2.getPassword());	//获取第二次输入密码
		
		//两次输入密码不一致
		if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(this,"第一次输入的密码和第二此输入的密码不一致，请重新输入！");
			tf_pass1.setText("");
			tf_pass2.setText("");
	  		return;
		}
		
		//执行数据库操作，更改密码
		String sql = "update user set pass='" + pass1 + "' where name='"	+ GlobalVar.login_user + "'";
		int i = BaseDao.executeUpdate(sql);
		if(i==1){
			JOptionPane.showMessageDialog(null, "密码修改成功");
			dispose();
		}
	}
	
	private void cancelButtonActionPerformed(ActionEvent e) {
		dispose();
	}

}
