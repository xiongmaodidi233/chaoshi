package chaoshi.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem zj;
	private JMenuBar menuBar1;
	private JMenu menu5;
	private JMenu menu6;
	private JMenuItem mi_shangpin_add;
	private JMenuItem mi_shangpin_update;
	private JMenuItem mi_shangpin_delete;
	
	
	private JMenu menu7;
	private JMenuItem mi_kucun_add;
	private JMenuItem mi_kucun_update;
	private JMenuItem mi_kucun_delete;
	
	
	private JMenu menu1;
	private JMenuItem mi_topUp;
	private JMenuItem mi_payment;
	private JMenuItem mi_reportLoss;
	private JMenu menu2;
	private JMenuItem mi_query_shangpin;
	private JMenuItem mi_query_kucun;
	private JMenuItem mi_query_topUp;
	private JMenuItem mi_query_payment;
	private JMenu menu3;
	private JMenuItem mi_update_pass;
	private JMenuItem mi_exit;
	
	private JMenu menu9;
	private JMenuItem mi_huiyuan_add;
	private JMenuItem mi_huiyuan_update;
	private JMenuItem mi_huiyuan_delete;
	private JMenuItem mi_query_huiyuan;
	
	
	
	
	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		zj =new JMenuItem();
		menuBar1 = new JMenuBar();
		menu5 = new JMenu();					//����ά���˵���
		menu6 = new JMenu();					//ѧ��ά���˵���
		mi_shangpin_add = new JMenuItem();		//���ѧ���˵���
		mi_shangpin_update = new JMenuItem();	//�޸�ѧ���˵���
		mi_shangpin_delete = new JMenuItem();	//ɾ��ѧ���˵���
		
		
		
		menu7 = new JMenu();					//У԰��ά���˵���
		mi_kucun_add = new JMenuItem();		    //���У԰���˵���
		mi_kucun_update = new JMenuItem();		//�޸�У԰���˵���
		mi_kucun_delete = new JMenuItem();		//ɾ��У԰���˵���
		
		
		
		menu1 = new JMenu();					//У԰����ֵ���ѹ���˵���
		mi_topUp = new JMenuItem();			    //��ֵ����˵���
		mi_payment = new JMenuItem();			//���ѹ���˵���
		mi_reportLoss = new JMenuItem();		//��ʧ����˵���
		menu2 = new JMenu();					//��ѯ����˵���
		mi_query_shangpin = new JMenuItem();		//ѧ����ѯ�˵���
		mi_query_kucun = new JMenuItem();		//У԰����ѯ�˵���
		mi_query_topUp = new JMenuItem();		//��ֵ��ѯ�˵���
		mi_query_payment = new JMenuItem();		//���Ѳ�ѯ�˵���
		menu3 = new JMenu();					//ϵͳ����˵���
		mi_update_pass = new JMenuItem();		//�޸�����˵���
		mi_exit = new JMenuItem();				//�˳�ϵͳ�˵���

		menu9 = new JMenu();	
		mi_huiyuan_add = new JMenuItem();		//���ѧ���˵���
		mi_huiyuan_update = new JMenuItem();	//�޸�ѧ���˵���
		mi_huiyuan_delete = new JMenuItem();
		mi_query_huiyuan = new JMenuItem();
		
		
		//======== this ========
		setTitle("������Ϣ����ϵͳ");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//�������˵�
		{
			//���û���ά���˵�
			{	
				menu5.setText("������Ϣά��");

				//����ѧ��ά���˵�
				{	
					menu6.setText("��Ʒ��Ϣά��");

					//---- mi_student_add ----
					mi_shangpin_add.setText("���");
					mi_shangpin_add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_shangpin_addActionPerformed(e);
						}
					});
					menu6.add(mi_shangpin_add);

					//---- mi_student_update ----
					mi_shangpin_update.setText("�޸�");
					mi_shangpin_update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_shangpin_updateActionPerformed(e);
						}
					});
					menu6.add(mi_shangpin_update);

					//---- mi_student_delete ----
					mi_shangpin_delete.setText("ɾ��");
					mi_shangpin_delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_shangpin_deleteActionPerformed(e);
						}
					});
					menu6.add(mi_shangpin_delete);
				}
				menu5.add(menu6);

				
				
				
				{	
					menu9.setText("��Ա��Ϣά��");

					//---- mi_student_add ----
					mi_huiyuan_add.setText("���");
					mi_huiyuan_add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_huiyuan_addActionPerformed(e);
						}
					});
					menu9.add(mi_huiyuan_add);

					//---- mi_student_update ----
					mi_huiyuan_update.setText("�޸�");
					mi_huiyuan_update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_huiyuan_updateActionPerformed(e);
						}
					});
					menu9.add(mi_huiyuan_update);

					//---- mi_student_delete ----
					mi_huiyuan_delete.setText("ɾ��");
					mi_huiyuan_delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_huiyuan_deleteActionPerformed(e);
						}
					});
					menu9.add(mi_huiyuan_delete);
				}
				menu5.add(menu9);
				
				
				
				
				//======== menu7 ========
				{	
					menu7.setText("�����Ϣά��");

					//---- mi_student_add ----
					mi_kucun_add.setText("���");
					mi_kucun_add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_kucun_addActionPerformed(e);
						}
					});
					menu7.add(mi_kucun_add);

					//---- mi_student_update ----
					mi_kucun_update.setText("�޸�");
					mi_kucun_update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_kucun_updateActionPerformed(e);
						}
					});
					menu7.add(mi_kucun_update);

					//---- mi_student_delete ----
					mi_kucun_delete.setText("ɾ��");
					mi_kucun_delete.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mi_kucun_deleteActionPerformed(e);
						}
					});
					menu7.add(mi_kucun_delete);
				}
				menu5.add(menu7);
			}
			menuBar1.add(menu5);

			//======== menu1 ========
	

			//======== menu2 ========
			{
				menu2.setText("��ѯ����");

				//---- mi_query_student ----
				mi_query_shangpin.setText("��Ʒ��Ϣ��ѯ");
				mi_query_shangpin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_query_shangpinActionPerformed(e);
					}
				});
				menu2.add(mi_query_shangpin);

				//---- mi_query_card ----
				
				
				mi_query_kucun.setText("����ѯ");
				mi_query_kucun.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_query_kucunActionPerformed(e);
					}
				});
				menu2.add(mi_query_kucun);
				
				
				
				
				mi_query_huiyuan.setText("��Ա��ѯ");
				mi_query_huiyuan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_query_huiyuanActionPerformed(e);
					}
				});
				menu2.add(mi_query_huiyuan);
				
				

				//---- mi_query_toUp ----


				//---- mi_query_payment ----
			

			}
			menuBar1.add(menu2);
			
			
			{

				menu1.setText("�鿴�������ܼ�");

				//2.1��ֵ����˵���
//				mi_topUp.setText("daojia");
//				mi_topUp.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						mi_toUpActionPerformed(e);
//					}
//				});
//				menu1.add(mi_topUp);

				//---- mi_payment ----
	
			
				menuBar1.add(menu1);
				zj.setText("�ܼ�ͳ��");
				zj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ZJTJActionPerformed(e);
					}
				});
				menu1.add(zj);	
			}
			
				
			
			
			
			
			
			

			//======== menu3 ========
			{
				menu3.setText("ϵͳ����");

				//---- mi_update_pass ----
				mi_update_pass.setText("��������");
				mi_update_pass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_update_passActionPerformed(e);
					}
				});
				menu3.add(mi_update_pass);

				//---- mi_exit ----
				mi_exit.setText("�˳�ϵͳ");
				mi_exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mi_exitActionPerformed(e);
					}
				});
				menu3.add(mi_exit);
			}
			menuBar1.add(menu3);
		}
		setJMenuBar(menuBar1);
		setSize(675, 500);
		setLocationRelativeTo(getOwner());
		setVisible(true);
	}
	
	protected void ZJTJActionPerformed(ActionEvent e) {
		new ZJTJ();
		
	}

	private void mi_shangpin_addActionPerformed(ActionEvent e) {
		new ShangpinAdd();
	}

	private void mi_shangpin_updateActionPerformed(ActionEvent e) {
		new ShangpinUpdate();
	}

	private void mi_shangpin_deleteActionPerformed(ActionEvent e) {
		new ShangpinDelete();
	}

	private void mi_card_addActionPerformed(ActionEvent e) {
//		new CardAdd();
	}

	private void mi_card_updateActionPerformed(ActionEvent e) {
//		new CardUpdate();
	}

	private void mi_card_deleteActionPerformed(ActionEvent e) {
//		new CardDelete();
	}

	private void mi_toUpActionPerformed(ActionEvent e) {
//		new CampusCardTopUpAdd();
	}

	private void mi_paymentActionPerformed(ActionEvent e) {
//		new CampusCardPaymentAdd();
	}

	private void mi_reportLossActionPerformed(ActionEvent e) {
//		new CampusCardReportLoss();
	}
	private void mi_query_shangpinActionPerformed(ActionEvent e) {
		new ShangpinQuery();
	}

	private void mi_query_kucunActionPerformed(ActionEvent e) {
		new KucunQuery();
	}

	private void mi_query_toUpActionPerformed(ActionEvent e) {
	//	new CampusCardTopUpQuery();
	}
	

	private void mi_update_passActionPerformed(ActionEvent e) {
		new UpdatePassword();
	}
	
	private void mi_query_huiyuanActionPerformed(ActionEvent e) {
		new HuiyuanQuery();
	}
	
	
	

	
	private void mi_huiyuan_addActionPerformed(ActionEvent e) {
	new HuiyuanAdd();
	}
	private void mi_huiyuan_updateActionPerformed(ActionEvent e) {
		new HuiyuanUpdate();
		}	
	private void mi_huiyuan_deleteActionPerformed(ActionEvent e) {
		new HuiyuanDelete();
		}	

	private void mi_kucun_addActionPerformed(ActionEvent e){
	new KucunAdd();
	}
	private void mi_kucun_updateActionPerformed(ActionEvent e) {
		new KucunUpdate();
		}	
	private void mi_kucun_deleteActionPerformed(ActionEvent e) {
		new KucunDelete();
		}	
	
	
	private void mi_exitActionPerformed(ActionEvent e) {
		dispose();
	}

	public void setPurView(byte purview) {
		switch (purview) {
			//һ���û���¼
			case 0:	
				menu1.setEnabled(false);
				menu5.setEnabled(false);
				break;
			//����Ա��¼	
			case 1:	
				break;
			default:
				break;
		}
	}
}
