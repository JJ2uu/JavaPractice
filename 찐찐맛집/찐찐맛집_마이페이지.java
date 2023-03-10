package 찐찐맛집;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 찐찐맛집_마이페이지 {

	public static void open(String id2, String name2, String pw2, String tel2, String code2) {
		JFrame f = new JFrame();
		
		f.setSize(360, 560);
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
		JLabel line = new JLabel("_________________________________________", JLabel.CENTER);
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
		
		JButton pwUp = new JButton("수정");
		JButton telUp = new JButton("수정");
		JButton reUp = new JButton("추천인 코드 생성");
		JButton update = new JButton("수정완료");
		JButton delete = new JButton("탈퇴하기");
		
		name.setText(name2);
		id.setText(id2);
		pw.setText(pw2);
		tel.setText(tel2);
		re.setText(code2);
		
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
        
        telUp.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String newTel = JOptionPane.showInputDialog("새 전화번호를 입력하세요.");
        		tel.setText(newTel);
        		System.out.println("수정 반영");
        		tel.setForeground(new Color(231, 76, 60));
        	}
        });
        
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
				} else {
					System.out.println("수정 실패");
				}
			}
		});
		
		reUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();
				PJ_MemberDAO dao = new PJ_MemberDAO();
				PJ_MemberVO bag = new PJ_MemberVO();
				String code = String.valueOf(r.nextInt(999999));
				bag.setCode(code);
				bag.setId(id2);
				int result = dao.codeUpdate(bag);
				if (result == 1) {
					re.setText(bag.getCode());
				}
			}
		});

		
		f.add(title);
		f.add(line);
		f.add(text);
		f.add(text2);
		f.add(text3);
		f.add(text4);
		f.add(text5);
		f.add(name);
		f.add(id);
		f.add(pw);
		f.add(tel);
		f.add(re);
		f.add(pwUp);
		f.add(telUp);
		f.add(reUp);
		f.add(update);
		f.add(delete);
		
		title.setFont(font1);
		text.setFont(font3);
		name.setFont(font4);
		id.setFont(font4);
		pw.setFont(font4);
		tel.setFont(font4);
		pwUp.setFont(font5);
		telUp.setFont(font5);
		reUp.setFont(font5);
		update.setFont(font3);
		delete.setFont(font3);

		title.setBounds(3, 10, 340, 100);
		line.setBounds(3, 75, 340, 30);
		text.setBounds(30, 110, 100, 50);
		text2.setBounds(30, 160, 100, 50);
		text3.setBounds(30, 210, 100, 50);
		text4.setBounds(30, 260, 100, 50);
		text5.setBounds(30, 310, 100, 50);
		name.setBounds(110, 110, 100, 50);
		id.setBounds(110, 160, 100, 50);
		pw.setBounds(110, 210, 100, 50);
		tel.setBounds(110, 260, 100, 50);
		re.setBounds(110, 310, 100, 50);
		pwUp.setBounds(180, 225, 50, 20);
		telUp.setBounds(180, 275, 50, 20);
		reUp.setBounds(180, 325, 120, 20);
		update.setBounds(30, 370, 280, 50);
		delete.setBounds(30, 430, 280, 50);
		
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

		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}


}
