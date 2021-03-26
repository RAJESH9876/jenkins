package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/lti")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading form data
		HttpSession session=request.getSession();
		String captchaText=(String) session.getAttribute("captchaText");
		String captchaInput=request.getParameter("captchaInput");
		
		if(captchaText.equals(captchaInput)) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("rajesh")&& password.equals("1234")) {
			String rememberMe=request.getParameter("rememberMe");
			if(rememberMe !=null) {
				Cookie c1=new Cookie("username",username);
				c1.setMaxAge(60*60);
				Cookie c2=new Cookie("password",password);
				c2.setMaxAge(60*60);
				response.addCookie(c1);
				response.addCookie(c2);
			}
		response.sendRedirect("Welcome.html");
		}
		else
			response.sendRedirect("Login.html?error=111");
		}
		else
			response.sendRedirect("Login.html?error=222");
		
	}

	

}
