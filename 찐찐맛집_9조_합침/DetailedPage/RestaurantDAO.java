package DetailedPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DetailedPage.RestaurantVO;

public class RestaurantDAO {

public RestaurantVO one(String name) {
		
		ResultSet rs = null;
		RestaurantVO bag = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");

			String sql = "select * from hr.pj_restaurant where name = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			rs = ps.executeQuery(); //select문 전송시 
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if(rs.next()) { //검색결과 여부는 rs.next()
				//true이면 있고, false면 없다는 의미
				System.out.println("'''''검색결과 있음, 성공'''''");
				String name2 = rs.getString(1);
				String address = rs.getString(2);
				String category = rs.getString(3);
				float n_stars = rs.getFloat(4);
				float k_stars = rs.getFloat(5);
				float g_stars = rs.getFloat(6);
				String menu = rs.getString(7);
				String price = rs.getString(8);
				String img = rs.getString(9);
				System.out.println(	name2 + " " 
									+ address + " " 
									+ category + " " 
									+ n_stars + " " 
									+ k_stars + " " 
									+ g_stars + " " 
									+ menu + " " 
									+ price + " " 
									+ img);
			} else {
				System.out.println("'''''검색결과 없음, 실패'''''");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}

}
