package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin.html")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		String reqUrl = request.getParameter("redurl");
		System.out.println("SSO当前登录状态:："+request.getSession().getAttribute("isLogin"));
		PrintWriter writer = response.getWriter();
		boolean isLogin = request.getSession().getAttribute("isLogin") == null ? false : true;
		if(isLogin){
			System.out.println("SSO系统：改用户已经登录 ----------------- > > > 跳转回："+url);
			response.sendRedirect(reqUrl+"?param=1&url="+url);
		}else{
			System.out.println("SSO系统：改用户没有登录");
			response.sendRedirect("noLogin.jsp");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.setHeader("Content-type","text/html;charset=UTF-8");
		String reqUrl = request.getParameter("url");
		System.out.println("SSO当前登录状态:："+request.getSession().getAttribute("isLogin"));
		PrintWriter writer = response.getWriter();
		boolean isLogin = request.getSession().getAttribute("isLogin") == null ? false : true;
		if(isLogin){
			System.out.println("SSO系统：改用户已经登录");
			writer.print("1");
		}else{
			System.out.println("SSO系统：改用户没有登录");
			writer.print("0");
		}
	}
	
	
	public static void main(String[] args) {
		File file = new File("C:/xxx/");
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bufferedWriter = new  BufferedWriter(new OutputStreamWriter(os));
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("")));
			bufferedReader.readLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
