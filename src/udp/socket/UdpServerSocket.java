package udp.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.logging.Logger;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;


/**
 * udp 服务类
 * 1.接收客户端发送来的请求
 * 2.针对客户端并返回处理请求
 */
public class UdpServerSocket {
	//1.服务端socket
	DatagramSocket socket = null;
	// 2.创建数据报，用于接收客户端发送的数据
    byte[] data = new byte[1024];// 创建字节数组，指定接收的数据包的大小
    DatagramPacket packet = null;
    //3.主机信息
    SocketAddress socketAddress = null;
    
    //构造函数  host 服务端主机ip  端口 port
    public UdpServerSocket(String ip,int port) throws SocketException {
    	socketAddress = new InetSocketAddress(ip, port);
    	socket = new DatagramSocket(socketAddress);
    	System.out.println("服务端启动成功");
	}
    
    /**
     * 处理客户端请求
     * @throws IOException 
     */
    public void receive() throws IOException{
    	packet = new DatagramPacket(data, data.length);
    	socket.receive(packet);
    	String info = new String(packet.getData(), 0,packet.getLength());
    }
    
    /**
     * 向客户端返回处理结果
     * @throws IOException 
     */
    public void response(String info) throws IOException{
    	byte[] resultData = info.getBytes();
    	DatagramPacket result = new DatagramPacket(resultData, resultData.length);
    	socket.send(result);
    	socket.close();
    }
    
    
    /**
     * 获取地址信息
     */
    public InetAddress getAddress(){
    	return packet.getAddress();
    }
    /**
     * 获取端口信息
     */
    public int getPort(){
    	return packet.getPort();
    }
    
}
