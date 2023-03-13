package DetailedPage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DetailedPage.MemoVO;

public class MemoDAO {
	
	//한줄평
	public int insert(MemoVO bag) {

		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			//디폴트값(ID = 'chae'), 널값(res_name), 입력값(한줄평) 저장
			String sql = "insert into hr.pj_memo values ('chae', '해운대암소갈비집', ? )";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getMemo());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("'''''한줄평 작성 성공'''''");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

}
