package chaoshi.view;

import java.util.List;

import chaoshi.dao.KucunDao;

import chaoshi.table.Kucun;


public class KucunView {
	public static void allKucunView(){
		int n=0;
		List<Kucun> list =KucunDao.allKucunList();
		for(Kucun s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneKucun(s);
		}
	}
	public static void classKucunsView(String cls){
		int n=0;
		List<Kucun> list =KucunDao.findByClass(cls);
		for(Kucun s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneKucun(s);
		}
	}
	public static void oneKucunView(String shangpinNum){
		Kucun k;
		k = KucunDao.findByNum(shangpinNum);
		if(k!=null)
			showOneKucun(k);

		}
	public static void showOneKucun(Kucun s){
		System.out.print("\t��Ʒ���ƣ�"+s.getShangpinNum());
		System.out.print("\t���������"+s.getKucunshuliang());
		System.out.print("\t���ʱ�䣺"+s.getRukushijian());
	}
	public static void viewCustomerbycustomer(String Customerid){
		List<Kucun> list=KucunDao.findByClass(Customerid);
		for(Kucun Customer1:list){
			System.out.print(Customer1.getShangpinNum()+"\t");
			System.out.print(Customer1.getKucunshuliang()+"\t");
			System.out.print(Customer1.getRukushijian()+"\t");

		}
	
	}
}
