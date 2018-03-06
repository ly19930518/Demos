package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.prism.paint.Paint;

public class test5 extends JFrame{
	static int hash; 
	public test5() {
		this.setTitle("Hello World");
		this.setSize(600,500);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		String str = "yangcq";
		System.out.println(hashCode1(str));
//		System.out.println(str.hashCode());
//		System.out.println(hash(22));
		
		String s =  new String();
		System.out.println(s.hashCode());
		System.out.println(Integer.toBinaryString(-1));
		System.out.println(Integer.parseInt("01111111111111111111111111111111",2));
		System.out.println(-1 >>> 2);
		System.out.println(2 >> 4);
		
		Exception exception = new Exception();
		
	}
	
	
	 // HashMap中实现的hash算法(再hash算法)  
    static int hash(int h) {  
        // This function ensures that hashCodes that differ only by  
        // constant multiples at each bit position have a bounded  
        // number of collisions (approximately 8 at default load factor).  
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println(h);
        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.parseInt("00000000000000000000000000000000000000000000000000000000000010110",2));
        System.out.println("20:"+(h >>> 20));//00000000000010110
        System.out.println("12:"+(h>>>12));
        System.out.println("H:"+h);//h = h ^ 0;
        System.out.println("h ^ 0:"+(h = h ^ 0));
        System.out.println("7:"+(h >>> 7));
        System.out.println("4:"+(h >>> 4));
        System.out.println("h ^ 0:"+( h ^ 0));
        System.out.println("h ^ 0:"+( h ^ 1));
        return  h ^ (h >>> 7) ^ (h >>> 4);  
    } 
    
	// String类实现的hashcode方法源代码  
    static int hashCode1(String str) {  
    	System.out.println("hash:"+hash);
        int h = hash;  
        if (h == 0) {  
            int off = 0;  
            char val[] = str.toCharArray();  
            int len = str.length();  
            for (int i = 0; i < len; i++) {  
            	char v = val[off++];
            	System.out.println(v);
                h = 31 * h + v;  
                System.out.println(h);
            }  
            hash = h;
        }
        
        return h;  
    }  
}
