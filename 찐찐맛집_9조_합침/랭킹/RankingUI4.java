package 랭킹;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import DAO.PJ_RestaurantDAO;
import SearchMenu.SearchUI;
import VO.PJ_RestaurantVO;
import oracle.net.aso.n;
import project01.Detailed1UIView;
import project01.DetailedUI1Stars;
import project01.DetailedUI2Stars;
import project01.DetailedUI2View;
import project01.DetailedUI3Stars;
import project01.DetailedUI3View;
import project01.DetailedUIReco;

public class RankingUI4 extends JFrame {
	JButton search, ranking, mypage, sortView, sortStars, refresh;
	JLabel lineUnder, pageTitle, lineTop, recoTitle;
	// JComboBox sort;
	Font font0, font1, font2, font3, font4, font5;
	String[] sortType = { "평점순", "조회순" }; // 정렬 방식 콤보박스 배열
	JPanel rankingList, recommend, ResInfo1, ResInfo2, ResInfo3, recoRes;
	JScrollPane scroll;
	public int timecount;
	public String recoName;
	public String recoName2;
	int sortTypeInt = 0; // 0 = 조회순, 1 = 평점순

	public static Random r = new Random(3);

	public void open() {
		setVisible(true);
	}

	public static void openRanking() {
		RankingUI4 ui = new RankingUI4();
	}

	public RankingUI4() {
		// 0. 폰트 설정
		font0 = new Font("맑은 고딕 Bold", Font.BOLD, 38);
		font1 = new Font("맑은 고딕 Bold", Font.BOLD, 23);
		font2 = new Font("맑은 고딕", Font.PLAIN, 30);
		font3 = new Font("맑은 고딕", Font.PLAIN, 14);
		font4 = new Font("맑은 고딕", Font.ITALIC, 15);
		font5 = new Font("맑은 고딕", Font.PLAIN, 5);

		// 1. 프레임 설정
		setTitle("찐찐맛집 랭킹");
		setSize(360, 640);
		setLayout(null);
		getContentPane().setBackground(Color.white);

		// 2. 하단 메뉴 이동 버튼 구분 라인
		lineUnder = new JLabel("─────────────────────────");
		lineUnder.setForeground(Color.decode("#E74C3C"));
		lineUnder.setBounds(10, 530, 360, 10);

		// 3. 하단 메뉴 이동 버튼
		search = new JButton(); // 맛집 검색
		ranking = new JButton(); // 맛집랭킹
		mypage = new JButton(); // 마이페이지

		// 3-1. 하단 메뉴 이동 버튼 설정
		// 맛집 검색 이미지
		ImageIcon image1 = new ImageIcon("search.png");
		Image img1 = image1.getImage();
		Image setsize = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon searchIcon = new ImageIcon(setsize);
		search.setIcon(searchIcon);

		// 맛집랭킹 이미지
		ImageIcon image2 = new ImageIcon("rank.png");
		Image img2 = image2.getImage();
		Image setsize2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon rankIcon = new ImageIcon(setsize2);
		ranking.setIcon(rankIcon);

		// 마이페이지 이미지
		ImageIcon image3 = new ImageIcon("mypage.png");
		Image img3 = image3.getImage();
		Image setsize3 = img3.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon mypageIcon = new ImageIcon(setsize3);
		mypage.setIcon(mypageIcon);

		search.setBounds(10, 550, 40, 40);
		ranking.setBounds(150, 550, 40, 40);
		mypage.setBounds(290, 550, 40, 40);

		search.setBackground(Color.white);
		search.setBorderPainted(false);
		search.setFocusPainted(false);

		ranking.setBackground(Color.white);
		ranking.setBorderPainted(false);
		ranking.setFocusPainted(false);

		mypage.setBackground(Color.white);
		mypage.setBorderPainted(false);
		mypage.setFocusPainted(false);

		// =============================위는 기본 틀. (수정 X)=============================

		// 아래 부터는 페이지 Contents

		// A. 맛집랭킹 타이틀
		pageTitle = new JLabel("맛집 랭킹");
		pageTitle.setFont(font0); // ☆☆☆☆☆ font 맛집 검색 타이틀이랑 똑같이 수정하기.
		pageTitle.setForeground(Color.decode("#E74C3C"));
		pageTitle.setBounds(20, 10, 180, 50); // ☆☆☆☆☆ 위치값 맛집 검색 타이틀이랑 똑같이 수정하기.

		JLabel logo = new JLabel();
		ImageIcon logoImg = new ImageIcon("icon_color.png");
		logo.setIcon(logoImg);
		logo.setBounds(290, 25, 30, 30);

		// B. 상단 구분선
		lineTop = new JLabel("──────────────────────");
		lineTop.setForeground(Color.decode("#888888"));
		lineTop.setBounds(30, 60, 360, 10); // ☆☆☆☆☆ 위치값 맛집 검색 타이틀이랑 똑같이 수정하기.

		// C. 정렬방식 콤보박스 --> JButton으로 변경하기로 함!
		// ☆☆☆☆☆ 구현 할 떄는 콤보박스 옆에 "정렬" JButton 해야 할까...!?
		// ☆☆☆☆☆ 콤보박스 색 변경, 검색페이지랑 위치 맞추기.
//		sort = new JComboBox(sortType);
//		sort.setFont(font3);
//		// sort.setBackground(Color.decode("#E74C3C"));
//		sort.setBorder(null);
//		sort.setBounds(20, 80, 80, 25);		

		// D. 음식점 리스트 (랭킹) 패널
		rankingList = new JPanel();
		rankingList.setLayout(null);
		rankingList.setPreferredSize(new Dimension(300, 300));

		// D-1. 음식점1 패널
		ResInfo1 = new JPanel();
		ResInfo1.setLayout(null);
		ResInfo1.setBounds(0, 0, 285, 100);
		ResInfo1.setBackground(Color.decode("#d4cab4"));

		// D-1-(1). 음식점1 사진 패널
		PJ_RestaurantDAO dao = new PJ_RestaurantDAO();
		PJ_RestaurantVO bag = dao.views(1);

		JPanel res1Img = new JPanel();
		res1Img.setBounds(0, 0, 100, 100);
		res1Img.setBackground(Color.decode("#000000"));
		res1Img.setLayout(null);

		JButton res1ImgLabel = new JButton();
		res1ImgLabel.setBounds(0, 0, 100, 100);
		res1Img.add(res1ImgLabel);
		res1ImgLabel.setOpaque(false);
		res1ImgLabel.setContentAreaFilled(false);
		String imgString1 = bag.getImg();
		ImageIcon imgMain1 = new ImageIcon(imgString1);
		res1ImgLabel.setIcon(imgMain1);

		// D-1-(2). 음식점1 정보 패널

		JPanel res1Cont = new JPanel();
		res1Cont.setBounds(100, 0, 185, 100);
		res1Cont.setBackground(Color.pink);

		JLabel resName1 = new JLabel();
		resName1.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
				+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
				+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
				+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
				+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
				+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
				+ "</center></html>");
		resName1.setFont(font3);
		resName1.setLayout(new FlowLayout());
		res1Cont.add(resName1);

