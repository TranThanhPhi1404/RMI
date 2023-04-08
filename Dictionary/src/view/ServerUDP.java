package view;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(6666);
			// nhan goi tin
			byte dataReceive[] = new byte[60000];
			DatagramPacket packetReceive = new DatagramPacket(dataReceive, 60000);
			
			
			while (true) {
				ds.receive(packetReceive);
				// xu ly 
				String str = new String(packetReceive.getData(), 0,packetReceive.getLength());
				String result = handle.find(str);	
				
				// Tien hanh dong goi tin
				DatagramPacket packetSent = new DatagramPacket(result.getBytes(), result.getBytes().length, packetReceive.getAddress(), packetReceive.getPort());
				System.out.println(new String(packetSent.getData(), 0, packetSent.getLength()));
				
				// Gui goi tin ket qua ve Client
				ds.send(packetSent);
			}
			

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
