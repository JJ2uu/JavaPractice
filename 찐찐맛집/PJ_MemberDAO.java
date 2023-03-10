package 찐찐맛집;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;

import org.omg.CORBA.PUBLIC_MEMBER;


public class PJ_MemberDAO {
	// 1. 오라클과 연결할 부품 설계
	public int insert(PJ_MemberVO bag)  {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "insert into HR.PJ_MEMBER values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("가입 성공");
				ps.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
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

	public int telUpdate(PJ_MemberVO bag)  {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.PJ_MEMBER set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			
			if (result == 1) {
				System.out.println("수정 성공");
				ps.close();
				con.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int pwUpdate(PJ_MemberVO bag)  {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.PJ_MEMBER set pw = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getPw());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			
			if (result == 1) {
				System.out.println("비밀번호 변경 완료");
				ps.close();
				con.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int codeUpdate(PJ_MemberVO bag)  {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "update hr.PJ_MEMBER set code = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getCode());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			
			if (result == 1) {
				System.out.println("코드 생성 완료");
				ps.close();
				con.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public PJ_MemberVO one(PJ_MemberVO bag)  {
		ResultSet rs = null;
		PJ_MemberVO bag1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설계 성공.");
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "select * from hr.PJ_MEMBER where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			System.out.println("3. SQL문 객체로 만들기 성공");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색 결과 있음");
				String id2 = rs.getString(1);
				String pw2 = rs.getString(2);
				String name2 = rs.getString(3);
				String tel2 = rs.getString(4);
				System.out.println(id2 + " " + pw2 + " " + name2 + " " + tel2);
				bag1 = new PJ_MemberVO();
				bag1.setId(id2);
			} else {
				System.out.println("검색 결과 없음");
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bag1;
	}
	
	public PJ_MemberVO login(PJ_MemberVO bag) {
		// ResultSet > 기본형 데이터만 값으로 초기화, 참조형은 주소가 들어가 있어 null로 초기화
		ResultSet rs = null; // 컬럼명 + 결과 데이터를 담고 있는 테이블
		PJ_MemberVO bag3 = null;
		
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");
			Locale.setDefault(Locale.US); //맥 locale에러나신 분들만!!!
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			//String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개 
			System.out.println("2. 오라클 연결 성공.");
			
			String sql = "select * from hr.PJ_MEMBER where id = ? AND pw = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if(rs.next()) { // 검색 결과가 있는이 여부는 rs.next(). true 이면 있다. false이면 없다.
				System.out.println("검색 결과 있음");
				bag3 = new PJ_MemberVO();
				bag3.setId(rs.getString(1));
				bag3.setPw(rs.getString(2));
				bag3.setName(rs.getString(3));
				bag3.setTel(rs.getString(4));
				bag3.setCode(rs.getString(5));
			} else {
				System.out.println("검색 결과 없음");
			}
			con.close();
			ps.close();
			rs.close();
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bag3;
	
	}
}
