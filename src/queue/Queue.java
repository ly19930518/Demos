package queue;

import java.util.LinkedList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();

	public synchronized void push(T t) {
		list.add(t);
	}

	public T peek() {
		try {
			return list.getFirst();
		} catch (Exception e) {
			return null;
		}
	}

	public void pop() {
		list.removeFirst();
	}

	public boolean empty() {
		return list.isEmpty();
	}

	public int getSize() {
		return list.size();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return list.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Math.nextAfter(1.65d, 1.76d));
		System.out.println(Math.tan(66.6d));
		System.out.println(Math.tanh(6.99d));
		System.out.println(Math.min(12, 124));
		System.out.println(Math.exp(5));
		System.out.println(Math.pow(2, 10));
		System.out.println(Math.PI);
		System.out.println(Math.abs(16.66));
	}
}
