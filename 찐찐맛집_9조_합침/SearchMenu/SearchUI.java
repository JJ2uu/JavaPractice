package SearchMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DetailedPage.DetailedUI;
import 랭킹.RankingUI;
import 찐찐맛집_UI.MyPageUI;

public class SearchUI extends JFrame {
	JButton searchB, rankingB, mypageB;
	JLabel lineUnder, lineTop;
	JScrollPane scroll;
	public static SearchUI ui = new SearchUI();

	public static ArrayList<SearchDTO> resList = new ArrayList<SearchDTO>();
	public static ArrayList<JPanel> resListPanel = new ArrayList<JPanel>();

	public static ImageIcon fullStarIcon, starIcon;
	public static ArrayList<String> bookmarkList = new ArrayList<>();

	public static void open() {
		// 1. 기본 메소드 : 음식점 리스트 전체 받아오기
		ui = new SearchUI();
		// 2. 회원 북마크 음식점 리스트 받기
		GetBookmark bm = new GetBookmark();
		// 3. 북마크 아이콘 만들기
		SetStarIcon star = new SetStarIcon();
		// 4. 전체 음식점 판넬 만들기
		MakePanel makePanelAll = new MakePanel();
		// 5. 프로그램 실행
		ui.frameView();
		// 6. 지역 음식점 리스트 받기
	}

	// 다른 메뉴에서 뒤로가기 버튼 클릭 시 프레임 다시 보이기
	public void back() {
		ui.setVisible(true);
	}

	// 1. 기본 메소드 : 음식점 리스트 전체 받아오기
	public SearchUI() {
		SearchDAO getResList = new SearchDAO();
		resList = getResList.search();
	}

	// 2. 회원 북마크 음식점 리스트 받기
	public static class GetBookmark {
		public GetBookmark() {
			SearchDAO dao = new SearchDAO();
			bookmarkList = dao.searchBookmark();
		}
	}

	// 3. 북마크 아이콘 만들기
	public static class SetStarIcon {
		public SetStarIcon() {
			ImageIcon star1 = new ImageIcon("full_star.jpg");
			Image star2 = star1.getImage();
			Image star3 = star2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			fullStarIcon = new ImageIcon(star3);

			ImageIcon star4 = new ImageIcon("star.png");
			Image star5 = star4.getImage();
			Image star6 = star5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			starIcon = new ImageIcon(star6);
		}
	}

	// 4. 음식점 판넬 만들기
	public static class MakePanel {
		public MakePanel() {
			for (int i = 0; i < resList.size(); i++) {
				// 1. 음식점 판넬
				JPanel resPanel = new JPanel();
				resPanel.setPreferredSize(new Dimension(310, 130));
				resPanel.setLayout(null);
				resPanel.setBackground(Color.white);
				resPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#E74C3C"))));

				// 2. 음식점 이미지 버튼
				JButton imagebutton = new JButton("");

				// 2-1. 버튼 이미지 사이즈 조정 후 설정
				ImageIcon img = new ImageIcon(resList.get(i).getImg());
				Image getImg = img.getImage();
				Image setImgSize = getImg.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				ImageIcon imgIcon = new ImageIcon(setImgSize);
				imagebutton.setIcon(imgIcon); // 이미지 설정

				// 2-2. 이미지 버튼 - 테두리 없애기 / 배경색 없애기 / 크기, 위치 설정
				imagebutton.setBorderPainted(false);
				imagebutton.setFocusPainted(false);
				imagebutton.setBounds(5, 5, 120, 120);

				// 2-3. 이미지 버튼 클릭 기능
				String resName = resList.get(i).getName();
				imagebutton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						SearchDAO dao = new SearchDAO(); // 조회수 +1
						dao.viewUpdate(resName);
						System.out.println(resName + " 이동중"); // 상세페이지 이동
						DetailedUI detailedUI = new DetailedUI(resName);
						ui.setVisible(false);
					}
				});

