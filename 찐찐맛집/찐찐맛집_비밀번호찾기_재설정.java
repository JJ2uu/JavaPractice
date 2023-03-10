package 찐찐맛집;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 찐찐맛집_비밀번호찾기_재설정 extends JFrame {

	public static void open() {
		찐찐맛집_비밀번호찾기_재설정 f = new 찐찐맛집_비밀번호찾기_재설정();
	}
	
	public 찐찐맛집_비밀번호찾기_재설정() {
		setSize(360, 430);
		setTitle("찐찐맛집");
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLayout(null);
		
		Font font1 = new Font("NanumGothic", Font.BOLD, 36);
		Font font2 = new Font("NanumGothic", Font.BOLD, 20);
		Font font4 = new Font("NanumGothic", Font.BOLD, 14);
		
		JLabel title = new JLabel("비밀번호 재설정", JLabel.CENTER);
		JLabel line = new JLabel("_________________________________________", JLabel.CENTER);
		JLabel text = new JLabel("새 비밀번호", JLabel.LEFT);
		JLabel text2 = new JLabel("새 비밀번호 확인", JLabel.LEFT);
		
		
		JTextField pwField = new JTextField(10);
		JTextField pwCheckField = new JTextField(10);
		
		JButton finish = new JButton("변경 완료");
		
		finish.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = pwField.getText();
				String pwCheck = pwCheckField.getText();
				
				if (pw.equals(pwCheck)) {
					
					PJ_MemberDAO dao = new PJ_MemberDAO();
					PJ_MemberVO bag = new PJ_MemberVO();
					bag.setPw(pw);

					
					//찐찐맛집.main(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(pwField, "비밀번호가 틀립니다. 다시 입력해주세요");
					pwField.setText(" ");
					pwCheckField.setText(" ");
				}
				
			}
		});
		
		title.setFont(font1);
		text.setFont(font4);
		text2.setFont(font4);
		pwField.setFont(font2);
		pwCheckField.setFont(font2);
		finish.setFont(font2);
		
		title.setBounds(3, 10, 340, 100);
		line.setBounds(3, 75, 340, 30);
		text.setBounds(50, 100, 240, 50);
		pwField.setBounds(50, 140, 240, 50);
		text2.setBounds(50, 190, 240, 50);
		pwCheckField.setBounds(50, 230, 240, 50);
		finish.setBounds(30, 305, 280, 50);
		
		line.setForeground(new Color(166, 166, 166));
		finish.setForeground(Color.white);
		finish.setBackground(new Color(231, 76, 60));
		finish.setBorder(null);
		
		add(title);
		add(line);
		add(text);
		add(pwField);
		add(text2);
		add(pwCheckField);
		add(finish);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
