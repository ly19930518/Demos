package servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet(name = "Image", urlPatterns = { "/Image" })
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("id");
		response.setContentType( "text/html; charset=UTF-8");
		System.out.println(url);
		if(url != null){
			File file = new File(url);
			int size = (int) file.length();
			FileInputStream is = new FileInputStream(file);
			//将二进制传输到页面
			response.setContentType(file.getName());
			response.setHeader("Content-Disposition","attachment;filename="+file.getName()+"");
			OutputStream os = response.getOutputStream();
			int b;
			while((b=is.read()) != -1){
				os.write(b);
			}
			os.flush();
			os.close();
			BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
			System.out.println(getServletContext().getContextPath());
			System.out.println("传输完成");
		}else{
			PrintWriter  pw = response.getWriter();
			pw.write("参数错误");
			System.out.println("参数错误");
		}
	}


}
