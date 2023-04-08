package view;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP {
	public static void main(String[] args) {
		try {
			// Tao UDP Socket
			DatagramSocket ds = new DatagramSocket();
			System.out.println("    CHÀO MỪNG BẠN ĐẾN VỚI TỪ ĐIỂN VÔ TẬN");
			Scanner sc= new Scanner(System.in);
			// Nhap chuoi
			while (true) {
				System.out.println("<-------------------------------------------->");
				System.out.println("Nhập từ cần tìm kiếm hoặc nhập \"EXIT!\" để thóat:!");
				String str = sc.nextLine();
				
				// Kiem tra dieu kien thoat
				if (str.equals("EXIT!"))
					break;

				// Dong goi chuoi vua nhap
				DatagramPacket packetSent = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("127.0.0.2"), 6666);
								
				// Gui goi tin qua server
				ds.send(packetSent);
				
				// Tao ra goi tin UDP
				byte dataReceive[] = new byte[60000];
				DatagramPacket packetReceive = new DatagramPacket(dataReceive, 60000);
				ds.receive(packetReceive);
				
				// Hien thi thong tin cua goi tin nhan tu Server
				String result = new String(packetReceive.getData(), 0, packetReceive.getLength());
				System.out.println(result);
				System.out.println();

			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
