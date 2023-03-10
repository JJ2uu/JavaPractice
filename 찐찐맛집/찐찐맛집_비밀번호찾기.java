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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class 찐찐맛집_비밀번호찾기 extends JFrame {
	
	public static void open() {
		찐찐맛집_비밀번호찾기 f = new 찐찐맛집_비밀번호찾기();
	}
	
	public 찐찐맛집_비밀번호찾기() {
		setSize(360, 360);
		setTitle("찐찐맛집");
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLayout(null);
		
		Font font1 = new Font("NanumGothic", Font.BOLD, 36);
		Font font2 = new Font("NanumGothic", Font.BOLD, 20);
		Font font4 = new Font("NanumGothic", Font.BOLD, 14);
		
		JLabel title = new JLabel("비밀번호 찾기", JLabel.CENTER);
		JLabel line = new JLabel("_________________________________________", JLabel.CENTER);
		JLabel line2 = new JLabel("_________________________________________", JLabel.CENTER);
		JLabel text = new JLabel("비밀번호를 찾고자 하는 아이디를 적어주세요.", JLabel.CENTER);
		
		JTextField idField = new JTextField(10);
		
		JButton next = new JButton("다음");
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				
				PJ_MemberDAO dao = new PJ_MemberDAO();
				PJ_MemberVO bag = new PJ_MemberVO();
				bag.setId(id);
				bag = dao.one(bag);
			
				if (bag != null) {

					setSize(360, 570);
					next.setVisible(false);
					idField.setEditable(false);
					text.setText("비밀번호를 찾을 아이디");
					title.setText("비밀번호 재설정");
					
					JLabel text = new JLabel("새 비밀번호", JLabel.LEFT);
					JLabel text2 = new JLabel("새 비밀번호 확인", JLabel.LEFT);
					
					
					JPasswordField pwField = new JPasswordField(10);
					JPasswordField pwCheckField = new JPasswordField(10);
					
					JButton finish = new JButton("변경 완료");
					
					text.setFont(font4);
					text2.setFont(font4);
					pwField.setFont(font2);
					pwCheckField.setFont(font2);
					finish.setFont(font2);
					
					line2.setBounds(3, 200, 340, 30);
					text.setBounds(50, 230, 240, 50);
					pwField.setBounds(50, 270, 240, 50);
					text2.setBounds(50, 330, 240, 50);
					pwCheckField.setBounds(50, 370, 240, 50);
					finish.setBounds(30, 440, 280, 50);
					
					finish.setForeground(Color.white);
					finish.setBackground(new Color(231, 76, 60));
					finish.setBorder(null);
					
					add(line2);
					add(text);
					add(pwField);
					add(text2);
					add(pwCheckField);
					add(finish);
					
					
					finish.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							PJ_MemberVO bag = new PJ_MemberVO();
							
							String pw = pwField.getText();
							String pwCheck = pwCheckField.getText();
							String id2 = idField.getText();
							bag.setPw(pw);
							bag.setId(id2);
							int result = dao.pwUpdate(bag);
							
							if (result == 1 && pw.equals(pwCheck)) {
								JOptionPane.showMessageDialog(idField, "비밀번호 변경 성공");
								찐찐맛집_로그인창.run();
								dispose();
							} else {
								JOptionPane.showMessageDialog(idField, "비밀번호가 다릅니다. 다시 입력하세요");
								pwField.setText(" ");
								pwCheckField.setText(" ");
							}
						}
					});
					
				} else {
					JOptionPane.showMessageDialog(idField, "존재하지 않는 계정입니다");
				}
			}
		});
		
		title.setFont(font1);
		text.setFont(font4);
		idField.setFont(font2);
		next.setFont(font2);
		
		title.setBounds(3, 10, 340, 100);
		line.setBounds(3, 75, 340, 30);
		text.setBounds(3, 100, 340, 50);
		idField.setBounds(50, 150, 240, 50);
		next.setBounds(30, 220, 280, 50);
		
		line.setForeground(new Color(166, 166, 166));
		next.setForeground(Color.white);
		next.setBackground(new Color(231, 76, 60));
		next.setBorder(null);
		
		add(title);
		add(line);
		add(text);
		add(idField);
		add(next);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
