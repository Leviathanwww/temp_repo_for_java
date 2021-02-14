package mysqlConnecter;

import java.sql.*;

public class MySQLConnecter {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/student";
	
	static final String USER = "root";
	static final String PASS = "W114514eI!";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("loading...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Moduling the Statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int Sid = rs.getInt("Sid");
				String Sname = rs.getString("Sname");
				int Ssex = rs.getInt("Ssex");
				String Sdept = rs.getString("Sdept");
				int Sage = rs.getInt("Sage");
				
				System.out.println("Sid: " + Sid);
				System.out.println("Sname: " + Sname);
				System.out.println("Ssex: " + Ssex);
				System.out.println("Sdept: " + Sdept);
				System.out.println("Sage: " + Sage);
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt != null) stmt.close();
			}catch(SQLException se2) {
				//pass
			}
			try {
				if(conn != null) conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("the end.");
		}
	}


