package 찐찐맛집;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.management.openmbean.OpenDataException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class 찐찐맛집_로그인창 {
	
	public static void run() {
		JFrame f = new JFrame();

			f.setSize(360, 640);
			f.setTitle("찐찐맛집");
			f.getContentPane().setBackground(new Color(231, 76, 60));
			f.setResizable(false);
			f.setLayout(null);
			
			Font font1 = new Font("함초롬돋움", Font.BOLD, 40);
			Font font2 = new Font("함초롬돋움", Font.BOLD, 20);
			Font font3 = new Font("함초롬돋움", Font.BOLD, 18);
			// Font font4 = new Font("NanumGothic", Font.PLAIN, 12);
			Font font5 = new Font("돋움체", Font.BOLD, 14);
			
			ImageIcon icon = new ImageIcon("icon.png");
			JLabel icon2 = new JLabel(icon, JLabel.CENTER);
			JLabel title = new JLabel("찐찐맛집", JLabel.CENTER);
			
			JLabel id = new JLabel("아이디");
			JLabel pw = new JLabel("비밀번호");
			
			JTextField idInput = new JTextField(10);
			JPasswordField pwInput = new JPasswordField(10);
			
			JButton login = new JButton("Login");
			JLabel join = new JLabel("회원가입", JLabel.CENTER);
			JLabel label = new JLabel("|", JLabel.CENTER);
			JLabel search = new JLabel("비밀번호 찾기", JLabel.CENTER);
			
			join.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					System.out.println("클릭");
					찐찐맛집_회원가입.open();
					f.dispose();
				}
			});
			
			search.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					System.out.println("클릭");
					찐찐맛집_비밀번호찾기.open();
					f.dispose();
				}
			});
			
			login.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String id = idInput.getText();
					String pw = pwInput.getText();
					
					PJ_MemberDAO dao = new PJ_MemberDAO();
					PJ_MemberVO bag = new PJ_MemberVO();
					bag.setId(id);
					bag.setPw(pw);
					bag = dao.login(bag);
					if (bag != null) {
						
						String id2 = bag.getId();
						String name2 = bag.getName();
						String pw2 = bag.getPw();
						String tel2 = bag.getTel();
						String code2 = bag.getCode();
						
						System.out.println("로그인 성공");
						찐찐맛집_마이페이지.open(id2, name2, pw2, tel2, code2);
						f.dispose();
					} else {
						JOptionPane.showMessageDialog(idInput, "아이디나 비밀번호를 확인하세요");
					}
				}
			});
			// JLabel non = new JLabel("비회원으로 보기", JLabel.CENTER);
			
			// 위치, 크기조정
			icon2.setBounds(155, 80, 30, 30);
			title.setBounds(48, 90, 250, 100);
			id.setBounds(50, 170, 240, 50);
			pw.setBounds(50, 260, 240, 50);
			idInput.setBounds(50, 210, 240, 50);
			pwInput.setBounds(50, 300, 240, 50);
			login.setBounds(50, 370, 240, 50);
			join.setBounds(40, 430, 120, 50);
			label.setBounds(130, 430, 40, 50);
			search.setBounds(160, 430, 120, 50);
			// non.setBounds(48, 500, 250, 100);
			
			// 폰트 설정
			icon2.setFont(font3);
			title.setFont(font1);
			id.setFont(font5);
			pw.setFont(font5);
			idInput.setFont(font2);
			pwInput.setFont(font2);
			login.setFont(font2);
			join.setFont(font5);
			label.setFont(font5);
			search.setFont(font5);
			// non.setFont(font4);
			
			// 글자색 설정
			title.setForeground(Color.white);
			icon2.setForeground(Color.white);
			id.setForeground(Color.white);
			pw.setForeground(Color.white);
			login.setForeground(Color.white);
			join.setForeground(Color.white);
			label.setForeground(Color.white);
			search.setForeground(Color.white);
			// non.setForeground(new Color(255, 171, 162));
			
			// 버튼 설정
			login.setBackground(new Color(126, 41, 33));
			login.setBorder(null);
			// join.setBackground(new Color(255, 122, 108));
			//join.setBorderPainted(false);
			
			// add
			f.add(icon2);
			f.add(title);
			f.add(id);
			f.add(idInput);
			f.add(pw);
			f.add(pwInput);
			f.add(login);
			f.add(join);
			f.add(label);
			f.add(search);
			// add(non);
			
			f.setLocationRelativeTo(null);
			f.setVisible(true);
		
	}
}
