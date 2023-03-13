package DetailedPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DetailedPage.BookmarkDAO;
import DetailedPage.BookmarkVO;
import SearchMenu.SearchUI;

public class DetailedUI extends JFrame {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, n_label, k_label, g_label, label1, label2;
	JTextField text1, text2;
	JButton memo_btn, bookmark_btn, back_btn;
	JFrame f;
	String resName;		//생성자
	
	//메인함수 삭제
//	public static void main(String[] args) {
//		DetailedUI detailedUI = new DetailedUI();
//	}


	public DetailedUI(String resName) {
			
		SearchUI ui = new SearchUI();
		this.resName = resName;	//음식점 이름 받아오기 위한 생성자 
		
		System.out.println(resName+" 상세페이지");
		// 전체 프레임
		setTitle("찐찐맛집");
		setSize(360, 640);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);

		// 폰트
		Font font1 = new Font("돋움", 1, 17);

		// 1-1. 음식 정보 넣는 곳

		// 식당 이름
		l1 = new JLabel("해운대암소갈비집");
		l1.setFont(font1);
		l1.setBounds(15, 320, 312, 20);

		// 식당 주소
		l2 = new JLabel("부산 해운대구 중동2로10번길 32-10");
		l2.setFont(font1);
		l2.setBounds(15, 340, 312, 20);

		// 카테고리
		l3 = new JLabel("한식");
		l3.setFont(font1);
		l3.setBounds(15, 360, 312, 20);

		// 아이콘 + 별점
		ImageIcon icon1 = new ImageIcon("naver.jpg");
		n_label = new JLabel();
		n_label.setIcon(icon1);
		n_label.setBounds(15, 380, 15, 20);

		l4 = new JLabel("2.22");
		l4.setFont(font1);
		l4.setBounds(30, 380, 312, 20);

		ImageIcon icon2 = new ImageIcon("kakao.jpg");
		k_label = new JLabel();
		k_label.setIcon(icon2);
		k_label.setBounds(75, 380, 15, 20);

		l5 = new JLabel("3.33");
		l5.setFont(font1);
		l5.setBounds(90, 380, 312, 20);

		ImageIcon icon3 = new ImageIcon("google.jpg");
		g_label = new JLabel();
		g_label.setIcon(icon3);
		g_label.setBounds(135, 380, 15, 20);

		l6 = new JLabel("4.44");
		l6.setFont(font1);
		l6.setBounds(150, 380, 312, 20);

		// 메뉴 + 가격
		l7 = new JLabel("생갈비 - 58,000원");
		l7.setFont(font1);
		l7.setBounds(15, 400, 312, 20);

		// 음식 이미지
		ImageIcon img = new ImageIcon("img.jpg");
		l8 = new JLabel();
		l8.setIcon(img);
		l8.setBounds(15, 20, 312, 270);

		// 1-2. 이전페이지에서 식당 선택하면 상세내용 보여주기
//		String name = "null";
//		
//		RestaurantDAO dao = new RestaurantDAO();
//		RestaurantVO bag = dao.one(name);
//		l1.setText(bag.getName());
//		l2.setText(bag.getAddress());
//		l3.setText(bag.getCategory());		
//		l4.setText(Float.toString(bag.getN_stars()));
//		l4.setText(Float.toString(bag.getK_stars()));
//		l4.setText(Float.toString(bag.getG_stars()));
//		l7.setText(bag.getMenu());
//		l8.setText(bag.getImg());

		// 3-1. 북마크 저장 버튼
		ImageIcon fullStarIcon, starIcon;
		ImageIcon star1 = new ImageIcon("full_star.jpg");
		Image star2 = star1.getImage();
		Image star3 = star2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		fullStarIcon = new ImageIcon(star3);
		ImageIcon star4 = new ImageIcon("star.png");
		Image star5 = star4.getImage();
		Image star6 = star5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		starIcon = new ImageIcon(star6);
		bookmark_btn = new JButton(starIcon);
		bookmark_btn.setBounds(300, 300, 20, 20);
		bookmark_btn.setForeground(Color.white);
		bookmark_btn.setBorderPainted(false);
		// 3-2. bookmark 버튼으로 ==> 북마크 저장하기
		bookmark_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookmark = l1.getText();
				BookmarkDAO dao = new BookmarkDAO();
				BookmarkVO bag = new BookmarkVO();
				bag.setBookmark(bookmark);
				int result = dao.insert(bag);
				// 성공여부
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "북마크 저장 성공");
					// StarIcon -> FullstarIcon으로
					bookmark_btn.setIcon(fullStarIcon);
				} else {
					JOptionPane.showMessageDialog(f, "북마크 저장 실패");
				}
			}
		});

		// 2-1. 한줄평 작성 라벨
		label1 = new JLabel("● 한줄평을 작성해주세요");
		label1.setFont(font1);
		label1.setBounds(15, 440, 312, 20);

		// 2-2. 한줄평 작성 텍스트필드
		text1 = new JTextField(20);
		text1.setFont(font1);
		text1.setBounds(15, 470, 220, 40);

		// 2-3. 한줄평 작성 버튼
		memo_btn = new JButton("enter");
		memo_btn.setBounds(250, 470, 70, 40);
		memo_btn.setBackground(Color.decode("#E74C3C"));
		memo_btn.setForeground(Color.white);
		memo_btn.setBorderPainted(false);

		// 2-4. memo 버튼으로 ==> 한줄평 작성하기
		memo_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 공백방지
				String memo = text1.getText().trim();
				if (memo.isEmpty()) {
					JOptionPane.showMessageDialog(f, "1글자 이상 적어주세요");
					return;
				}

				MemoDAO dao = new MemoDAO();
				MemoVO bag = new MemoVO();
				bag.setMemo(memo);

				// 성공여부
				int result = dao.insert(bag);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "한줄평 작성 성공");
				} else {
					JOptionPane.showMessageDialog(f, "한줄평 작성 실패, 재입력해주세요");
				}
			}
		});

		// 4-1. 이전 페이지로 돌아가기 버튼
		back_btn = new JButton("back");
		back_btn.setBounds(130, 530, 70, 40);
		back_btn.setBackground(Color.LIGHT_GRAY);
		back_btn.setBorderPainted(false);

		// 4-2. back 버튼으로 ==> 이전 페이지로 돌아가기

		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 페이지 전환하면 창 닫히기
				setVisible(false);
				ui.back();
			}
		});

		// 화면에 추가하기
		add(l8); // 음식 사진
		add(l1); // 식당 이름
		add(l2); // 식당 주소
		add(l3); // 카테고리
		add(n_label);
		add(l4);
		add(k_label);
		add(l5);
		add(g_label);
		add(l6); // 아이콘 + 별점
		add(l7); // 메뉴 이름 및 가격
		add(label1); // 한줄평
		add(text1);
		add(memo_btn);
//		add(label2); //북마크
//		add(text2);
		add(bookmark_btn);
		add(back_btn); // 이전 페이지

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