		// D-1-(3). 음식점1 패널 조립
		ResInfo1.add(res1Img);
		ResInfo1.add(res1Cont);

		// D-2. 음식점2 패널
		ResInfo2 = new JPanel();
		ResInfo2.setLayout(null);
		ResInfo2.setBounds(0, 100, 285, 100);
		ResInfo2.setBackground(Color.decode("#e3ddcf"));

		// D-2-(1). 음식점2 사진 패널
		bag = dao.views(2);

		JPanel res2Img = new JPanel();
		res2Img.setBounds(0, 0, 100, 100);
		res2Img.setBackground(Color.decode("#000000"));
		res2Img.setLayout(null);

		JButton res2ImgLabel = new JButton();
		res2ImgLabel.setBounds(0, 0, 100, 100);
		res2Img.add(res2ImgLabel);
		res2ImgLabel.setOpaque(false);
		res2ImgLabel.setContentAreaFilled(false);
		String imgString2 = bag.getImg();
		ImageIcon imgMain2 = new ImageIcon(imgString2);
		res2ImgLabel.setIcon(imgMain2);

		// D-2-(2). 음식점2 정보 패널

		JPanel res2Cont = new JPanel();
		res2Cont.setBounds(100, 0, 185, 100);
		res2Cont.setBackground(Color.decode("#e3ddcf"));

