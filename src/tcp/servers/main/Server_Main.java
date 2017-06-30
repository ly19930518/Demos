package tcp.servers.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import tcp.servers.thread.ServerThread;

public class Server_Main {
	final int port = 20006;
	ServerSocket serverSocket = null;
	public static void main(String[] args) {
		Server_Main smain = new Server_Main();
		smain.StartUp();
	}
	public void StartUp(){
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("服务器启动成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("正在等待客户端连接.....");
		Socket socket = null;
		while(true){
			try {
				socket = serverSocket.accept();
				System.out.println("与客户端 "+socket.getInetAddress()+" 连接成功");
				new Thread(new ServerThread(socket)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
