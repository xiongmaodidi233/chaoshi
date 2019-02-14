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
			System.out.println("第"+n+"行记录为：");
			showOneShangpin(s);
		}
	}
	public static void classShangpinsView(String cls){
		int n=0;
		List<Shangpin> list =ShangpinDao.findByClass(cls);
		for(Shangpin s:list){
			n++;
			System.out.println("第"+n+"行记录为：");
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
		System.out.print("\t商品名称："+s.getShangpinNum());
		System.out.print("\t商品编号："+s.getShangpinId());
		System.out.print("\t商品类型："+s.getLeixing());
		System.out.print("\t品牌："+s.getPinpai());
		System.out.print("\t进价："+s.getJinjia());
		System.out.print("\t售价："+s.getShoujia());
		System.out.println("\t折扣："+s.getZhekou());
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
