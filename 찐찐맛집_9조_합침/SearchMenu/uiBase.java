package SearchMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class uiBase extends JFrame{
	JButton search, ranking, mypage;
	JLabel lineUnder;
	public static void main(String[] args) {
		uiBase ui = new uiBase();
	}
	
	public uiBase() {
		//1. 프레임 설정
		setTitle("찐찐맛집");
		setSize(360, 640);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		//2. 하단 메뉴 이동 버튼 구분 라인
		lineUnder = new JLabel("─────────────────────────");
		lineUnder.setForeground(Color.decode("#E74C3C"));
		lineUnder.setBounds(10,530,360,10);
		
		//3. 하단 메뉴 이동 버튼
		search = new JButton();		//맛집 검색
		ranking = new JButton();	//맛집랭킹
		mypage = new JButton();		//마이페이지
		
		
		
		//3-1. 하단 메뉴 이동 버튼 설정
		//맛집 검색 이미지
		ImageIcon image1 = new ImageIcon("search.png");
		Image img1 = image1.getImage();
		Image setsize = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon searchIcon = new ImageIcon(setsize);
		search.setIcon(searchIcon);
		
		//맛집랭킹 이미지
		ImageIcon image2 = new ImageIcon("rank.png");
		Image img2 = image2.getImage();
		Image setsize2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon rankIcon = new ImageIcon(setsize2);
		ranking.setIcon(rankIcon);
		
		//마이페이지 이미지
		ImageIcon image3 = new ImageIcon("mypage.png");
		Image img3 = image3.getImage();
		Image setsize3 = img3.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon mypageIcon = new ImageIcon(setsize3);
		mypage.setIcon(mypageIcon);
		
		
		search.setBounds(10,550,40,40);
		ranking.setBounds(150,550,40,40);
		mypage.setBounds(290,550,40,40);
		
		search.setBackground(Color.white);
		search.setBorderPainted(false);
		search.setFocusPainted(false);
		
		ranking.setBackground(Color.white);
		ranking.setBorderPainted(false);
		ranking.setFocusPainted(false);
		
		mypage.setBackground(Color.white);
		mypage.setBorderPainted(false);
		mypage.setFocusPainted(false);
		
		
		//요소 추가
		add(lineUnder);
		add(search);
		add(ranking);
		add(mypage);
		
		//프레임 닫을 시 프로그램 실행 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		//프레임 보이기
	}
	
}