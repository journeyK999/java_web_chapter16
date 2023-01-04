package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {

		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/jspPrac");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean overlappedID(String id) {
		boolean result = false;
		try {
			con = dataFactory.getConnection();
			String query = "SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result FROM t_member";
			query += " WHERE id = ?";
			System.out.println("preparedStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
