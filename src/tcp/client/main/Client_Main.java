package tcp.client.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client_Main implements Runnable{
	private Socket socket = null;
	final String host  = "127.0.0.1";
	final int prot = 20006;
	String name= null;
	public static void main(String[] args) {
			for(int i = 0 ; i < 1000;i++){
				new Thread(new Client_Main("name"+i)).start();
			}
	}
	public Client_Main(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public void StartUp() throws IOException{
		socket = new Socket(host,prot);
		System.out.println("成功启动客户端，并成功连接服务器");
		 //获取键盘输入   
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
		//获取输出流
        PrintStream out = new PrintStream(socket.getOutputStream());  
		BufferedWriter bfwriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//获取输入流
		BufferedReader bfreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		boolean flag = true;
		while(flag){
			try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("请输入信息");
//			String msg = input.readLine();
			String msg = name+":测试";
			if("bye".equals(msg)){
				flag = false;
			}
			//				bfwriter.write(msg);
			out.println(msg);
			System.out.println("发送给服务器："+msg);
			String getmsg = bfreader.readLine();
			System.out.println("服务器："+getmsg);
		}
		socket.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			this.StartUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
