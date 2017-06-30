package tcp.servers.thread;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.net.Socket;

/**
 * server 线程类
 * @author node1
 *
 */
public class ServerThread implements Runnable{
	private Socket socket = null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//获取输出流
			OutputStream os = socket.getOutputStream();
	        PrintStream out = new PrintStream(socket.getOutputStream());  
			//获取输入流
			BufferedReader bfreader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//读取 客户端发送来的消息
			boolean flag = true;
			while(true){
				System.out.println("扫描");
				String msg = bfreader.readLine();
				System.out.println("我收到客户端的消息："+msg);
				if("bye".equals(msg)){
					flag = false;
				}
				out.println("server"+msg);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