		JLabel resName2 = new JLabel();
		resName2.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
				+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
				+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
				+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
				+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
				+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
				+ "</center></html>");
		resName2.setFont(font3);
		resName2.setLayout(new FlowLayout());
		res2Cont.add(resName2);

		// D-2-(3). 음식점2 패널 조립
		ResInfo2.add(res2Img);
		ResInfo2.add(res2Cont);

		// D-3. 음식점3 패널
		ResInfo3 = new JPanel();
		ResInfo3.setLayout(null);
		ResInfo3.setBounds(0, 200, 285, 100);
		ResInfo3.setBackground(Color.decode("#e3ddcf"));

		// D-3-(1). 음식점3 사진 패널
		bag = dao.views(3);

		JPanel res3Img = new JPanel();
		res3Img.setBounds(0, 0, 100, 100);
		res3Img.setBackground(Color.decode("#000000"));
		res3Img.setLayout(null);

		JButton res3ImgLabel = new JButton();
		res3ImgLabel.setBounds(0, 0, 100, 100);
		res3Img.add(res3ImgLabel);
		res3ImgLabel.setOpaque(false);
		res3ImgLabel.setContentAreaFilled(false);
		String imgString3 = bag.getImg();
		ImageIcon imgMain3 = new ImageIcon(imgString3);
		res3ImgLabel.setIcon(imgMain3);

		// D-3-(2). 음식점3 정보 패널

		JPanel res3Cont = new JPanel();
		res3Cont.setBounds(100, 0, 185, 100);
		res3Cont.setBackground(Color.pink);

		bag = dao.views(3);
		JLabel resName3 = new JLabel();
		resName3.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
				+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
				+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
				+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
				+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
				+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
				+ "</center></html>");
		resName3.setFont(font3);
		resName3.setLayout(new FlowLayout());
		res3Cont.add(resName3);

		// D-3-(3). 음식점3 패널 조립
		ResInfo3.add(res3Img);
		ResInfo3.add(res3Cont);

		// D-4. 패널 조립
		rankingList.add(ResInfo1);
		rankingList.add(ResInfo2);
		rankingList.add(ResInfo3);

		// D-5. 스크롤바
		scroll = new JScrollPane();
		scroll.setBounds(25, 120, 300, 200);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setViewportView(rankingList);

		// C. 정렬방식 버튼

		// C-1. 조회순
		sortView = new JButton("조회순");
		sortView.setBounds(70, 80, 90, 30);
		sortView.setBackground(Color.decode("#E74C3C"));
		sortView.setForeground(Color.white);
		sortView.setBorderPainted(false);

		sortView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sortView.setBackground(Color.decode("#E74C3C"));
				sortView.setForeground(Color.white);
				sortStars.setBackground(Color.lightGray);
				sortStars.setForeground(Color.black);
				sortTypeInt = 0;

				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();
				PJ_RestaurantVO bag = dao.views(1);
				System.out.println(bag);
				resName1.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString1 = bag.getImg();
				ImageIcon img11 = new ImageIcon(imgString1);
				res1ImgLabel.setIcon(img11);
				res1Cont.add(resName1);

				bag = dao.views(2);
				resName2.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString2 = bag.getImg();
				ImageIcon img22 = new ImageIcon(imgString2);
				res2ImgLabel.setIcon(img22);
				res2Cont.add(resName2);

				bag = dao.views(3);
				resName3.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><<br><b><font color = red>조회수</font></b> : " + bag.getViews()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString3 = bag.getImg();
				ImageIcon img33 = new ImageIcon(imgString3);
				res3ImgLabel.setIcon(img33);
				res3Cont.add(resName3);

			}
		});

		// C-2. 평점순

		sortStars = new JButton("평점순");
		sortStars.setBounds(190, 80, 90, 30);
		sortStars.setBackground(Color.lightGray);
		sortStars.setForeground(Color.black);
		sortStars.setBorderPainted(false);

		sortStars.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sortStars.setBackground(Color.decode("#E74C3C"));
				sortStars.setForeground(Color.white);
				sortView.setBackground(Color.lightGray);
				sortView.setForeground(Color.black);
				sortTypeInt = 1;

				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();
				PJ_RestaurantVO bag = dao.stars(1);
				resName1.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><<br><b><font color = red>평균 평점</font></b> : " + bag.getAvg()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString1 = bag.getImg();
				ImageIcon img11 = new ImageIcon(imgString1);
				res1ImgLabel.setIcon(img11);
				res1Cont.add(resName1);

				bag = dao.stars(2);
				resName2.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><<br><b><font color = red>평균 평점</font></b> : " + bag.getAvg()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString2 = bag.getImg();
				ImageIcon img22 = new ImageIcon(imgString2);
				res2ImgLabel.setIcon(img22);
				res2Cont.add(resName2);

				bag = dao.stars(3);
				resName3.setText("<html><center><b><font size = 5>" + bag.getName() + "</font> <font size = 3>"
						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
						+ "</font><br><b><font color = red>평균 평점</font></b> : " + bag.getAvg()
						+ "<br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>" + bag.getN_Stars()
						+ " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>" + bag.getK_Stars()
						+ " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>" + bag.getG_Stars()
						+ "</center></html>");

				String imgString3 = bag.getImg();
				ImageIcon img33 = new ImageIcon(imgString3);
				res3ImgLabel.setIcon(img33);
				res3Cont.add(resName3);
			}
		});

		// ******2. 음식점1 사진 버튼 기능 구현

		res1ImgLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Detailed1UIView detail1V = new Detailed1UIView();
				DetailedUI1Stars detail1S = new DetailedUI1Stars();
				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();

				if (sortTypeInt == 0) {
					dispose();
					int viewCount = dao.getViews(1);
					detail1V.open();
					viewCount = viewCount + 1;
					dao.update(viewCount);
				} else {
					dispose();
					detail1S.open();
				}
			}
		});

		// ******1. 음식점2 사진 버튼 기능 구현

		res2ImgLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DetailedUI2View detail2V = new DetailedUI2View();
				DetailedUI2Stars detail2S = new DetailedUI2Stars();
				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();

				if (sortTypeInt == 0) {
					dispose();
					int viewCount = dao.getViews(2);
					detail2V.open();
					viewCount = viewCount + 1;
					dao.update2(viewCount);
				} else {
					dispose();
					detail2S.open();
				}
			}

		});

		// ******3. 음식점3 사진 버튼 기능 구현

		res3ImgLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DetailedUI3View detail3V = new DetailedUI3View();
				DetailedUI3Stars detail3S = new DetailedUI3Stars();
				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();

				if (sortTypeInt == 0) {
					dispose();
					int viewCount = dao.getViews(3);
					detail3V.open();
					viewCount = viewCount + 1;
					dao.update2(viewCount);
				} else {
					dispose();
					detail3S.open();
				}
			}
		});

		// E. "오늘의 OO는?" 라벨
		recoTitle = new JLabel("오늘의 OO는?");
		recoTitle.setFont(font4);
		recoTitle.setOpaque(true); // JLabel 배경색 설정하기 위해서 (기본값 투명)
		recoTitle.setBackground(Color.decode("#E74C3C"));
		recoTitle.setForeground(Color.white);
		recoTitle.setHorizontalAlignment(JLabel.CENTER); // JLabel 가운데 정렬
		recoTitle.setBounds(20, 340, 300, 40);

		// E-1. 현재 시간 가져오기
		getTime time = new getTime();
		int nowH = time.hour;
		int nowM = time.minute;
		timecount = 0; // 시간에 따라 추천음식점을 표시하기 위한 변수

		// E-2. 시간에 따라 "오늘의 OO는?" 라벨 출력
		if (nowH >= 6 && nowH <= 10) {
			timecount = 1; // 아침에 맞는 식당 리스트 출력
			recoTitle.setText("<html>현재 시각 " + nowH + "시 " + nowM + "분... 오늘의 <u><b><font color = black>" + "아침"
					+ "</font></b></u>은?</html>");
		} else if (nowH > 10 && nowH <= 13) {
			timecount = 2; // 점심에 맞는 식당 리스트 출력
			recoTitle.setText("<html>현재 시각 " + nowH + "시 " + nowM + "분... 오늘의 <u><b><font color = black>" + "점심"
					+ "</font></b></u>은?</html>");
		} else if (nowH > 13 && nowH <= 17) {
			timecount = 3; // 간식에 맞는 식당 리스트 출력
			recoTitle.setText("<html>현재 시각 " + nowH + "시 " + nowM + "분... 오늘의 <u><b><font color = black>" + "간식"
					+ "</font></b></u>은?</html>");
		} else if (nowH >= 17 && nowH <= 20) {
			timecount = 4; // 저녁에 맞는 식당 리스트 출력
			recoTitle.setText("<html>현재 시각 " + nowH + "시 " + nowM + "분... 오늘의 <u><b><font color = black>" + "저녁"
					+ "</font></b></u>은?</html>");
		} else {
			timecount = 5; // 야식에 맞는 식당 리스트 출력
			recoTitle.setText("<html>현재 시각 " + nowH + "시 " + nowM + "분... 오늘의 <u><b><font color = black>" + "야식"
					+ "</font></b></u>은?</html>");
		}

		// F. 추천 음식점 패널
		recoRes = new JPanel();
		recoRes.setLayout(null);
		recoRes.setBounds(20, 400, 300, 100);
		recoRes.setBackground(Color.decode("#e3ddcf"));

		// F-2. 추천 음식점 사진 패널
		bag = dao.reco(timecount);

		JPanel recoResImg = new JPanel();
		recoResImg.setLayout(null);
		recoResImg.setBounds(0, 0, 100, 100);
		recoResImg.setBackground(Color.decode("#e3ddcf"));

		JButton recoResImgLabel = new JButton();
		recoResImgLabel.setBounds(0, 0, 100, 100);
		recoResImg.add(recoResImgLabel);
		String imgString4 = bag.getImg();
		ImageIcon imgReco4 = new ImageIcon(imgString4);
		recoResImgLabel.setIcon(imgReco4);

		// F-2. 추천 음식점 정보 패널

		JPanel recoResPanel = new JPanel();
		recoResPanel.setBounds(100, 0, 200, 100);
		recoResPanel.setBackground(Color.decode("#e3ddcf"));

		JLabel recoResLabel = new JLabel();
		recoResLabel.setText("<html><center><b><font size = 5><i>" + bag.getName() + "</i></font> <font size = 3>"
				+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress() + "</font><br><font size = 2>"
				+ bag.getMenu() + "</font><br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>"
				+ bag.getN_Stars() + " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>"
				+ bag.getK_Stars() + " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>"
				+ bag.getG_Stars() + "</center></html>");
		recoResLabel.setFont(font3);
		recoResLabel.setLayout(null);
		recoResLabel.setHorizontalAlignment(JLabel.LEFT);
		recoResPanel.add(recoResLabel);

		recoName = bag.getName();

		System.out.println("버튼 누르기 전 : " + recoName);

		// F-3 추천 음식점 패널 조립
		recoRes.add(recoResImg);
		recoRes.add(recoResPanel);

		// G. 추천음식 새로고침 버튼
