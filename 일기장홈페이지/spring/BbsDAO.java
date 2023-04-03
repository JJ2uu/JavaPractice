package com.multi.mydiary;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class BbsDAO {
	
	public int delete(BbsVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보기 (java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection객체로 가져온 값을 변수에 저장
			System.out.println("2. mySQL 연결 성공.");
			
			// 자바는 객체지향언어라 String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품 ↓
			// 외래키(FK)설정이 되어있으면 정상적으로 DELETE가 되지 않음
			String sql = "delete from bbs where writer = ? "; // 먼저 스트링에 저장하고
			PreparedStatement ps = con.prepareStatement(sql); // SQL부품 PreparedStatment를 활용해 변수에 저장
			ps.setString(1, bag.getWriter());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if (result == 1) {
				System.out.println("삭제 성공");
				ps.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public int update(BbsVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보기 (java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection객체로 가져온 값을 변수에 저장
			System.out.println("2. mySQL 연결 성공.");
			
			// 자바는 객체지향언어라 String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품 ↓
			String sql = "update bbs set title = ? where writer = ? " ; // 먼저 스트링에 저장하고
			PreparedStatement ps = con.prepareStatement(sql); // SQL부품 PreparedStatment를 활용해 변수에 저장
			ps.setString(1, bag.getTitle());
			ps.setString(2, bag.getWriter());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			
			if (result == 1) {
				System.out.println("변경 성공");
				ps.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int update1(BbsVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보기 (java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection객체로 가져온 값을 변수에 저장
			System.out.println("2. mySQL 연결 성공.");
			
			// 자바는 객체지향언어라 String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품 ↓
			String sql = "update bbs set content = ? where writer = ? " ; // 먼저 스트링에 저장하고
			PreparedStatement ps = con.prepareStatement(sql); // SQL부품 PreparedStatment를 활용해 변수에 저장
			ps.setString(1, bag.getContent());
			ps.setString(2, bag.getWriter());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if (result == 1) {
				System.out.println("변경 성공");
				ps.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int insert(BbsVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보기 (java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection객체로 가져온 값을 변수에 저장
			System.out.println("2. mySQL 연결 성공.");
			
			// 자바는 객체지향언어라 String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품 ↓
			String sql = "insert into bbs values (null, ?, ?, ?)"; // 먼저 스트링에 저장하고
			PreparedStatement ps = con.prepareStatement(sql); // SQL부품 PreparedStatment를 활용해 변수에 저장
			// DB는 유일하게 인덱스가 1부터 시작
			ps.setString(1, bag.getTitle());
			ps.setString(2, bag.getContent());
			ps.setString(3, bag.getWriter());
			// => INSERT INTO HR.MEMBER VALUES ('id', 'pw', 'name', 'tel')
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			result = ps.executeUpdate(); // insert(C), update(U), delete(D)문만 가능/ sql문 실행결과가 int값이기 때문
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if (result == 1) {
				System.out.println("작성 성공");
				ps.close();
			} else {
				System.out.println("작성 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public BbsVO one(int no) {
		ResultSet rs = null;
		BbsVO bag2 = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보기 (java --- oracle)
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection객체로 가져온 값을 변수에 저장
			System.out.println("2. mySQL 연결 성공.");
			
			// 자바는 객체지향언어라 String에 넣은 문자열을 특정한 부품으로 인식하지 못함
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품 ↓
			// 외래키(FK)설정이 되어있으면 정상적으로 DELETE가 되지 않음
			String sql = "select * from diary_bbs where no = ?"; // 먼저 스트링에 저장하고
			PreparedStatement ps = con.prepareStatement(sql); // SQL부품 PreparedStatment를 활용해 변수에 저장
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if (rs.next()) {
				System.out.println("검색 결과 있음");
				int no2 = rs.getInt(1);
				String title2 = rs.getString(2);
				String content2 = rs.getString(3);
				String writer2 = rs.getString(4);
				
				bag2 = new BbsVO();
				bag2.setNo(no2);
				bag2.setTitle(title2);
				bag2.setContent(content2);
				bag2.setWriter(writer2);
				ps.close();
			} else {
				System.out.println("검색 결과 없음");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bag2;
		
	}
	
	public ArrayList<BbsVO> list(String writer) {
		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블 
		
		//가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		//ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<BbsVO> list = new ArrayList<>();
		
		BbsVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");

			String sql = "select * from diary_bbs where writer = ?";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, writer);
			//삭제!!!! ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery(); //select문 전송시  
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			while(rs.next()) { //검색결과가 있는지 여부는 rs.next() 
				int no = rs.getInt(1);
				String title2 = rs.getString(2);
				String content2 = rs.getString(3);
				String writer2 = rs.getString(4);
				Date time = rs.getDate(5);
				
				System.out.println(time);
				
				bag = new BbsVO();
				bag.setNo(no);
				bag.setTitle(title2);
				bag.setContent(content2);
				bag.setWriter(writer2);
				bag.setTime(time);
				//4. list에 bag을 추가해주자.
				list.add(bag);
			}
			//System.out.println(result);
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return id, pw, name, tel은 XXXXX!
		//return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함.
		//검색결과가 있을 때는 bag에 데이터가 들어있음. 
		//검색결과가 없을 때는 bag에 무엇이 들어있나? null
		return list;
	}

}
