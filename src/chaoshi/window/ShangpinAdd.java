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

import chaoshi.dao.ShangpinDao;
import chaoshi.table.Shangpin;
import chaoshi.util.Constant;

public class ShangpinAdd extends JFrame {
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_shangpinNum;
	private JTextField tf_shangpinNum;
	private JLabel lb_shangpinId;
	private JTextField tf_shangpinId;
	private JLabel lb_leixing;
	private JTextField tf_leixing;
	private JLabel lb_pinpai;
	private JTextField tf_pinpai;
	private JLabel lb_jinjia;
	private JTextField tf_jinjia;
	private JLabel lb_shoujia;
	private JTextField tf_shoujia;
	private JLabel lb_zhekou;
	private JTextField tf_zhekou;
	private JPanel buttonBar;
	private JButton btn_save;
	private JButton btn_close;
	
	public ShangpinAdd() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_shangpinNum = new JLabel();
		tf_shangpinNum = new JTextField();	
		lb_shangpinId = new JLabel();
		tf_shangpinId = new JTextField();
		lb_leixing= new JLabel();
		tf_leixing = new JTextField();
		lb_pinpai = new JLabel();
		tf_pinpai = new JTextField();
		lb_jinjia = new JLabel();
		tf_jinjia = new JTextField();
		lb_shoujia = new JLabel();
		tf_shoujia = new JTextField();
		lb_zhekou = new JLabel();
		tf_zhekou = new JTextField();
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

				lb_shangpinNum.setText("商品编号");
				lb_shangpinNum.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_shangpinNum);
				contentPanel.add(tf_shangpinNum);

				//---- lb_name ----
				lb_shangpinId.setText("商品名称");
				lb_shangpinId.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_shangpinId);
				contentPanel.add(tf_shangpinId);

				//---- lb_gender ----
				lb_leixing.setText("类型");
				lb_leixing.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_leixing);
				contentPanel.add(tf_leixing);

				//---- lb_id ----
				lb_pinpai.setText("品牌");
				lb_pinpai.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_pinpai);
				contentPanel.add(tf_pinpai);

				//---- lb_major ----
				lb_jinjia.setText("进价");
				lb_jinjia.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_jinjia);
				contentPanel.add(tf_jinjia);

				//---- lb_classname ----
				lb_shoujia.setText("售价");
				lb_shoujia.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_shoujia);
				contentPanel.add(tf_shoujia);
				
				lb_zhekou.setText("折扣");
				lb_zhekou.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_zhekou);
				contentPanel.add(tf_zhekou);
				

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
		Shangpin stu=new Shangpin();
		stu.setShangpinNum(tf_shangpinNum.getText());
		stu.setShangpinId(tf_shangpinId.getText());
		stu.setLeixing(tf_leixing.getText());
		stu.setPinpai(tf_pinpai.getText());
		stu.setJinjia(Double.valueOf(tf_jinjia.getText()));
		stu.setShoujia(Double.valueOf(tf_shoujia.getText()));
		stu.setZhekou(Double.valueOf(tf_zhekou.getText()));

		int i = ShangpinDao.addOneShangpin(stu);
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
