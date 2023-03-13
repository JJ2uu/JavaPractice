package 찐찐맛집_UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import SearchMenu.SearchUI;
import 랭킹.RankingUI;
import 찐찐맛집_DAO.PJ_BookmarksDAO;
import 찐찐맛집_DAO.PJ_MemberDAO;
import 찐찐맛집_DAO.PJ_MemoDAO;
import 찐찐맛집_VO.PJ_BookmarksVO;
import 찐찐맛집_VO.PJ_MemberVO;
import 찐찐맛집_VO.PJ_MemoVO;

public class MyPageUI {

	public static void open(String id2, String name2, String pw2, String tel2, String code2) {
		JFrame f = new JFrame();
		
		f.setSize(360, 640);
		f.setTitle("찐찐맛집");
		f.getContentPane().setBackground(Color.white);
		f.setResizable(false);
		f.setLayout(null);
		
		Font font1 = new Font("함초롬돋움", Font.BOLD, 36);
		Font font2 = new Font("함초롬돋움", Font.BOLD, 20);
		Font font3 = new Font("돋움체", Font.BOLD, 14);
		Font font4 = new Font("돋움체", Font.PLAIN, 14);
		Font font5 = new Font("돋움체", Font.PLAIN, 12);
		
		JLabel title = new JLabel("마이페이지", JLabel.CENTER);
		JLabel line = new JLabel("─────────────────────────", JLabel.CENTER);
		JLabel line2 = new JLabel("───────────────────────────────────", JLabel.CENTER);
		JLabel line3 = new JLabel("───────────────────────────────────", JLabel.CENTER);
		JLabel text = new JLabel("이름", JLabel.LEFT);
		JLabel text2 = new JLabel("아이디", JLabel.LEFT);
		JLabel text3 = new JLabel("비밀번호", JLabel.LEFT);
		JLabel text4 = new JLabel("전화번호", JLabel.LEFT);
		JLabel text5 = new JLabel("내 코드", JLabel.LEFT);
		JLabel name = new JLabel();
		JLabel id = new JLabel();
		JLabel pw = new JLabel();
		JLabel tel = new JLabel();
		JLabel re = new JLabel();
		
		// 로그인했을 때의 정보
		name.setText(name2);
		id.setText(id2);
		pw.setText(pw2);
		tel.setText(tel2);
		re.setText(code2);
		
		JButton pwUp = new JButton("수정");
		JButton telUp = new JButton("수정");
		JButton reUp = new JButton("추천인 코드 생성");
		JButton update = new JButton("수정완료");
		JButton delete = new JButton("탈퇴하기");
		
		// 북마크
		JLabel b_star = new JLabel("내 북마크");
		
		// 북마크 아이콘
		ImageIcon star1 = new ImageIcon("full_star.jpg");
		Image star2 = star1.getImage();
		Image star3 = star2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon fullStarIcon = new ImageIcon(star3);
		JLabel star_label = new JLabel();
		star_label.setIcon(fullStarIcon);
		
		// 북마크 테이블
		PJ_BookmarksDAO dao = new PJ_BookmarksDAO();
		ArrayList<PJ_BookmarksVO> list = dao.book_list();
		String[] header = {"아이디", "음식점"};
		Object[][] all = new String[list.size()][2];
		
		if (list.size() == 0) {
			System.out.println("검색결과 없음.");
		} else {
			System.out.println("검색결과는 전체 " + list.size() + "개 입니다.");
			
			for (int i = 0; i < all.length; i++) {
				all[i][0] = list.get(i).getId();
				all[i][1] = list.get(i).getRes_name();
			}
		}
		JTable b_table = new JTable(all, header);
		b_table.getColumn("아이디").setPreferredWidth(10);
		b_table.getColumn("음식점").setPreferredWidth(200);
		b_table.setRowHeight(30);
		b_table.setLayout(new FlowLayout());
		
		int y = 30 * b_table.getRowCount(); // 북마크 테이블 높이값

		// 나만의 메모
		JLabel memo = new JLabel("나의 메모");
		
		// 메모 테이블
		PJ_MemoDAO dao2 = new PJ_MemoDAO();
		ArrayList<PJ_MemoVO> list2 = dao2.memo_list();
		String[] header2 = {"음식점", "메모내용"};
		Object[][] all2 = new String[list2.size()][2];
		
		if (list2.size() == 0) {
			System.out.println("검색결과 없음");
		} else {
			System.out.println("검색결과는 전체 " + list2.size() + "개 입니다.");
			
			for (int i = 0; i < all2.length; i++) {
				all2[i][0] = list2.get(i).getRes_name();
				all2[i][1] = list2.get(i).getMemo();
			}
		}
		JTable memo_table = new JTable(all2, header2);
		memo_table.getColumn("음식점").setPreferredWidth(150);
		memo_table.getColumn("메모내용").setPreferredWidth(800);
		memo_table.setRowHeight(30);
		memo_table.setLayout(new FlowLayout());
		
		int y2 = 30 * memo_table.getRowCount(); // 메모 테이블 높이값
		
		// gnb
		JLabel lineUnder = new JLabel("─────────────────────────");

		ImageIcon icon1 = new ImageIcon("search.png");
		ImageIcon icon2 = new ImageIcon("rank.png");
		ImageIcon icon3 = new ImageIcon("mypage.png");
		
		JButton search = new JButton(icon1);
		
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SearchUI search = new SearchUI();
				search.open();
				f.dispose();
			}
		});
		
		JButton ranking = new JButton(icon2);
		
		ranking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RankingUI ranking = new RankingUI();
				ranking.open();
				f.dispose();
			}
		});
		
		JButton mypage = new JButton(icon3);

		JPanel panel = new JPanel(); //메인
		JPanel panel2 = new JPanel(); // 서브패널
		JPanel panel3 = new JPanel(); // 테이블 패널
		JPanel panel4 = new JPanel(); // 메모 패널
		panel.setLayout(null);
		panel2.setLayout(null);
		panel3.setLayout(null);
		panel4.setLayout(null);
		JScrollPane scroll = new JScrollPane();
		JScrollPane scroll2 = new JScrollPane(b_table);
		JScrollPane scroll3 = new JScrollPane(memo_table);
		
		// 비밀번호 변경 버튼
        pwUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newPw = JOptionPane.showInputDialog("새 비밀번호를 입력하세요.");
				String newPwCheck = JOptionPane.showInputDialog("새 비밀번호를 다시 입력하세요.");
				
				if (newPw.equals(newPwCheck)) {
					pw.setText(newPw);
					System.out.println("수정 반영");
					pw.setForeground(new Color(231, 76, 60));
				} else {
					JOptionPane.showMessageDialog(pw, "틀렸습니다. 다시 입력해주세요");
				}
			}
		});
        
        // 전화번호 변경 버튼
        telUp.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String newTel = JOptionPane.showInputDialog("새 전화번호를 입력하세요.");
        		tel.setText(newTel);
        		System.out.println("수정 반영");
        		tel.setForeground(new Color(231, 76, 60));
        	}
        });
        
        // 비밀번호/전화번호 변경 완료 버튼
        update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PJ_MemberDAO dao = new PJ_MemberDAO();
				PJ_MemberVO bag = new PJ_MemberVO();
				bag.setId(id2);
				bag.setPw(pw.getText());
				bag.setTel(tel.getText());
				int result = dao.pwUpdate(bag);
				int result2 = dao.telUpdate(bag);
				if (result == 1 && result2 == 1) {
					JOptionPane.showMessageDialog(pw, "수정이 완료되었습니다.");
					String pw2 = bag.getPw();
					String tel2 = bag.getTel();
					pw.setText(pw2);
					tel.setText(tel2);
					pw.setForeground(Color.black);
					tel.setForeground(Color.black);
				} else {
					System.out.println("수정 실패");
				}
			}
		});
		
        // 추천인 코드 생성 버튼
		reUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				PJ_MemberDAO dao = new PJ_MemberDAO();
				PJ_MemberVO bag = new PJ_MemberVO();
				String code = String.valueOf(r.nextInt(999999));
				bag.setId(id2);
				bag = dao.one(bag);
				
				if (bag.getCode() != null) {
					JOptionPane.showMessageDialog(title, "이미 코드가 있습니다");
					re.setText(bag.getCode());
					System.out.println(bag.getCode());
				} else if (bag.getCode() == null) {
					bag.setCode(code);
					int result = dao.codeUpdate(bag);
					if (result == 1) {
						re.setText(bag.getCode());
					}
				}
			}
		});
		
		// 회원 탈퇴 버튼
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PJ_MemberDAO dao = new PJ_MemberDAO();
				PJ_MemberVO bag = new PJ_MemberVO();
				bag.setId(id2);
				bag.setPw(pw2);
				int result = dao.delete(bag);
				if (result == 1) {
					int choice = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시곘습니까?", null, JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
						LoginUI.run();
						f.dispose();
					}
				}
			}
		});
		
		// 마이페이지 버튼
		mypage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				f.repaint();
				f.setVisible(true);
			}
		});

		// 프레임에 추가
		f.add(title);
		f.add(line);
		panel2.add(text);
		panel2.add(text2);
		panel2.add(text3);
		panel2.add(text4);
		panel2.add(text5);
		panel2.add(name);
		panel2.add(id);
		panel2.add(pw);
		panel2.add(tel);
		panel2.add(re);
		panel2.add(pwUp);
		panel2.add(telUp);
		panel2.add(reUp);
		panel2.add(update);
		panel2.add(delete);
		panel2.add(line2);
		panel2.add(star_label);
		panel2.add(b_star);
		panel3.add(b_table);
		panel2.add(line3);
		panel2.add(memo);
		panel4.add(memo_table);
		f.add(lineUnder);
		f.add(search);
		f.add(ranking);
		f.add(mypage);
		f.add(scroll);
		panel2.add(scroll2);
		panel2.add(scroll3);
		panel.add(panel2);
		panel2.add(panel3);
		panel2.add(panel4);
		scroll.setViewportView(panel);
		scroll2.setViewportView(panel3);
		scroll3.setViewportView(panel4);
		
		// 폰트
		title.setFont(font1);
		text.setFont(font3);
		text2.setFont(font3);
		text3.setFont(font3);
		text4.setFont(font3);
		text5.setFont(font3);
		name.setFont(font4);
		id.setFont(font4);
		pw.setFont(font4);
		tel.setFont(font4);
		re.setFont(font4);
		pwUp.setFont(font5);
		telUp.setFont(font5);
		reUp.setFont(font5);
		update.setFont(font3);
		delete.setFont(font3);
		b_star.setFont(font2);
		memo.setFont(font2);
		b_table.setFont(font3);
		memo_table.setFont(font5);

		// 위치 조정
		title.setBounds(3, 10, 340, 100);
		line.setBounds(3, 75, 340, 30);
		
		text.setBounds(17, 0, 100, 50);
		text2.setBounds(17, 40, 100, 50);
		text3.setBounds(17, 80, 100, 50);
		text4.setBounds(17, 120, 100, 50);
		text5.setBounds(17, 160, 100, 50);
		
		name.setBounds(97, 0, 100, 50);
		id.setBounds(97, 40, 100, 50);
		pw.setBounds(97, 80, 100, 50);
		tel.setBounds(97, 120, 100, 50);
		re.setBounds(97, 160, 100, 50);
		
		pwUp.setBounds(177, 95, 50, 20);
		telUp.setBounds(177, 135, 50, 20);
		reUp.setBounds(177, 175, 110, 20);
		
		update.setBounds(17, 220, 280, 50);
		delete.setBounds(17, 280, 280, 50);
		
		line2.setBounds(10, 340, 360, 30);
		star_label.setBounds(17, 380, 340, 30);
		b_star.setBounds(47, 380, 340, 30);
		b_table.setBounds(17, 0, 300, 150);
		
		line3.setBounds(10, 420 + y, 360, 30);
		memo.setBounds(17, 460 + y, 340, 30);
		memo_table.setBounds(0, 0, 800, 150);
		
		lineUnder.setBounds(10, 530, 360, 10);
		search.setBounds(10, 550, 40, 40);
		ranking.setBounds(150, 550, 40, 40);
		mypage.setBounds(290, 550, 40, 40);
		
		/* 스크롤 설정
		 * 1. 스크롤 안에 main panel 삽입
		 * 2. main panel 안에 sub panel  삽입
		*/
		panel.setPreferredSize(new Dimension(300, 800));
		panel2.setBounds(0, 10, 300, 3000);
		panel3.setPreferredSize(new Dimension(300, y));
		panel4.setPreferredSize(new Dimension(400, y2 + 5));
		scroll.setBounds(9, 110, 330, 400);
		scroll2.setBounds(0, 430, 360, y);
		scroll3.setBounds(17, 500 + y, 300, y2 -5 );
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// 꾸미기
		telUp.setBackground(Color.lightGray);
		telUp.setForeground(Color.darkGray);
		pwUp.setBackground(Color.lightGray);
		pwUp.setForeground(Color.darkGray);
		reUp.setBackground(new Color(231, 76, 60));
		reUp.setForeground(Color.white);
		update.setBackground(new Color(231, 76, 60));
		update.setForeground(Color.white);
		delete.setBackground(Color.darkGray);
		delete.setForeground(Color.white);
		pwUp.setBorder(null);
		telUp.setBorder(null);
		reUp.setBorder(null);
		update.setBorder(null);
		delete.setBorder(null);
		re.setForeground(new Color(231, 76, 60));
		search.setBorder(null);
		ranking.setBorder(null);
		mypage.setBorder(null);
		search.setBackground(null);
		ranking.setBackground(null);
		mypage.setBackground(null);
		lineUnder.setForeground(Color.decode("#E74C3C"));
		line2.setForeground(Color.LIGHT_GRAY);
		line3.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.white);
		panel2.setBackground(Color.white);
		panel3.setBackground(Color.white);
		panel4.setBackground(Color.white);
		panel.setBorder(null);
		panel2.setBorder(null);
		panel3.setBorder(null);
		panel4.setBorder(null);
		scroll.getViewport().setBackground(Color.white);
		scroll2.getViewport().setBackground(Color.white);
		scroll3.getViewport().setBackground(Color.white);
		scroll.setBorder(null);
		scroll2.setBorder(null);
		scroll3.setBorder(null);
		
		// 프레임 늘리지 못하게 막기
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
