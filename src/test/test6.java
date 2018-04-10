package test;

public class test6 {
	/** 
     * 内部类，
     * 延迟加载实例 
     *      * @author liuyc 
     */  
    private static class SingleToLeaderControllor{  
        static final test6 instance = new test6();  
    }  
      
    public static test6 getInstance(){  
        return SingleToLeaderControllor.instance;  
    }  
    
    public static void main(String[] args) {
    	test6 t1 = test6.getInstance();
    	test6 t2 = test6.getInstance();
    	
		System.out.println(t1.equals(t2));
	
		System.out.println(16 << 2); // n / 2*x?
		
		int  i  =  2 ;
		i = i >> 1;
		i = i << 1;
		System.out.println(i);
	}
}
