package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import VO.PJ_RestaurantVO;

public class PJ_RestaurantDAO {

	public PJ_RestaurantVO views(int num) {
		ResultSet rs = null;
		PJ_RestaurantVO bag = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "SELECT a.* FROM ( SELECT rownum AS RN, b.* FROM ( SELECT * FROM hr.PJ_RESTAURANT pr ORDER BY VIEWS DESC ) b ) a WHERE RN = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String name = rs.getString(2);
				String address = rs.getString(3);
				String category = rs.getString(4);
				String n_Stars = rs.getString(5);
				String k_Stars = rs.getString(6);
				String g_Stars = rs.getString(7);
				String menu = rs.getString(8);
				String img = rs.getString(9);
				String views = rs.getString(10);

				bag = new PJ_RestaurantVO();
				bag.setName(name);
				bag.setAddress(address);
				bag.setCategory(category);
				bag.setN_Stars(n_Stars);
				bag.setK_Stars(k_Stars);
				bag.setG_Stars(g_Stars);
				bag.setMenu(menu);
				bag.setImg(img);
				bag.setViews(views);
			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bag;
	}

	public PJ_RestaurantVO stars(int num) {
		ResultSet rs = null;
		PJ_RestaurantVO bag = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "SELECT a.* FROM ( SELECT rownum AS RN, b.* FROM ( SELECT pr.*, ROUND(((G_STARS + K_STARS + N_STARS) / 3), 2) AS avg FROM hr.PJ_RESTAURANT pr ORDER BY avg DESC ) b ) a WHERE RN = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String name = rs.getString(2);
				String address = rs.getString(3);
				String category = rs.getString(4);
				String n_Stars = rs.getString(5);
				String k_Stars = rs.getString(6);
				String g_Stars = rs.getString(7);
				String menu = rs.getString(8);
				String img = rs.getString(9);
				String views = rs.getString(10);
				String no = rs.getString(11);
				String avg = rs.getString(12);

				bag = new PJ_RestaurantVO();
				bag.setName(name);
				bag.setAddress(address);
				bag.setCategory(category);
				bag.setN_Stars(n_Stars);
				bag.setK_Stars(k_Stars);
				bag.setG_Stars(g_Stars);
				bag.setMenu(menu);
				bag.setImg(img);
				bag.setViews(views);
				bag.setNo(no);
				bag.setAvg(avg);

			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bag;
	}

	public PJ_RestaurantVO reco(int num) {
		ResultSet rs = null;
		PJ_RestaurantVO bag = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = " SELECT a.* FROM ( SELECT rownum AS RN, r.* FROM ( SELECT * FROM ( SELECT * FROM hr.PJ_RESTAURANT WHERE NO = ? ORDER BY dbms_random.random ) ) r ) a WHERE RN = 1 ";
	//		String sql = " SELECT a.* FROM ( SELECT rownum AS RN, r.* FROM ( SELECT * FROM ( SELECT * FROM hr.PJ_RESTAURANT WHERE NO = ? ) ) r ) a WHERE RN = 1 ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String name = rs.getString(2);
				String address = rs.getString(3);
				String category = rs.getString(4);
				String n_Stars = rs.getString(5);
				String k_Stars = rs.getString(6);
				String g_Stars = rs.getString(7);
				String menu = rs.getString(8);
				String img = rs.getString(9);
				String views = rs.getString(10);

				bag = new PJ_RestaurantVO();
				bag.setName(name);
				bag.setAddress(address);
				bag.setCategory(category);
				bag.setN_Stars(n_Stars);
				bag.setK_Stars(k_Stars);
				bag.setG_Stars(g_Stars);
				bag.setMenu(menu);
				bag.setImg(img);
				bag.setViews(views);

			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bag;
	}
	
	public PJ_RestaurantVO reco2(String recoName) {
		ResultSet rs = null;
		PJ_RestaurantVO bag = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "SELECT * FROM hr.PJ_RESTAURANT WHERE NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, recoName);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String name = rs.getString(1);
				String address = rs.getString(2);
				String category = rs.getString(3);
				String n_Stars = rs.getString(4);
				String k_Stars = rs.getString(5);
				String g_Stars = rs.getString(6);
				String menu = rs.getString(7);
				String img = rs.getString(8);
				String views = rs.getString(9);

				bag = new PJ_RestaurantVO();
				bag.setName(name);
				bag.setAddress(address);
				bag.setCategory(category);
				bag.setN_Stars(n_Stars);
				bag.setK_Stars(k_Stars);
				bag.setG_Stars(g_Stars);
				bag.setMenu(menu);
				bag.setImg(img);
				bag.setViews(views);

			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bag;
	}


	public int getViews(int num) {
		int viesInt = 0; // 초기화
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = " SELECT views FROM ( SELECT rownum AS RN, b.* FROM ( SELECT * FROM hr.PJ_RESTAURANT pr ORDER BY VIEWS DESC ) b ) a WHERE RN = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String views = rs.getString(1);
				viesInt = Integer.parseInt(views);
				
			} else {
				System.out.println("검색결과 없음.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viesInt;
	}
	
	public int updateViews(int num) {
		PJ_RestaurantVO VO = new PJ_RestaurantVO();
		int view = Integer.parseInt(VO.getViews());
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); 
			System.out.println("2. 오라클 연결 성공.");

			String sql = "update hr.PJ_RESTAURANT set views = (views + 1 WHERE NUMBERID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate();
			// insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("수정 성공.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(int num) {
		PJ_RestaurantVO VO = new PJ_RestaurantVO();
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); 
			System.out.println("2. 오라클 연결 성공.");
			

			String sql = "UPDATE hr.PJ_RESTAURANT SET views = ? WHERE name IN (SELECT name FROM (SELECT ROWNUM AS rn, name, views FROM (select * from hr.PJ_RESTAURANT pr ORDER BY views DESC) ) WHERE rn = 1)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate();
			// insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("수정 성공.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update2(int num) {
		PJ_RestaurantVO VO = new PJ_RestaurantVO();
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); 
			System.out.println("2. 오라클 연결 성공.");
			

			String sql = "UPDATE hr.PJ_RESTAURANT SET views = ? WHERE name IN (SELECT name FROM (SELECT ROWNUM AS rn, name, views FROM (select * from hr.PJ_RESTAURANT pr ORDER BY views DESC) ) WHERE rn = 2)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate();
			// insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("수정 성공.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int update3(int num) {
		PJ_RestaurantVO VO = new PJ_RestaurantVO();
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); 
			System.out.println("2. 오라클 연결 성공.");
			

			String sql = "UPDATE hr.PJ_RESTAURANT SET views = ? WHERE name IN (SELECT name FROM (SELECT ROWNUM AS rn, name, views FROM (select * from hr.PJ_RESTAURANT pr ORDER BY views DESC) ) WHERE rn = 3)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate();
			// insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("수정 성공.");
			}
			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}