				// 3. 음식점 설명 라벨 - 내용 / 위치, 크기
				JLabel descriplabel = new JLabel("<html>" + resList.get(i).getCategory() + "<br>"
						+ resList.get(i).getName() + "<br>" + resList.get(i).getAddress() + "</html>");
				descriplabel.setBounds(130, 5, 180, 90);

				// 4. 별점 판넬 - 레이아웃 없애기 / 배경색 : 흰색 / 위치, 크기 설정
				JPanel rating = new JPanel();
				rating.setLayout(null);
				rating.setBackground(Color.white);
				rating.setBounds(130, 100, 170, 20);

				// 4-1. 각 지도별 라벨, 별점 받아오기
				JLabel naver = new JLabel(Float.toString(resList.get(i).getnStars())); // 네이버지도
				JLabel kakao = new JLabel(Float.toString(resList.get(i).getkStars())); // 카카오맵
				JLabel google = new JLabel(Float.toString(resList.get(i).getgStars())); // 구글맵

				// 4-2. 각 지도별 라벨에 이미지 넣기
				ImageIcon iconN = new ImageIcon("nMap.png"); // 네이버지도
				Image nMap = iconN.getImage();
				Image setsize1 = nMap.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				ImageIcon naverIcon1 = new ImageIcon(setsize1);
				naver.setIcon(naverIcon1);

				ImageIcon iconK = new ImageIcon("kMap.png"); // 카카오맵
				Image kMap = iconK.getImage();
				Image setsize2 = kMap.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				ImageIcon kakaoIcon2 = new ImageIcon(setsize2);
				kakao.setIcon(kakaoIcon2);

				ImageIcon iconG = new ImageIcon("gMap.png"); // 구글맵
				Image gMap = iconG.getImage();
				Image setsize3 = gMap.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				ImageIcon googleIcon3 = new ImageIcon(setsize3);
				google.setIcon(googleIcon3);

				// 4-3. 각 지도 라벨 별점 판넬에 넣기 / 위치, 크기 지정
				naver.setBounds(5, 0, 53, 20);
				kakao.setBounds(60, 0, 53, 20);
				google.setBounds(115, 0, 53, 20);

				rating.add(naver);
				rating.add(kakao);
				rating.add(google);

