package view;

import java.sql.SQLException;
import java.util.Scanner;

import dao.dataDAO;
import model.data;

public class handle {
	static Scanner sc=new Scanner(System.in);
	public static void insert() throws SQLException {
		
		System.out.println("Nhập id: ");
		int id=sc.nextInt();
		System.out.println("Nhập từ vựng: ");
		String vocabulary=sc.nextLine();
		sc.nextLine();
		System.out.println("Nhập nghĩa: ");
		String mean=sc.nextLine();
		
		data dt=new data(id,vocabulary,mean);
		dataDAO.getInstance().insert(dt);
		System.out.println(dt.getMean());
	}
	public static void update() {
		System.out.println("Nhập id: ");
		int id=sc.nextInt();
		System.out.println("Nhập lại từ vựng: ");
		String vocabulary=sc.nextLine();
		sc.nextLine();
		System.out.println("Nhập lại nghĩa: ");
		String mean=sc.nextLine();
		
		data dt=new data(id,vocabulary,mean);
		dataDAO.getInstance().update(dt);
		
	}
	public static void delete() {
		System.out.println("Nhập id: ");
		int id=sc.nextInt();
		
		data dt=new data(id,"","");
		dataDAO.getInstance().delete(dt);
	}
	
	public static String find(String temp) {
		
		try {
			data dt = new data();
			dt.setVocabulary(temp.toLowerCase().trim());
			data dt2=dataDAO.getInstance().selectByVocabulary(dt);
			
			String result=""+dt2.getVocabulary()+" : "+ dt2.getMean()+"";
			return result;
			
		} catch (Exception e) {
			
			return "Không tìm thấy";
		}
		
	}
	
}
