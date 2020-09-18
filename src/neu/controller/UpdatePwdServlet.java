package neu.controller;

import neu.service.EmpInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		String c=(String) session.getAttribute("code");
		String email=(String) session.getAttribute("email");
		if(code.equalsIgnoreCase(c)) {
			EmpInfoService empInfoServcie=new EmpInfoService();
			
			boolean flag=empInfoServcie.doUpdatePwd(email, pwd);
			if(flag) {
				response.sendRedirect("success.html");
			}else {
				response.sendRedirect("fail.html");
			}
		}else {
			response.sendRedirect("fail.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
