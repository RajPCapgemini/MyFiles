package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CaptchaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String captcha = request.getParameter("captcha");
		Cookie ck[]=request.getCookies();
		String username=ck[0].getValue();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		if(LoginServlet.captcha.equals(captcha)) {
			writer.println("<p style='margin: auto;'>Welcome "+username+"</p>");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("captcha.html");
			rd.forward(request, response);
		}
	}

}
