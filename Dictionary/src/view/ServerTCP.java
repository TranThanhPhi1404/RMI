package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6789);

			while (true) {
				Socket socket = serverSocket.accept();
    
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());

				String line = reader.readLine();
				
				if(line.equals("EXIT!")) {
					reader.close();
					out.close();
					socket.close();
					break;
				}

				out.println(handle.find(line));

				out.flush();

				reader.close();
				out.close();
				socket.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
