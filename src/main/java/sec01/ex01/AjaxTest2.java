package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String result = "";
		
		PrintWriter writer = resp.getWriter();
		
		result = "<main>"+ 
					"<book>"+
						"<title>초보자를 위한 자바 프로그래밍</title>" +
						"<writer>인포북스 저 | 이병승</writer>" +                             
						"<image>http://localhost:8080/pro16/image/image1.jpg</image>"+
					"</book>"+
					"<book>"+
						"<title><![CDATA[모두의 파이썬]]></title>" +
						"<writer><![CDATA[길벗 저 | 이승찬]]></writer>" +                 
						"<image><![CDATA[http://localhost:8080/pro16/image/image2.jpg]]></image>"+
					"</book>"+
				"</main>";
		
		// <![CDATA[   ]]> 로 감쌀 이유가 없는데 왜 붙였지.. 없어도 잘 됨
		System.out.println(result);
		writer.print(result);
		
	}
}
