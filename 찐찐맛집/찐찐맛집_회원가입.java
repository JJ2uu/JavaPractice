package 찐찐맛집;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class 찐찐맛집_회원가입 extends JFrame{
	
	public static void main(String[] args) {
		찐찐맛집_회원가입 f = new 찐찐맛집_회원가입();
		
	}
	public 찐찐맛집_회원가입() {
		setSize(360, 640);
		setTitle("찐찐맛집");
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setLayout(null);
		
		Font font1 = new Font("NanumGothic", Font.BOLD, 36);
		Font font2 = new Font("NanumGothic", Font.BOLD, 20);
		Font font4 = new Font("NanumGothic", Font.BOLD, 14);
		
		JLabel title = new JLabel("회원가입", JLabel.LEFT);
		JLabel line = new JLabel("_________________________________________", JLabel.CENTER);
		JLabel name = new JLabel("이름");
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		JLabel pwCheck = new JLabel("비밀번호 확인");
		JLabel tel = new JLabel("전화번호");
		JLabel re = new JLabel("추천인 코드");
		
		JCheckBox checkBox = new JCheckBox(" 개인정보 제공에 동의합니다.");
		checkBox.setBackground(null);
		
		JTextField nameField = new JTextField(10);
		JTextField idField = new JTextField(10);
		JTextField telField = new JTextField(10);
		JTextField reField = new JTextField(10);
		
		JPasswordField pwField = new JPasswordField(10);
		JPasswordField pwCheckField = new JPasswordField(10);
		
		JButton join = new JButton("회원가입 완료");
		
		// 컬러
		line.setForeground(new Color(166, 166, 166));
		join.setBackground(new Color(231, 76, 60));
		join.setForeground(Color.white);
		join.setBorderPainted(false);
		
		// 위치 설정
		title.setBounds(40, 10, 250, 100);
		line.setBounds(3, 75, 340, 30);
		name.setBounds(40, 122, 100, 50);
		nameField.setBounds(145, 130, 160, 40);
		id.setBounds(40, 172, 100, 50);
		idField.setBounds(145, 180, 160, 40);
		pw.setBounds(40, 222, 100, 50);
		pwField.setBounds(145, 230, 160, 40);
		pwCheck.setBounds(40, 272, 100, 50);
		pwCheckField.setBounds(145, 280, 160, 40);
		tel.setBounds(40, 322, 100, 50);
		telField.setBounds(145, 330, 160, 40);
		re.setBounds(40, 372, 100, 50);
		reField.setBounds(145, 380, 160, 40);
		checkBox.setBounds(40, 442, 200, 40);
		join.setBounds(40, 500, 260, 50);
		
		// 비밀번호 * 설정
		pwField.setEchoChar('*');
		pwCheckField.setEchoChar('*');
		
		// 폰트설정
		title.setFont(font1);
		name.setFont(font4);
		id.setFont(font4);
		pw.setFont(font4);
		pwCheck.setFont(font4);
		tel.setFont(font4);
		re.setFont(font4);
		nameField.setFont(font2);
		idField.setFont(font2);
		pwField.setFont(font2);
		pwCheckField.setFont(font2);
		telField.setFont(font2);
		reField.setFont(font2);
		checkBox.setFont(font4);
		join.setFont(font2);
		
		// add
		add(title);
		add(line);
		add(name);
		add(nameField);
		add(id);
		add(idField);
		add(pw);
		add(pwField);
		add(pwField);
		add(pwCheck);
		add(pwCheckField);
		add(tel);
		add(telField);
		add(re);
		add(reField);
		add(checkBox);
		add(join);
		
		setVisible(true);
	}
	
}
