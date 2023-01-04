package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/json")
public class JsonServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doHandle(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		String jsonInfo = req.getParameter("jsonInfo");
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("* 회원정보 *");
			System.out.println(jsonObject.get("name"));
			System.out.println(jsonObject.get("age"));
			System.out.println(jsonObject.get("gender"));
			System.out.println(jsonObject.get("nickname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
