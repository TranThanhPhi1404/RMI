package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.dataDAO;
import model.data;


public class testDataDAO {
	public static void main(String[] args) throws SQLException {

	entry();
//		while(true) {
//			Scanner s = new Scanner(System.in);
//			System.out.println("Nhập từ vựng:");
//			String vocabulary  = s.next();
//			s.nextLine();
//			System.out.println("Nhập nghĩa:");
//			String mean = s.nextLine();
//			
//			data find1 = new data(0,vocabulary,mean);
//			
//			 dataDAO.getInstance().insert(find1);
//		}
		
	}
	
	public static void entry() {
		int miss = 1;
		while (miss != 0) {
			System.out.println("----------------------------------------------");
			System.out.println("CHÀO MỪNG BẠN ĐẾN VỚI TỪ ĐIỂN VÔ TẬN");
			System.out.println("----------------------------------------------");
			System.out.println("Nhập 1 - Để tra cứu từ điển");
			System.out.println("Nhập 2 - Để thêm dữ liệu từ điển");
			System.out.println("Nhập 3 - Để chỉnh sửa dữ liệu từ điển");
			System.out.println("Nhập 4 - Để xóa dữ liệu từ điển");
			System.out.println("Nhập 5 - Để xem danh sách từ điển");
			System.out.println("Nhập 0 - Để thoát");
			System.out.println("----------------------------------------------");

			Scanner sc = new Scanner(System.in);
			int temp = sc.nextInt();

			switch (temp) {
			case 1: {
				try {
					Scanner s = new Scanner(System.in);
					System.out.println("Nhập từ bạn muốn tra cứu :");
					String st = s.nextLine();
					
					data find1 = new data();
					find1.setVocabulary(st);
					data dt3 = dataDAO.getInstance().selectByVocabulary(find1);
					System.out.println(dt3.getMean());
					
					break;
				} catch (Exception e) {
					System.out.println("Không tìm thấy!");
					break;
				}
				
			}
			case 2: {
				
				try {
					Scanner s = new Scanner(System.in);
					System.out.println("Nhập từ vựng:");
					String vocabulary  = s.next();
					s.nextLine();
					System.out.println("Nhập nghĩa:");
					String mean = s.nextLine();
					
					data find1 = new data(0,vocabulary,mean);
					
					 dataDAO.getInstance().insert(find1);
					
					break;
					
				} catch (Exception e) {
					System.out.println("Không tìm thấy!");
					break;
				}
			}
			case 3: {
				try {
					Scanner s = new Scanner(System.in);
					System.out.println("Nhập id:");
					int id = s.nextInt();
					System.out.println("Nhập từ vựng:");
					String vocabulary  = s.next();
					s.nextLine();
					System.out.println("Nhập nghĩa:");
					String mean = s.nextLine();
					
					data find1 = new data(id,vocabulary,mean);
					
					 dataDAO.getInstance().update(find1);
					
					
					break;
				} catch (Exception e) {
					System.out.println("Không tìm thấy!");
					break;
				}
			}
			case 4:{
				try {
					Scanner s = new Scanner(System.in);
					System.out.println("Nhập id:");
					int id = s.nextInt();
					
					data find1 = new data();
					find1.setId(id);
					dataDAO.getInstance().delete(find1);
					
					
					break;
				} catch (Exception e) {
					System.out.println("Không tìm thấy!");
					break;
				}
			}
			
			case 5:{
				ArrayList<data> list = dataDAO.getInstance().selectAll();
				for(data dt: list) {
					System.out.println(dt.toString());
				}
				break;
			}
			
			case 0: {
				miss = 0;
				break;
			}

			}
		}
	}
}
