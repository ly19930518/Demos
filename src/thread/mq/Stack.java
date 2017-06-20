package thread.mq;

import java.util.LinkedList;

/**
 * 队列
 * @author node1
 *
 * @param <T>
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	/**
	 * 入栈
	 */
	public void push(T t){
		storage.push(t);
	}
	/**
	 * 出栈 但不删除
	 */
	public T peek(){
		return storage.peek();
	} 
	/**
	 * 出栈
	 */
	public T pop(){
		return storage.pop();
	}
	/**
	 * 检查栈是否为空
	 */
	public boolean empty(){
		return storage.isEmpty();
	}
	/**
	 * 打印栈元素
	 */
	public String toString(){
		return storage.toString();
	}
}
