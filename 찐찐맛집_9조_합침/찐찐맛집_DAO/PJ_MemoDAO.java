package 찐찐맛집_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import 찐찐맛집_VO.PJ_MemoVO;

public class PJ_MemoDAO {
	public ArrayList<PJ_MemoVO> memo_list() {
		ResultSet rs = null;
		ArrayList<PJ_MemoVO> list = new ArrayList<>();
		PJ_MemoVO bag = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			String sql = "select * from hr.PJ_MEMO";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while(rs.next()) {
				System.out.println("검색결과 있음. 성공.");
				String id2 = rs.getString(1); //res_name
				String res2 = rs.getString(2); //res_name
				String memo2= rs.getString(3); //memo
				System.out.println(	res2 + " " + memo2);
				bag = new PJ_MemoVO();
				bag.setId(id2);
				bag.setRes_name(res2);
				bag.setMemo(memo2);
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
