package chaoshi.view;

import java.util.List;

import chaoshi.dao.ShangpinDao;
import chaoshi.table.Shangpin;





public class ShangpinView {

	public static void allShangpinView(){
		int n=0;
		List<Shangpin> list =ShangpinDao.allShangpinList();
		for(Shangpin s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneShangpin(s);
		}
	}
	public static void classShangpinsView(String cls){
		int n=0;
		List<Shangpin> list =ShangpinDao.findByClass(cls);
		for(Shangpin s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneShangpin(s);
		}
	}
	public static void oneShangpinView(String shangpinNum){
		Shangpin s;
		s = ShangpinDao.findByNum(shangpinNum);
		if(s!=null)
			showOneShangpin(s);

		}
	public static void showOneShangpin(Shangpin s){
		System.out.print("\t��Ʒ���ƣ�"+s.getShangpinNum());
		System.out.print("\t��Ʒ��ţ�"+s.getShangpinId());
		System.out.print("\t��Ʒ���ͣ�"+s.getLeixing());
		System.out.print("\tƷ�ƣ�"+s.getPinpai());
		System.out.print("\t���ۣ�"+s.getJinjia());
		System.out.print("\t�ۼۣ�"+s.getShoujia());
		System.out.println("\t�ۿۣ�"+s.getZhekou());
	}
	public static void viewCustomerbycustomer(String Customerid){
		List<Shangpin> list=ShangpinDao.findByClass(Customerid);
		for(Shangpin Customer1:list){
			System.out.print(Customer1.getShangpinNum()+"\t");
			System.out.print(Customer1.getShangpinId()+"\t");
			System.out.print(Customer1.getLeixing()+"\t");
			System.out.print(Customer1.getPinpai()+"\t");
			System.out.print(Customer1.getJinjia()+"\t");
			System.out.print(Customer1.getShoujia()+"\t");
			System.out.println(Customer1.getZhekou()+"\t");
		}
	
	
	}	
}
