package test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class test2{
	public static void main(String[] args) {
//		terminalThread main = new terminalThread();
//		main.start();
		t1 t = new t2("1");
	}
}

/**
 *终端线程
 *	
 */
class terminalThread extends Thread{
	Scanner input  = new Scanner(System.in);
	InstructionsFactory factory = null;
	@Override
	public void run() {
		System.out.println("欢迎使用XX终端");
		factory  = new InstructionsFactory();
		while(true){
			String instr = input.nextLine();
			factory.CreateInstructions(instr);
		}
	}
}

/**
 * 指令工厂
 */
class InstructionsFactory{
	Instructions  instructions = null;
	public Instructions CreateInstructions(String instr){
		switch(instr){
			case "java version":
				instructions = new VersionInstructions();
				instructions.execute();
			break;
			case "os name":
				instructions = new OSInstructions();
				instructions.execute();
			break;
			default:
				System.out.println("不是内部或外部命令，也不是可运行程序");
			break;
		}
		return instructions;
	}
}
/**
 * 指令类
 *
 */
class Instructions{
	public Instructions() {
	}
	public void execute(){
		
	}
}

/**
 *获取版本
 *
 */
class VersionInstructions extends Instructions{
	@Override
	public void execute() {
		System.out.println(System.getProperty("java.runtime.version"));
	}
}

/**
 *系统指令类
 *
 */
class OSInstructions extends Instructions{
	@Override
	public void execute() {
		System.out.println(System.getProperty("os.name"));
	}
}
/**
 * 授权 指令类 
 *
 */
/**
 * 操作  指令类 
 * 用于对 主机控制
 * 
 * 生成对应报文  
 * 提升可维护性
 *
 */
abstract class up{
	public abstract void getup();
}

class aa extends up{

	@Override
	public void getup() {
		
	}
	
}

/**
 * 
 *
 */
abstract class t1{
	//初始化一部分参数
	public t1(String ces) {
		System.out.println("我是主类"+ces);
	}
	public void tx(){
		System.out.println("tx");
	}
	public abstract void tr();
}

class t2 extends t1{
	public t2(String ces) {
		super(ces);
		super.tx();
	}
	@Override
	public void tr() {
		System.out.println("xx");
	}
	
}


