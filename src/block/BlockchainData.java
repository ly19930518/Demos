package block;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import util.HttpRequest;

public class BlockchainData {
	private static String ippart = "192.168.2.";
	private static String sDataFileDir = "c://xxx//block";
	/**
	 * 从网络节点中同步区块链数据到本地
	 */

	
	
	public static void LoadData(){

	      //检查数据文件目录，不存在就创建

	        File dirFile = new File(sDataFileDir);

	        boolean bFile   = dirFile.exists();

	      if(!bFile ){

	         bFile = dirFile.mkdir();

	         //往新创建的本地文件里面写一个创世块
	         
	         try{

	            FileOutputStream out = new FileOutputStream(new File(dirFile+"//data.txt"));

	            out.write((Blockchain.CreateFirstBlock().toString()+"\r\n").getBytes());

	            out.close();
	            System.out.println("数据文件创建完成");
	         }catch(Exception e){ 

	         }

	      }

	     

	     

	      //扫描周边的节点，找到最长的链，下载到本地

	      int iLastLen=0;

	      String sLastChain="";

	      for(int i=0;i<255;i+=1){

	         String sThisURL="http://"+ippart+i+":8080/blockchain/chain.jsp";

	        

	         System.out.println(sThisURL);

	        

	         String sChain=HttpRequest.sendGet(sThisURL, "");

	        

	         if(sChain!=""){

	            System.out.println(sChain);

	            String sTemp[]=sChain.split("##");

	            if(sTemp.length>iLastLen){
	            	
	                iLastLen=sTemp.length;

	                sLastChain=sChain;

	            }

	         }

	      }

	     

	      try{

	         if(sLastChain!=""){

	            FileOutputStream out = new FileOutputStream(new File(dirFile+"//data.txt"));

	            //System.out.println("before:"+sLastChain);

	            sLastChain=sLastChain.replace("##", "\r\n");

	            //System.out.println("after:"+sLastChain);

	            out.write((sLastChain+"\r\n").getBytes());

	            out.close();

	         }

	      }catch(Exception e){ 

	      }
	
	}
}
