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
				System.out.println("显示所有商品信息");
				ShangpinView.allShangpinView();
				break;
			case 'b':
				System.out.println("显示所有库存信息");
				KucunView.allKucunView();
				break;
			case 'g':
				System.out.println("显示所有会员信息");
				HuiyuanView.allHuiyuanView();
				break;
			case 'c':
				System.out.println("查找商品信息");
				System.out.println("请输入商品编号：");
				shangpinNum=keyboard.nextLine();
				ShangpinView.oneShangpinView(shangpinNum);
				break;
			case 'd':
				sp=new Shangpin();
				/*stu.setStuNum("1000000008");
				stu.setName("田甜");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("计算机科学");
				stu.setClassName("计科13甲");*/
				System.out.println("请输入要添加的商品的信息");
				System.out.println("请输入商品名称：");
				sp.setShangpinNum(keyboard.nextLine());
				System.out.println("请输入商品编号：");
				sp.setShangpinId(keyboard.nextLine());
				System.out.println("请输入商品类型：");
				sp.setLeixing(keyboard.nextLine());
				System.out.println("请输入商品品牌：");
				sp.setPinpai(keyboard.nextLine());
				System.out.println("请输入商品进价：");
				sp.setJinjia(keyboard.nextDouble());
				System.out.println("请输入商品售价：");
				sp.setShoujia(keyboard.nextDouble());
				System.out.println("请输入商品折扣：");
				sp.setZhekou(keyboard.nextDouble());
				ShangpinDao.addOneShangpin(sp);
				break;	
			case 'e':
				
				Shangpin cus=new Shangpin();
				System.out.println("请输入要修改的商品编号：");
				cus.setShangpinNum(keyboard.nextLine());
				ShangpinView.viewCustomerbycustomer(cus.getShangpinNum());
				System.out.println("请输入商品编号：");
				cus.setShangpinId(keyboard.nextLine());
				System.out.println("请输入类型：");
				cus.setLeixing(keyboard.nextLine());
				System.out.println("请输入品牌：");
				cus.setPinpai(keyboard.nextLine());
				System.out.println("请输入进价：");
				cus.setJinjia(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("请输入售价：");
				cus.setShoujia(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("请输入折扣：");
				cus.setZhekou(keyboard.nextDouble());
				keyboard.nextLine();
				ShangpinDao.updateCusAndid(cus);
				break;	
			case 'f':
				System.out.println("请输入要删除商品的：");
				shangpinNum=keyboard.nextLine();
				ShangpinDao.deleteOneShangpin(shangpinNum);
				break;
				
			case 'h':
				kn=new Kucun();
				/*stu.setStuNum("1000000008");
				stu.setName("田甜");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("计算机科学");
				stu.setClassName("计科13甲");*/
				System.out.println("请输入要添加的库存的信息");
				System.out.println("请输入库存名称：");
				kn.setShangpinNum(keyboard.nextLine());
				System.out.println("请输入库存数量：");
				kn.setKucunshuliang(keyboard.nextDouble());
				System.out.println("请输入入库时间：");
				kn.setRukushijian(keyboard.nextLine());

				KucunDao.addOneKucun(kn);
				break;	
			case 'y':
				
				Kucun kc=new Kucun();
				System.out.println("请输入要修改的商品编号：");
				kc.setShangpinNum(keyboard.nextLine());
				KucunView.viewCustomerbycustomer(kc.getShangpinNum());
				System.out.println("请输入入库数量：");
				kc.setKucunshuliang(keyboard.nextDouble());
				keyboard.nextLine();
				System.out.println("请输入入库时间：");
				kc.setRukushijian(keyboard.nextLine());
				
				KucunDao.updateCusAndid(kc);
				break;	
			case 'j':
				System.out.println("请输入要删除库存商品的编号：");
				shangpinNum=keyboard.nextLine();
				KucunDao.deleteOneKucun(shangpinNum);
				break;
			
				
			case 'k':
				hy=new Huiyuan();
				/*stu.setStuNum("1000000008");
				stu.setName("田甜");
				stu.setGender("F");
				stu.setTD("111222199701020000");
				stu.setMajor("计算机科学");
				stu.setClassName("计科13甲");*/
				System.out.println("请输入要添加的会员的信息");
				System.out.println("请输入客户编号名称：");
				hy.setKehuNum(keyboard.nextLine());
				System.out.println("请输入客户名称：");
				hy.setKehuName(keyboard.nextLine());
				System.out.println("请输入电话：");
				hy.setPhone(keyboard.nextLine());
				System.out.println("请输入地址：");
				hy.setDizhi(keyboard.nextLine());
				HuiyuanDao.addOneHuiyuan(hy);
				break;	
				
			case 'm':
				
				Huiyuan h=new Huiyuan();
				System.out.println("请输入要修改的商品编号：");
				h.setKehuNum(keyboard.nextLine());
				KucunView.viewCustomerbycustomer(h.getKehuNum());
				System.out.println("请输客户名字：");
				h.setKehuName(keyboard.nextLine());
				System.out.println("请输电话：");
				h.setPhone(keyboard.nextLine());
				System.out.println("请输地址：");
				h.setDizhi(keyboard.nextLine());

				
				HuiyuanDao.updateCusAndid(h);
				break;	
			case 'l':
				System.out.println("请输入要删除客户的编号：");
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
		System.out.println("请选择：");
		System.out.println("a-显示所有商品信息");
		System.out.println("b-显示所有库存信息");
		System.out.println("g-显示所有会员信息");
		System.out.println("c-显示查找商品信息");
		System.out.println("d-添加商品信息");
		System.out.println("e-修改所有商品信息");
		System.out.println("f-删除商品信息");
		System.out.println("h-添加库存信息");
		System.out.println("y-修改库存信息");
		System.out.println("j-删除库存信息");
		System.out.println("k-添加会员信息");
		System.out.println("m-修改会员信息");
		System.out.println("l-删除会员信息");
		System.out.println("q-退出系统");
	}

}
