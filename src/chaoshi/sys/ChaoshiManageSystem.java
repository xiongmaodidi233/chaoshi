package chaoshi.sys;

import java.util.Scanner;









import chaoshi.dao.HuiyuanDao;
import chaoshi.dao.KucunDao;
import chaoshi.dao.ShangpinDao;
import chaoshi.table.Huiyuan;
import chaoshi.table.Kucun;
import chaoshi.table.Shangpin;
import chaoshi.view.HuiyuanView;
import chaoshi.view.KucunView;
import chaoshi.view.ShangpinView;


public class ChaoshiManageSystem {
	public static void main(String[] args) throws Exception{

		char userInput;
		Scanner keyboard=new Scanner(System.in);

		dispalayMenu();
		userInput=keyboard.nextLine().charAt(0);

		Shangpin sp;
		Kucun kn;
		Huiyuan hy;
		String shangpinNum;
		String kehuNum;
		while(userInput!='q')
		{
		switch(userInput){
			case 'a':
				System.out.println("��ʾ������Ʒ��Ϣ");
				ShangpinView.allShangpinView();
				break;
			case 'b':
				System.out.println("��ʾ���п����Ϣ");
				KucunView.allKucunView();
				break;
			case 'g':
				System.out.println("��ʾ���л�Ա��Ϣ");
				HuiyuanView.allHuiyuanView();
				break;
			case 'c':
				System.out.println("������Ʒ��Ϣ");
				System.out.println("��������Ʒ��ţ�");
				shangpinNum=keyboard.nextLine();
				ShangpinView.oneShangpinView(shangpinNum);
				break;
			case 'd':
				sp=new Shangpin();
				/*stu.setStuNum("1000000008");
				stu.setName("����");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("�������ѧ");
				stu.setClassName("�ƿ�13��");*/
				System.out.println("������Ҫ��ӵ���Ʒ����Ϣ");
				System.out.println("��������Ʒ���ƣ�");
				sp.setShangpinNum(keyboard.nextLine());
				System.out.println("��������Ʒ��ţ�");
				sp.setShangpinId(keyboard.nextLine());
				System.out.println("��������Ʒ���ͣ�");
				sp.setLeixing(keyboard.nextLine());
				System.out.println("��������ƷƷ�ƣ�");
				sp.setPinpai(keyboard.nextLine());
				System.out.println("��������Ʒ���ۣ�");
				sp.setJinjia(keyboard.nextDouble());
				System.out.println("��������Ʒ�ۼۣ�");
				sp.setShoujia(keyboard.nextDouble());
				System.out.println("��������Ʒ�ۿۣ�");
				sp.setZhekou(keyboard.nextDouble());
				ShangpinDao.addOneShangpin(sp);
				break;	
			case 'e':
				
				Shangpin cus=new Shangpin();
				System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
				cus.setShangpinNum(keyboard.nextLine());
				ShangpinView.viewCustomerbycustomer(cus.getShangpinNum());
				System.out.println("��������Ʒ��ţ�");
				cus.setShangpinId(keyboard.nextLine());
				System.out.println("���������ͣ�");
				cus.setLeixing(keyboard.nextLine());
				System.out.println("������Ʒ�ƣ�");
				cus.setPinpai(keyboard.nextLine());
				System.out.println("��������ۣ�");
				cus.setJinjia(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("�������ۼۣ�");
				cus.setShoujia(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("�������ۿۣ�");
				cus.setZhekou(keyboard.nextDouble());
				keyboard.nextLine();
				ShangpinDao.updateCusAndid(cus);
				break;	
			case 'f':
				System.out.println("������Ҫɾ����Ʒ�ģ�");
				shangpinNum=keyboard.nextLine();
				ShangpinDao.deleteOneShangpin(shangpinNum);
				break;
				
			case 'h':
				kn=new Kucun();
				/*stu.setStuNum("1000000008");
				stu.setName("����");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("�������ѧ");
				stu.setClassName("�ƿ�13��");*/
				System.out.println("������Ҫ��ӵĿ�����Ϣ");
				System.out.println("�����������ƣ�");
				kn.setShangpinNum(keyboard.nextLine());
				System.out.println("��������������");
				kn.setKucunshuliang(keyboard.nextDouble());
				System.out.println("���������ʱ�䣺");
				kn.setRukushijian(keyboard.nextLine());

				KucunDao.addOneKucun(kn);
				break;	
			case 'y':
				
				Kucun kc=new Kucun();
				System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
				kc.setShangpinNum(keyboard.nextLine());
				KucunView.viewCustomerbycustomer(kc.getShangpinNum());
				System.out.println("���������������");
				kc.setKucunshuliang(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("���������ʱ�䣺");
				kc.setRukushijian(keyboard.nextLine());
				
				KucunDao.updateCusAndid(kc);
				break;	
			case 'j':
				System.out.println("������Ҫɾ�������Ʒ�ı�ţ�");
				shangpinNum=keyboard.nextLine();
				KucunDao.deleteOneKucun(shangpinNum);
				break;
			
				
			case 'k':
				hy=new Huiyuan();
				/*stu.setStuNum("1000000008");
				stu.setName("����");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("�������ѧ");
				stu.setClassName("�ƿ�13��");*/
				System.out.println("������Ҫ��ӵĻ�Ա����Ϣ");
				System.out.println("������ͻ�������ƣ�");
				hy.setKehuNum(keyboard.nextLine());
				System.out.println("������ͻ����ƣ�");
				hy.setKehuName(keyboard.nextLine());
				System.out.println("������绰��");
				hy.setPhone(keyboard.nextLine());
				System.out.println("�������ַ��");
				hy.setDizhi(keyboard.nextLine());
				HuiyuanDao.addOneHuiyuan(hy);
				break;	
				
			case 'm':
				
				Huiyuan h=new Huiyuan();
				System.out.println("������Ҫ�޸ĵ���Ʒ��ţ�");
				h.setKehuNum(keyboard.nextLine());
				KucunView.viewCustomerbycustomer(h.getKehuNum());
				System.out.println("����ͻ����֣�");
				h.setKehuName(keyboard.nextLine());
				System.out.println("����绰��");
				h.setPhone(keyboard.nextLine());
				System.out.println("�����ַ��");
				h.setDizhi(keyboard.nextLine());

				
				HuiyuanDao.updateCusAndid(h);
				break;	
			case 'l':
				System.out.println("������Ҫɾ���ͻ��ı�ţ�");
				kehuNum=keyboard.nextLine();
				HuiyuanDao.deleteOneHuiyuan(kehuNum);
				break;
				
				
				
				
				
				
				
		}
		
		dispalayMenu();
		userInput=keyboard.nextLine().charAt(0);
		}
		
		keyboard.close();
	}
		
	public static void dispalayMenu()
	{
		System.out.println("��ѡ��");
		System.out.println("a-��ʾ������Ʒ��Ϣ");
		System.out.println("b-��ʾ���п����Ϣ");
		System.out.println("g-��ʾ���л�Ա��Ϣ");
		System.out.println("c-��ʾ������Ʒ��Ϣ");
		System.out.println("d-�����Ʒ��Ϣ");
		System.out.println("e-�޸�������Ʒ��Ϣ");
		System.out.println("f-ɾ����Ʒ��Ϣ");
		System.out.println("h-��ӿ����Ϣ");
		System.out.println("y-�޸Ŀ����Ϣ");
		System.out.println("j-ɾ�������Ϣ");
		System.out.println("k-��ӻ�Ա��Ϣ");
		System.out.println("m-�޸Ļ�Ա��Ϣ");
		System.out.println("l-ɾ����Ա��Ϣ");
		System.out.println("q-�˳�ϵͳ");
	}

}