				// 5. 북마크
				JButton bookmark = new JButton();
				// 만약 회원 북마크 리스트에 해당 음식점이 있으면 -> 꽉찬 별, 그외 빈 별
				if (bookmarkList.contains(resList.get(i).getName())) {
					bookmark.setIcon(fullStarIcon);
				} else {
					bookmark.setIcon(starIcon);
				}
				// 5-1. 북마크 - 위치, 크기 설정 / 배경색 : 흰색 / 테두리 없애기
				bookmark.setBounds(270, 10, 20, 20);
				bookmark.setBackground(Color.white);
				bookmark.setBorderPainted(false);
				// 5-2. 북마크 클릭 기능
				bookmark.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						SearchDAO dao = new SearchDAO();
						// 음식점 이름, 회원 ID(아직 로그인 연동 전이므로 임의의 ID)로 Select 실행 후
						// 해당 데이터가 북마크DB리스트에
						// 있으면 북마크 해제(꽉찬 별->빈별)
						// 없으면 북마크 설정(빈별->꽉찬 별)
						int bmUpdate = dao.bookmarkUpdate(resName);
						if (bookmark.getIcon().equals(fullStarIcon)) {
							bookmark.setIcon(starIcon);
						} else {
							bookmark.setIcon(fullStarIcon);
						}
					}
				});

				// 6. 음식점 판넬에 이미지 버튼, 설명 라벨, 별점 판넬 넣기
				resPanel.add(imagebutton);
				resPanel.add(descriplabel);
				resPanel.add(rating);
				resPanel.add(bookmark);

				resListPanel.add(resPanel);
			}
		}
	}

	public void frameView() {

		// 1. 프레임 - 타이틀 / 사이즈 / 레이아웃 / 배경색 : 흰색
		setTitle("찐찐맛집");
		setSize(360, 640);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		
		// 2-1. 타이틀 라벨
		JLabel title = new JLabel("맛집 검색");
		Font titleFont = new Font("돋움", 1, 30);
		title.setFont(titleFont);
		title.setBounds(10, 10, 360, 40);
		title.setForeground(Color.decode("#E74C3C"));

		// 2-2. 로고 라벨(이미지)
		JLabel logo = new JLabel();
		ImageIcon logo1 = new ImageIcon("icon_color.png");
		logo.setIcon(logo1);
		logo.setBounds(300, 10, 50, 50);

		// 3. 지역선택 버튼 - 문구 / 위치, 크기 / 배경,글씨체 색 / 테두리 없애기
		JButton seoul = new JButton("서울");
		JButton anyang = new JButton("안양");
		JButton chuncheon = new JButton("춘천");
		JButton busan = new JButton("부산");

		seoul.setBounds(5, 60, 70, 20);
		anyang.setBounds(90, 60, 70, 20);
		chuncheon.setBounds(180, 60, 70, 20);
		busan.setBounds(270, 60, 70, 20);

		seoul.setBackground(Color.decode("#E74C3C"));
		anyang.setBackground(Color.decode("#E74C3C"));
		chuncheon.setBackground(Color.decode("#E74C3C"));
		busan.setBackground(Color.decode("#E74C3C"));

		seoul.setForeground(Color.white);
		anyang.setForeground(Color.white);
		chuncheon.setForeground(Color.white);
		busan.setForeground(Color.white);

		seoul.setBorder(null);
		anyang.setBorder(null);
		chuncheon.setBorder(null);
		busan.setBorder(null);

		// 4. 지역 선택 버튼 기능
		seoul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GetLocationList seoulList = new GetLocationList();
				JPanel seoulPanel = seoulList.getResListL(seoul.getText());
				scroll.setViewportView(null);
				scroll.setViewportView(seoulPanel);
			}
		});
		anyang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GetLocationList anyangList = new GetLocationList();
				JPanel anyangPanel = anyangList.getResListL(anyang.getText());
				scroll.setViewportView(null);
				scroll.setViewportView(anyangPanel);

			}
		});

		chuncheon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GetLocationList chuncheonList = new GetLocationList();
				JPanel chuncheonPanel = chuncheonList.getResListL(chuncheon.getText());
				scroll.setViewportView(null);
				scroll.setViewportView(chuncheonPanel);
			}
		});

		busan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GetLocationList busanList = new GetLocationList();
				JPanel busanPanel = busanList.getResListL(busan.getText());
				scroll.setViewportView(null);
				scroll.setViewportView(busanPanel);
			}
		});

		// 5. 메인 JPanel - 레이아웃 없애기 / 배경색 : 흰색 / 사이즈 지정
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		int height = 133 * resList.size();
		mainPanel.setPreferredSize(new Dimension(310, height));

