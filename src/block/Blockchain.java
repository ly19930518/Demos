package block;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import util.HttpRequest;

public class Blockchain {
	//用来存储区块

	private List<Block> lBlockchain=new ArrayList<>();   



	  

	   //Hash 一个块

	   public String Hash(Block block){

	      String sHash=null;

	     

	      //在这里Hash 一个块

	     

	      return sHash;

	   }
	   
	   //创建新块

	   public static Block NewBlock(int i,String proof,String hash,Timestamp c,String sender,String recipient){

	      Block bRet=null;

	      //在这里创建一个新块
	      bRet = new Block(i,proof,hash,c,sender,recipient);
	      
	      return bRet;

	   }
	   

	   //创始块的创建，创世块是一个块，必须是固定的信息

	   //逻辑上来说，只有在区块链产品的第一个用户第一次启动的时候，才会需要创建创世块

	   public static Block CreateFirstBlock(){

	      try{
	    	 
	         Timestamp t=new Timestamp((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2018-01-01 01:01:01").getTime());

	         return NewBlock(0,"海阔天空","",t,"","");

	      }catch(Exception e){

	         return null;

	      }

	   }
	   
	 //验证当前的成语是否符合规则

	   //pre 前一个成语

	   //cur 这一个成语

	   public static boolean ValidProof(String pre,String cur){

	     

	      //验证这个成语的头一个字是不是上一个成语的最后一个字

	      if(cur.charAt(0)!=pre.charAt(pre.length()-1)){

	         return false;

	      }
	      
	      
	     

	      //验证是否是成语

	      //http://chengyu.t086.com/chaxun.php?q=%B9%E2%C3%F7%D5%FD%B4%F3&t=ChengYu

	      String content=HttpRequest.sendGet("http://chengyu.t086.com/chaxun.php", "q="+cur+"&t=ChengYu");

	      if(content.indexOf("没有找到与您搜索相关的成语")!=-1 || content.indexOf("搜索词太长")!=-1){
	         return false;
	      }
	      
	      return true;

	   }
	   
	public static void main(String[] args) {
		System.out.println(Blockchain.ValidProof("海阔天空", "空前绝后"));;
	}
}
