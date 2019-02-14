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

import chaoshi.dao.KucunDao;
import chaoshi.table.Kucun;
import chaoshi.util.Constant;

public class KucunAdd extends JFrame {
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel lb_shangpinNum;
	private JTextField tf_shangpinNum;
	private JLabel lb_kucunshuliang;
	private JTextField tf_kucunshuliang;
	private JLabel lb_rukushijian;
	private JTextField tf_rukushijian;

	private JPanel buttonBar;
	private JButton btn_save;
	private JButton btn_close;
	
	public KucunAdd() {
		initComponents();
	}

	private void initComponents() {
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		lb_shangpinNum = new JLabel();
		tf_shangpinNum = new JTextField();	
		lb_kucunshuliang = new JLabel();
		tf_kucunshuliang = new JTextField();
		lb_rukushijian= new JLabel();
		tf_rukushijian = new JTextField();

		buttonBar = new JPanel();
		btn_save = new JButton();
		btn_close = new JButton();

		//======== this ========
		setTitle("添加库存");
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
				lb_kucunshuliang.setText("库存数量");
				lb_kucunshuliang.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_kucunshuliang);
				contentPanel.add(tf_kucunshuliang);

				//---- lb_gender ----
				lb_rukushijian.setText("入库时间");
				lb_rukushijian.setHorizontalAlignment(SwingConstants.RIGHT);
				contentPanel.add(lb_rukushijian);
				contentPanel.add(tf_rukushijian);

			

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
		Kucun stu=new Kucun();
		stu.setShangpinNum(tf_shangpinNum.getText());
		stu.setKucunshuliang(Double.valueOf(tf_kucunshuliang.getText()));
		stu.setRukushijian(tf_rukushijian.getText());


		int i = KucunDao.addOneKucun(stu);
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