package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
	public static void main(String[] args) {
		try {
			System.out.println("    CHÀO MỪNG BẠN ĐẾN VỚI TỪ ĐIỂN VÔ TẬN");

			while (true) {
				Socket socket = new Socket("127.0.0.1", 6789);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());

				Scanner s = new Scanner(System.in);
				System.out.println("<-------------------------------------------->");
				System.out.println("Nhập từ cần tra cứu hoặc nhập \"EXIT!\" để thóat:");
				String st = s.nextLine();

				if (st.equals("EXIT!")) {
					out.println(st);
					reader.close();
					out.close();
					socket.close();
					break;
				}

				out.println(st);
				out.flush();

				String line = reader.readLine();

				System.out.println(line); 
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
