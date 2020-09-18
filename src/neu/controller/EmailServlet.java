package neu.controller;

import neu.service.EmpInfoService;
import neu.util.GenerateCode;
import neu.util.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//import javax.websocket.SendResult;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		EmpInfoService empServcie=new EmpInfoService();
		boolean flag=empServcie.checkEmail(email);
		if(flag) {
			//��ȡ��֤��
			String code= GenerateCode.getCode();
			//����֤�뱣�浽session��
			HttpSession session=request.getSession();
			session.setAttribute("code", code);
			session.setAttribute("email", email);
			//����֤�뷢�͸�ָ��������
			flag= SendEmail.send(email, code);
			//��ת����֤ҳ��
			if(flag) {
				response.sendRedirect("udpatepwd.html");
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
