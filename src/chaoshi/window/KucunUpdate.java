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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import chaoshi.dao.BaseDao;
import chaoshi.dao.KucunDao;
import chaoshi.table.Kucun;

public class KucunUpdate extends JFrame{
	private JTable table;
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_shangpinNum;
	private JTextField tf_shangpinNum;
	private JLabel lb_kucunshuliang;
	private JTextField tf_kucunshuliang;
	private JLabel lb_rukushijian;
	private JTextField tf_rukushijian;

//	private JLabel lb_className;
//	private JTextField tf_className;
	private JPanel buttonBar;
	private JButton btn_save;
	private JButton btn_close;
	
	
	
	
	public KucunUpdate(){
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_shangpinNum = new JLabel();
		tf_shangpinNum= new JTextField();	
		lb_kucunshuliang = new JLabel();
		tf_kucunshuliang = new JTextField();
		lb_rukushijian = new JLabel();
		tf_rukushijian = new JTextField();

//		lb_className = new JLabel();
//		tf_className = new JTextField();
		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();
		//======== this ========
				setTitle("修改商品信息");
				setResizable(false);
				Container contentPane = getContentPane();
				contentPane.setLayout(new BorderLayout());
				
////主体2			
//				final JScrollPane scrollPane = new JScrollPane();
//				contentPanel.add(scrollPane);
//
//				Object[][] results=getResult(CustomerDao.findAllCustomer());
//				table = new JTable(results,heads);
//				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//				scrollPane.setViewportView(table);

//主体3				//======== dialogPane ========
				{
					dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
					dialogPane.setLayout(new BorderLayout());

					//======== contentPanel ========
					{
						contentPanel.setLayout(new GridLayout(4, 4, 3, 3));

						//---- lb_stuNum ----

						lb_shangpinNum.setText("要修改的商品编号");
						lb_shangpinNum.setHorizontalAlignment(SwingConstants.RIGHT);
						contentPanel.add(lb_shangpinNum);
						contentPanel.add(tf_shangpinNum);
						
//						lb_carid.setText("新的汽车编号");
//						lb_carid.setHorizontalAlignment(SwingConstants.RIGHT);
//						contentPanel.add(lb_carid);
//						contentPanel.add(tf_carid);

						//---- lb_name ----
						lb_kucunshuliang.setText("新的是库存数量");
						lb_kucunshuliang.setHorizontalAlignment(SwingConstants.RIGHT);
						contentPanel.add(lb_kucunshuliang);
						contentPanel.add(tf_kucunshuliang);

						//---- lb_gender ----
						lb_rukushijian.setText("新的入库时间");
						lb_rukushijian.setHorizontalAlignment(SwingConstants.RIGHT);
						contentPanel.add(lb_rukushijian);
						contentPanel.add(tf_rukushijian);
						
						

//						---- lb_id ----
//						lb_facturerid.setText("新的数量");
//						lb_facturerid.setHorizontalAlignment(SwingConstants.RIGHT);
//						contentPanel.add(lb_facturerid);
//						contentPanel.add(tf_facturerid);
//
						//---- lb_major ----
						
//
//						//---- lb_classname ----
//						lb_className.setText("地址");
//						lb_className.setHorizontalAlignment(SwingConstants.RIGHT);
//						contentPanel.add(lb_className);
//						contentPanel.add(tf_className);

					}
					dialogPane.add(contentPanel, BorderLayout.CENTER);
//主体4					//======== buttonBar ========
					{
						buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
						buttonBar.setLayout(new GridBagLayout());
						((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
						((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

						//---- btn_save ----
						btn_save.setText("确认修改");
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
////	-----按钮方法-----
	private void btn_saveActionPerformed(ActionEvent e) {
		Kucun cus=new Kucun();
		cus.setShangpinNum(tf_shangpinNum.getText());
		cus.setKucunshuliang(Double.valueOf(tf_kucunshuliang.getText()));
		cus.setRukushijian(tf_rukushijian.getText());
	
		
		//String shangpinNum = new String(tf_shangpinNum.getText());
		//String shangpinId = new String(tf_shangpinId.getText());
		//String leixing = new String(tf_leixing.getText());
		//String pinpai = new String(tf_pinpai.getText());
		//String jinjia = new String(tf_jinjia.getText());
		//String shoujia = new String(tf_shoujia.getText());
		//String zhekou = new String(tf_zhekou.getText());//获取第一次输入密码


		int i = KucunDao.updateCusAndid(cus);
		if(i == 1){
			JOptionPane.showMessageDialog(null, "修改成功");
			dispose();
		}

				
	}

	private void btn_closeActionPerformed(ActionEvent e) {
		dispose();
	}

}
