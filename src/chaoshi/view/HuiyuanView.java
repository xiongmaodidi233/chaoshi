package chaoshi.view;

import java.util.List;

import chaoshi.dao.HuiyuanDao;

import chaoshi.table.Huiyuan;



public class HuiyuanView {
	public static void allHuiyuanView(){
		int n=0;
		List<Huiyuan> list =HuiyuanDao.allHuiyuanList();
		for(Huiyuan s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneHuiyuan(s);
		}
	}
	public static void classHuiyuansView(String cls){
		int n=0;
		List<Huiyuan> list =HuiyuanDao.findByClass(cls);
		for(Huiyuan s:list){
			n++;
			System.out.println("��"+n+"�м�¼Ϊ��");
			showOneHuiyuan(s);
		}
	}
	public static void oneHuiyuanView(String kehuNum){
		Huiyuan s;
		s = HuiyuanDao.findByNum(kehuNum);
		if(s!=null)
			showOneHuiyuan(s);

		}
	public static void showOneHuiyuan(Huiyuan s){
		System.out.print("\t�ͻ����ƣ�"+s.getKehuNum());
		System.out.print("\t�ͻ���ţ�"+s.getKehuName());
		System.out.print("\t�绰��"+s.getPhone());
		System.out.print("\t��ַ��"+s.getDizhi());

	}
	public static void viewCustomerbycustomer(String Customerid){
		List<Huiyuan> list=HuiyuanDao.findByClass(Customerid);
		for(Huiyuan Customer1:list){
			System.out.print(Customer1.getKehuNum()+"\t");
			System.out.print(Customer1.getKehuName()+"\t");
			System.out.print(Customer1.getPhone()+"\t");
			System.out.print(Customer1.getDizhi()+"\t");

		}
	}
}
