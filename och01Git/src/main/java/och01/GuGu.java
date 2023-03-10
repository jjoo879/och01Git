package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
//@WebServlet("/GuGu")
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Parameter -> num 가져오기
		// 2. 구구단 출력
		int num = Integer.parseInt(request.getParameter("num"));
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		// 한글 엔코딩 해줘야 하는데 이거 없으묜 한글 안 나옴.
		PrintWriter out = response.getWriter();	
		out.println("<html><body>");
		out.printf("<h1>구구단 %d단</h1>", num);
		for (int i = 1; i <= 9; i++) {
				out.printf("%d * %d = %d<br>", num, i, (num*i));
		}
		out.println("</body></html>");
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
