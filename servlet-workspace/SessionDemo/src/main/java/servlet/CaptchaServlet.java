package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		String captcha=request.getParameter("captcha");
		HttpSession session = request.getSession(false);
		String username=(String) session.getAttribute("username");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		writer.print("<title>Final Output</title>");
		writer.print("Welcom: "+username);
	}

}
