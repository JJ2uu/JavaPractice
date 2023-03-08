package 찐찐맛집;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 찐찐맛집 extends JFrame {

	public static void main(String[] args) {
		찐찐맛집 f = new 찐찐맛집();
	}
	public 찐찐맛집() {
		setSize(360, 640);
		setTitle("찐찐맛집");
		getContentPane().setBackground(new Color(231, 76, 60));
		setResizable(false);
		setLayout(null);
		
		Font font1 = new Font("NanumGothic", Font.BOLD, 40);
		Font font2 = new Font("NanumGothic", Font.BOLD, 20);
		Font font3 = new Font("NanumGothic", Font.BOLD, 18);
		// Font font4 = new Font("NanumGothic", Font.PLAIN, 12);
		Font font5 = new Font("NanumGothic", Font.BOLD, 14);

		JLabel icon = new JLabel("♥", JLabel.CENTER);
		JLabel title = new JLabel("찐찐맛집", JLabel.CENTER);
		
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		
		JTextField idInput = new JTextField(10);
		JTextField pwInput = new JTextField(10);
		
		JButton login = new JButton("Login");
		JButton join = new JButton("회원가입");
		
		// JLabel non = new JLabel("비회원으로 보기", JLabel.CENTER);
		
		// 위치, 크기조정
		icon.setBounds(48, 50, 250, 100);
		title.setBounds(48, 90, 250, 100);
		id.setBounds(50, 170, 240, 50);
		pw.setBounds(50, 260, 240, 50);
		idInput.setBounds(50, 210, 240, 50);
		pwInput.setBounds(50, 300, 240, 50);
		login.setBounds(50, 370, 240, 50);
		join.setBounds(50, 430, 240, 50);
		// non.setBounds(48, 500, 250, 100);
		
		// 폰트 설정
		icon.setFont(font3);
		title.setFont(font1);
		id.setFont(font5);
		pw.setFont(font5);
		idInput.setFont(font2);
		pwInput.setFont(font2);
		login.setFont(font2);
		join.setFont(font2);
		// non.setFont(font4);
		
		// 글자색 설정
		title.setForeground(Color.white);
		icon.setForeground(Color.white);
		id.setForeground(Color.white);
		pw.setForeground(Color.white);
		login.setForeground(Color.white);
		join.setForeground(Color.white);
		// non.setForeground(new Color(255, 171, 162));
		
		// 버튼 설정
		login.setBackground(new Color(126, 41, 33));
		login.setBorderPainted(false);
		join.setBackground(new Color(255, 122, 108));
		join.setBorderPainted(false);
		
		// add
		add(icon);
		add(title);
		add(id);
		add(idInput);
		add(pw);
		add(pwInput);
		add(login);
		add(join);
		// add(non);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
