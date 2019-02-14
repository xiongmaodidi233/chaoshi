package chaoshi.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;



import chaoshi.dao.KucunDao;
import chaoshi.table.Kucun;

public class KucunDelete extends JFrame{
	private static Statement stmt;
	private JTable table;
	private JTextField tf_id;
	private String[] heads= {"商品编号",  "库存数量", "入库时间"};
	private Object[][] getResult(List<Kucun> list){
		Object[][]results=new Object[list.size()][heads.length];
		//for(int i=0;i<list.size();i++){
		//Student stu=(Student)list.get(i);
		int i=0;
		for(Kucun stu :list){
			results[i][0]=stu.getShangpinNum();
			results[i][1]=stu.getKucunshuliang();
			results[i][2]=stu.getRukushijian();
	
			
			i++;
		}
		return results;
	}
	public KucunDelete() {
		super();
		final BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setTitle("库存删除");
		setBounds(100, 100, 593, 406);
//主体1		
		final JPanel panel_cx = new JPanel();
		getContentPane().add(panel_cx, BorderLayout.NORTH);
		
		panel_cx.setLayout(new GridLayout(1,4));
		JLabel lb_name = new JLabel("库存编号：");
		lb_name.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id = new JTextField();
		JButton btn_cx = new JButton("查询");
		btn_cx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cxActionPerformed(e);
			}
		});
		JLabel lb_blank = new JLabel("");
		panel_cx.add(lb_name);
		panel_cx.add(tf_id);
		panel_cx.add(btn_cx);
		panel_cx.add(lb_blank);
//主体2
		final JPanel panel_2 = new JPanel();
		final BorderLayout borderLayout_1 = new BorderLayout();
		borderLayout_1.setVgap(5);
		panel_2.setLayout(borderLayout_1);
		panel_2.setBorder(new EmptyBorder(5, 10, 5, 10));
		getContentPane().add(panel_2);

		final JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		Object[][] results=getResult(KucunDao.allKucunList());
		table = new JTable(results,heads);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1, false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				delect(e);
			}
		});
		button_2.setText("删除该销售信息");
		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		button_1.setText("关闭");
		panel_1.add(button_2);
		panel_1.add(button_1);
		
		
		setSize(600, 400);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}
	private void btn_cxActionPerformed(ActionEvent e) {
		String shangpinNum = tf_id.getText();	//获取订单号
				
		//执行查询操作，将查询结果显示到界面
		Object[][] results = getResult(KucunDao.findByNumLike(shangpinNum));
		DefaultTableModel model=new DefaultTableModel();
		table.setModel(model);
		model.setDataVector(results, heads);
	}
	private void delect(ActionEvent e) {
		String shangpinNum = tf_id.getText();	//获取订单号
				
		KucunDao.deleteOneKucun(shangpinNum);
		
		
	}
}
