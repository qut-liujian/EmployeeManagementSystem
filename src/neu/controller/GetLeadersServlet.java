package neu.controller;

import neu.service.EmpInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class GetLeadersServlet
 */
@WebServlet("/GetLeadersServlet")
public class GetLeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLeadersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpInfoService empInfoServcie=new EmpInfoService();
		List<Map<String, String>> leaders=empInfoServcie.findAllLeader();
		//��Ҫ�Ѳ�ѯ������ת��Ϊjson��ʽ�ַ��������͸�ǰ��
		//[{"id":"1","emp_name":"��ϼ"},{}]
		String rst="";
		if(leaders!=null) {
			rst+="[";
			for(int i=0;i<leaders.size();i++) {
				String json="{";
				Map<String, String> map=leaders.get(i);
				json+="\"id\":\""+map.get("id")+"\",";
				json+="\"name\":\""+map.get("emp_name")+"\"";
				json += "},";
				rst+=json;
			}
			rst=rst.substring(0,rst.length()-1);
			rst+="]";
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.write(rst);
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
