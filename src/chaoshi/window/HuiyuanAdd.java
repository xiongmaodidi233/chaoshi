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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import chaoshi.dao.HuiyuanDao;
import chaoshi.table.Huiyuan;

import chaoshi.util.Constant;

public class HuiyuanAdd extends JFrame {
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_kehuNum;
	private JTextField tf_kehuNum;
	private JLabel lb_kehuName;
	private JTextField tf_kehuName;
	private JLabel lb_phone;
	private JTextField tf_phone;
	private JLabel lb_dizhi;
	private JTextField tf_dizhi;

	private JPanel buttonBar;
	private JButton btn_save;
	private JButton btn_close;
	
	public HuiyuanAdd() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_kehuNum = new JLabel();
		tf_kehuNum = new JTextField();	
		lb_kehuName = new JLabel();
		tf_kehuName = new JTextField();
		lb_phone= new JLabel();
		tf_phone = new JTextField();
		lb_dizhi = new JLabel();
		tf_dizhi = new JTextField();

		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();

		//======== this ========
		setTitle("添加商品");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new GridLayout(4, 4, 6, 6));

				//---- lb_stuNum ----

				lb_kehuNum.setText("会员编号");
				lb_kehuNum.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_kehuNum);
				contentPanel.add(tf_kehuNum);

				//---- lb_name ----
				lb_kehuName.setText("客户名称");
				lb_kehuName.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_kehuName);
				contentPanel.add(tf_kehuName);

				//---- lb_gender ----
				lb_phone.setText("手机");
				lb_phone.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_phone);
				contentPanel.add(tf_phone);

				//---- lb_id ----
				lb_dizhi.setText("地址");
				lb_dizhi.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_dizhi);
				contentPanel.add(tf_dizhi);


				

			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- btn_save ----
				btn_save.setText("\u4fdd\u5b58");
				btn_save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_saveActionPerformed(e);
					}
				});
				buttonBar.add(btn_save, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- btn_close ----
				btn_close.setText("\u5173\u95ed");
				btn_close.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btn_closeActionPerformed(e);
					}
				});
				buttonBar.add(btn_close, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(1500, 400);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}
	
	private void btn_saveActionPerformed(ActionEvent e) {
		//获取用户输入信息
		Huiyuan stu=new Huiyuan();
		stu.setKehuNum(tf_kehuNum.getText());
		stu.setKehuName(tf_kehuName.getText());
		stu.setPhone(tf_phone.getText());
		stu.setDizhi(tf_dizhi.getText());



		int i = HuiyuanDao.addOneHuiyuan(stu);
		if(i == 1){
			JOptionPane.showMessageDialog(null, "添加成功");
			dispose();
		}
		else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
			
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}
	
}