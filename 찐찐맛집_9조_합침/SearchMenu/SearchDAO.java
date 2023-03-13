package SearchMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import SelectDTOTest;

public class SearchDAO {
	public static Connection con;
	//기본 메소드 : 오라클 DB연결
	public SearchDAO() {
		con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Oracle DB 연결 오류");
		}
	}
	
	//1. 전체 음식점 리스트 받아오기(DTO객체로 배열로 저장 후 반환)
	public ArrayList<SearchDTO> search(){
		ResultSet rs = null;
		SearchDTO restaurant = new SearchDTO();
		ArrayList<SearchDTO> resList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM HR.PJ_RESTAURANT";	
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(1);
				String address = rs.getString(2);
				String category = rs.getString(3);
				float nStars = rs.getFloat(4);
				float kStars = rs.getFloat(5);
				float gStars = rs.getFloat(6);
				String menu = rs.getString(7);
				String img = rs.getString(8);
				int views = rs.getInt(9);
				
				restaurant = new SearchDTO();
				
				restaurant.setName(name);
				restaurant.setAddress(address);
				restaurant.setCategory(category);
				restaurant.setnStars(nStars);
				restaurant.setkStars(kStars);
				restaurant.setgStars(gStars);
				restaurant.setMenu(menu);
				restaurant.setImg(img);
				restaurant.setViews(views);
				
				resList.add(restaurant);
			}
		}
		
		catch (Exception e) {
			System.out.println("전체 음식점 리스트 받기 오류");
		}
	
		return resList;
	}
	
	//2. 지역별 음식점 리스트 받아오기 (음식점 이름만 String 객체로 배열에 저장 후 반환)
	public ArrayList<String> searchL(String location){
		ResultSet rs = null;
		ArrayList<String> resList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM HR.PJ_RESTAURANT WHERE ADDRESS LIKE '%'||?||'%'";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(1);
				resList.add(name);
			}
		}
		catch (Exception e) {
			System.out.println("지역별 음식점 리스트 받기 오류");
		}
	
		return resList;
	}
	
	//3. 북마크한 리스트 받아오기 (음식점 이름만 String 객체로 배열에 저장 후 반환)
	public ArrayList<String> searchBookmark(){
		ResultSet rs = null;
		ArrayList<String> resListL = new ArrayList<>();
		
		try {
			String sql = "SELECT RES_NAME FROM HR.PJ_BOOKMARKS WHERE ID = 'yoonj'";	
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(1);
				resListL.add(name);
			}
		}
		catch (Exception e) {
			System.out.println("북마크 리스트 받기 오류");
		}
	
		return resListL;
	}
	
	//4. 북마크 설정/해제 (처리된 행수(=1) 반환)
	public int bookmarkUpdate(String res_name){
		ResultSet rs = null;
		int execute = 0;
		
		try {
			String sql = "SELECT * FROM HR.PJ_BOOKMARKS WHERE ID = 'yoonj' AND RES_NAME = ?";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, res_name);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String deleteSql = "DELETE FROM HR.PJ_BOOKMARKS WHERE ID = 'yoonj' AND RES_NAME = ?";
				PreparedStatement ps1 = con.prepareStatement(deleteSql);
				ps1.setString(1, res_name);
				execute = ps1.executeUpdate();
			} else {
				String updateSql = "INSERT INTO HR.PJ_BOOKMARKS VALUES('yoonj', ?)";
				PreparedStatement ps2 = con.prepareStatement(updateSql);
				ps2.setString(1, res_name);
				execute = ps2.executeUpdate();
			}
			
		}
		catch (Exception e) {
			System.out.println("북마크 오류");
		}
	
		return execute;
	}
	
	//5. 조회수 카운트
	public int viewUpdate(String res_name){
		ResultSet rs = null;
		int execute = 0;
		
		try {
			String sql = "SELECT VIEWS FROM HR.PJ_RESTAURANT WHERE NAME = ?";	
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, res_name);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				int views = rs.getInt(1)+1;
				String updateSql = "UPDATE HR.PJ_RESTAURANT SET VIEWS = ? WHERE NAME = ?";
				PreparedStatement ps1 = con.prepareStatement(updateSql);
				ps1.setInt(1, views);
				ps1.setString(2, res_name);
				execute = ps1.executeUpdate();
			}
		}
		catch (Exception e) {
			System.out.println("북마크 오류");
		}
	
		return execute;
	}
}
