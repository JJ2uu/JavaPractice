package com.multi.mydiary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;

// 스프링 dao는 싱글톤으로 하나만 만들게끔 설정 => 어노테이션 or xml파일에 직접 넣기

@Component //어노테이션을 이용해 dao를 ram에 스프링이 만들어줌
public class mySQL_memberDAO { //CRUD

	//메서드를 만드는 것 ==> 메서드 정의(define)!
	//메서드를 정의했다고 실행되는 것은 아니다.!
	//메서드를 쓰는 것 ==> 메서드 호출(call)!
	public int delete(mySQL_memberVO bag) {
		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");

			String sql = "delete from diary_member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			result = ps.executeUpdate(); 
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if(result == 1) {
				System.out.println("탈퇴 성공.");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public mySQL_memberVO one(mySQL_memberVO bag) {
		// ResultSet > 기본형 데이터만 값으로 초기화, 참조형은 주소가 들어가 있어 null로 초기화
		ResultSet rs = null; // 컬럼명 + 결과 데이터를 담고 있는 테이블
		mySQL_memberVO bag2 = null;
		
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");

			String sql = "select * from diary_member where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery();
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if(rs.next()) { // 검색 결과가 있는이 여부는 rs.next(). true 이면 있다. false이면 없다.
				System.out.println("검색 결과 있음");
				String id2 = rs.getString(1);
				String pw2 = rs.getString(2);
				String name2 = rs.getString(3);
				String tel2 = rs.getString(4);
				System.out.println(id2 + " " + pw2 + " " + name2 + " " + tel2);
				bag2 = new mySQL_memberVO();
				bag2.setId(id2);
				bag2.setPw(pw2);
				bag2.setName(name2);
				bag2.setTel(tel2);
			} else {
				System.out.println("검색 결과 없음");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bag2;
		
	}
	
	public int update(mySQL_memberVO bag) {
		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");
			
			String sql = "update diary_member set tel = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			result = ps.executeUpdate(); 
			//insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if(result == 1) {
				System.out.println("수정 성공.");
			}
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//public void add2() {
	public int insert(mySQL_memberVO bag) {
		int result = 0;
		
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");

			String sql = "insert into diary_member values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			result = ps.executeUpdate(); //1
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			if(result == 1) {
				System.out.println("회원가입 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public ArrayList<mySQL_memberVO> list() {
		ResultSet rs = null; //항목명 + 결과 데이터를 담고 있는 테이블 
		
		//가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		//ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미
		ArrayList<mySQL_memberVO> list = new ArrayList<>();
		
		mySQL_memberVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");

			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");

			String sql = "select * from diary_member";
			PreparedStatement ps = con.prepareStatement(sql); //PreparedStatement
			//삭제!!!! ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");
			
			rs = ps.executeQuery(); //select문 전송시  
			System.out.println("4. SQL문 mySQL로 보내기 성공.");
			while(rs.next()) { //검색결과가 있는지 여부는 rs.next() 
				//true이면 있다라는 의미, false이면 없다라는 의미 
				//1. 검색겨로가가 있으면, 
				System.out.println("검색결과 있음. 성공.");
				//2. 각 컬럼에서 값들을 꺼내오자. 
				String id2 = rs.getString(1); //id
				String pw = rs.getString("pw"); //pw
				String name = rs.getString(3); //name
				String tel = rs.getString(4); //tel
				System.out.println(	id2 + " " 
									+ pw + " " 
									+ name + " " 
									+ tel);
				//검색결과를 검색화면 UI부분을 주어야 함.
				//3. 가방을 만들자.
				bag = new mySQL_memberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				
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
	
	public mySQL_memberVO login(mySQL_memberVO bag) {
		int result = 0; // 항목명이랑 결과를 담고 있는 테이블이다.
		
		mySQL_memberVO bag2 = null;
		
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mySQL과 자바 연결할 부품 설정 성공.");
			// 2. 오라클 11g에 연결해보자. JAVA ------ Oracle
			// String url = "jdbc:mysql://localhost:3306:multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mySQL 연결 성공.");
			
			String sql = "select * from diary_member where id=? and pw=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");
			
			ResultSet rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있으면 TRUE 없으면 false
				System.out.println("검색결과 있음 성공!");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				System.out.println(id + ", " + pw + ", " + name + ", " + tel ) ;
				
				bag2 = new mySQL_memberVO();
				bag2.setId(id);
				bag2.setPw(pw);
				bag2.setName(name);
				bag2.setTel(tel);
				
				
			} else {
				System.out.println("검색 결과 없음.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag2;
	}

}