//		6. 각 음식점 판넬 (위치, 크기 지정)
		for (int i = 0; i < resList.size(); i++) {
			JPanel panel1 = resListPanel.get(i);
			mainPanel.add(panel1);
			panel1.setBounds(5, 5 + (i * 132), 310, 130);
		}

		// 7. JScrollPane
		scroll = new JScrollPane();
		scroll.setBounds(0, 100, 335, 420); // Height -> 메인 패널보다 작게
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // 세로 스크롤 필요하면 생기게
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // 가로 스크롤은 절대 X
		scroll.getVerticalScrollBar().setUnitIncrement(16); // 스크롤 속도
		scroll.setViewportView(mainPanel); // 스크롤페인에 메인패널 넣기
		scroll.setBorder(null);

	
		
		// 8. 상하단 구분 라인
		lineUnder = new JLabel("─────────────────────────");
		lineTop = new JLabel("─────────────────────────");
		lineUnder.setForeground(Color.decode("#E74C3C"));
		lineTop.setForeground(Color.decode("#E74C3C"));
		lineUnder.setBounds(10, 530, 360, 10);
		lineTop.setBounds(10, 50, 360, 10);

		// 9. 하단 메뉴 이동 버튼
		searchB = new JButton(); // 맛집 검색
		rankingB = new JButton(); // 맛집랭킹
		mypageB = new JButton(); // 마이페이지

		// 9-1. 하단 메뉴 이동 버튼 설정
		// (1)메뉴1 - 맛집 검색 이미지
		ImageIcon image1 = new ImageIcon("search.png");
		Image img1 = image1.getImage();
		Image setsize = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon searchIcon = new ImageIcon(setsize);
		searchB.setIcon(searchIcon);

		// (2)메뉴2 - 맛집랭킹 이미지
		ImageIcon image2 = new ImageIcon("rank.png");
		Image img2 = image2.getImage();
		Image setsize2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon rankIcon = new ImageIcon(setsize2);
		rankingB.setIcon(rankIcon);

		// (3)메뉴3 - 마이페이지 이미지
		ImageIcon image3 = new ImageIcon("mypage.png");
		Image img3 = image3.getImage();
		Image setsize3 = img3.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon mypageIcon = new ImageIcon(setsize3);
		mypageB.setIcon(mypageIcon);

		// 메뉴(1),(2),(3) 아이콘 크기, 색상 지정
		searchB.setBounds(10, 550, 40, 40);
		searchB.setBackground(Color.white);
		searchB.setBorderPainted(false);
		searchB.setFocusPainted(false);

		rankingB.setBounds(150, 550, 40, 40);
		rankingB.setBackground(Color.white);
		rankingB.setBorderPainted(false);
		rankingB.setFocusPainted(false);

		mypageB.setBounds(290, 550, 40, 40);
		mypageB.setBackground(Color.white);
		mypageB.setBorderPainted(false);
		mypageB.setFocusPainted(false);

		// 9-2. 버튼 기능 (메뉴 이동)
		searchB.addActionListener(new ActionListener() {

			JPanel searchmenuPanel = new JPanel();

			@Override
			public void actionPerformed(ActionEvent e) {
				searchmenuPanel.setLayout(null);
				searchmenuPanel.setBackground(Color.white);
				int height = 133 * resList.size();
				searchmenuPanel.setPreferredSize(new Dimension(310, height));

				for (int i = 0; i < resList.size(); i++) {
					JPanel panel1 = resListPanel.get(i);
					searchmenuPanel.add(panel1);
					panel1.setBounds(5, 5 + (i * 132), 310, 130);
				}
				scroll.setViewportView(null);
				scroll.setViewportView(searchmenuPanel); // 스크롤페인에 메인패널 넣기

			}
		});
		rankingB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RankingUI ranking = new RankingUI();
				ranking.open();
				dispose();
			}
		});
		mypageB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MyPageUI mypage = new MyPageUI();
				mypage.open("chae", "채지윤", "0310", "00000003425", "");
				dispose();
			}
		});

		// 10. 요소 추가
		// 상단 레이아웃
		add(title);
		add(lineTop);
		add(logo);

		// 지역 선택 버튼
		add(seoul);
		add(anyang);
		add(chuncheon);
		add(busan);
		// 메인 음식 리스트
		add(scroll);

		// 하단 레이아웃
		add(lineUnder);
		add(searchB);
		add(rankingB);
		add(mypageB);

		// 11. 프레임 닫을 시 프로그램 실행 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 프레임 보이기
	}

	// 6. 지역 Select 클래스 - 선택한 지역 리스트 받아오기
	public class GetLocationList {

		public JPanel getResListL(String location) {
			SearchDAO dao = new SearchDAO();
			ArrayList<String> resListL = dao.searchL(location);
			int height = 133 * resListL.size();

			JPanel locationPanel = new JPanel();
			locationPanel.setLayout(null);
			locationPanel.setBackground(Color.white);
			locationPanel.setPreferredSize(new Dimension(310, height));

			int x = 0;

			for (int i = 0; i < resList.size(); i++) {
				if (resListL.contains(resList.get(i).getName())) {
					JPanel panel0 = resListPanel.get(i);
					locationPanel.add(panel0);
					panel0.setBounds(5, 5 + (x * 132), 310, 130);
					x++;
				}
			}
			return locationPanel;
		}
	}

}
