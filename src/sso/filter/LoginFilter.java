package sso.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	private FilterConfig cinfig;
	@Override
	public void destroy() {
		System.out.println("登录过滤器结束");
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		String reqeustUrl = httpServletRequest.getRequestURI();
		
		System.out.println("我是SSO 拦截器：登录状态 --- ："+session.getAttribute("isLogin"));
		String url = httpServletRequest.getParameter("url");
		String redUrl = httpServletRequest.getParameter("redurl");
		System.out.println("sso ----- >>> 拦截到的参数"+redUrl);
		if(url != null){
			session.setAttribute("url", url);
		}
		if(redUrl != null){
			session.setAttribute("redurl", redUrl);
		}
		boolean isLogin = session.getAttribute("isLogin") == null ? false:true;
		//对登录页面不进行过滤
		String [] logins = cinfig.getInitParameter("logonStrings").split(";");
		
		System.out.println(reqeustUrl);
		if(this.isContains(logins, reqeustUrl)){
			filterChain.doFilter(request, response);
			return;
		}
		
		System.out.println("SSO登录："+isLogin);
		if(isLogin){
			filterChain.doFilter(request, response);
			return;
		}
		//没有认证  跳转
		httpServletResponse.sendRedirect("noLogin.jsp");;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("登录过滤器初始化");
		cinfig = arg0;
	}
	
	//检查是否存在
	public boolean isContains(String[] list,String str){
		for(String res:list){
			if(str.indexOf(res) != -1){
				return true;
			}
		}
		return false;
	}
	
}