//		refresh = new JButton();
//		refresh.setBounds(285, 340, 40, 40);
//		refresh.setOpaque(false);
//		refresh.setContentAreaFilled(false);
//		refresh.setBorderPainted(false);
//
//		ImageIcon refreshIcon = new ImageIcon("refreshIcon2.png");
//		refresh.setIcon(refreshIcon);
//
//		refresh.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//
//				PJ_RestaurantDAO dao = new PJ_RestaurantDAO();
//				PJ_RestaurantVO bag = dao.reco(timecount);
//
//				recoResLabel.setText("<html><center><b><font size = 5><i>" + bag.getName() + "</i></font> <font size = 3>"
//						+ bag.getCategory() + "</font></b><br><font size = 1>" + bag.getAddress()
//						+ "</font><br><font size = 2>" + bag.getMenu()
//						+ "</font><br><b><font color = #2DB400>N</font></b><font color = yellow>★</font>"
//						+ bag.getN_Stars() + " / <b><font color = #3A1D1D>K<font></b><font color = yellow>★</font>"
//						+ bag.getK_Stars() + " / <b><font color = #ea4235>G</font></b><font color = yellow>★</font>"
//						+ bag.getG_Stars() + "</center></html>");
//
//				String imgString4 = bag.getImg();
//				ImageIcon imgReco4 = new ImageIcon(imgString4);
//				recoResImgLabel.setIcon(imgReco4);
//			}
//		});
//		
		// H. 추천음식 사진 버튼

		recoResImgLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DetailedUIReco reco = new DetailedUIReco();
				reco.open();
				setVisible(false);
			}
		});

		// 요소 추가
		add(pageTitle);
		add(logo);
		add(lineTop);
		add(scroll);
		add(sortView);
		add(sortStars);
		add(recoTitle);
		add(recoRes);
		// add(refresh);
		add(lineUnder);
		add(search);
		add(ranking);
		add(mypage);

		// 프레임 닫을 시 프로그램 실행 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 프레임 보이기
	}

}
