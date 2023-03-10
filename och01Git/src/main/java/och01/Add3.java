package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {		// 아 얘는 HttpServlet 클래스를 상속받았구나!
	private static final long serialVersionUID = 1L;
       // 이 번호는 버전 번호 같은 거니까 그냥 놔두기
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목표 : 1부터 누적값 전달
		int num = Integer.parseInt(request.getParameter("num"));	// 여기 오른쪽은 반드시 문자열로 적어줌. 근데 숫자로 바꿔야 하니까 파싱해주기
		String loc = request.getParameter("loc");
		System.out.println("Add3 num -> "+num);
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("Add3 sum -> "+sum);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");		// 한글 깨짐을 방지하기 위함.
		//	공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();		// 이 객체의 아웃은 브라우저에 보여주는 것.
		out.println("<html><body>");				// 이게 sysout과의 차이점임!
		out.printf("<h1>1부터 %d까지의 합계</h1>", num);
		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
			// 이렇게 하나하나 다 적어줘야 하는 불편함 때문에 jsp를 더 많이 쓴다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
