package 찐찐맛집;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
	// 1. 오라클과 연결할 부품 설계
	public void insert()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "insert into HR.USER_INFO values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "delete from hr.USER_INFO where id = ? AND pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void telUpdate()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.USER_INFO set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pwUpdate()  {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.USER_INFO set pw = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
