package 부품응용하기;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class loginPage {

	public static void main(String[] args) {
		// font, flowLayout
		// JFrame, imageIcon, imagelabel
		// idlabel, pwlabel, id입력값, pw 입력값
		// login, reset버튼
		
		JFrame f = new JFrame();
		f.setTitle("내 일기장 로그인");
		f.setSize(400, 480);
		f.getContentPane().setBackground(Color.white);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		Font font = new Font("NanumGothic", Font.BOLD, 22);
		Font font2 = new Font("NanumGothic", Font.BOLD, 25);
		Font font3 = new Font("NanumGothic", Font.BOLD, 15);
		
		JLabel top = new JLabel(); // ImageIcon이 들어갈 곳
		
		JLabel id = new JLabel("아이디", JLabel.LEFT);
		id.setFont(font);
		id.setPreferredSize(new Dimension(100,40));
		
		JLabel pw = new JLabel("패스워드", JLabel.LEFT);
		pw.setFont(font);
		pw.setPreferredSize(new Dimension(100,40));
		
		ImageIcon icon = new ImageIcon("img2.jpg");
		top.setIcon(icon);
		
		JTextField idText = new JTextField(10);
		JTextField pwText = new JTextField(10);
		idText.setFont(font2);
		pwText.setFont(font2);
		
		JButton login = new JButton("LOGIN");
		login.setPreferredSize(new Dimension(170,50));
		login.setFont(font3);
		login.setBackground(new Color(255, 94, 158));
		login.setForeground(Color.white);
		login.setBorder(null);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// idText, pwText에 getText()
				String id2 = idText.getText(); // "root"
				String pw2 = pwText.getText(); // "1234"
				
				if (id2.equals("root") && pw2.equals("1234")) {
					JOptionPane.showMessageDialog(f, "로그인 성공!");
					// 일기장쓰기 부품의 open()기능 쓰자!
					일기장쓰기 diary = new 일기장쓰기();
					diary.open();
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(f, "로그인 실패....");
				}
			}
		}); // login add end
		
		
		JButton reset = new JButton("RESET");
		reset.setPreferredSize(new Dimension(170,50));
		reset.setFont(font3);
		reset.setBackground(Color.darkGray);
		reset.setForeground(Color.white);
		reset.setBorder(null);
			
		// 1) 버튼에 액션기능을 add
		// 2) 클릭했을 때 어떤 부품이 처리를 담당할지 new로 만들어준다.
		// 3) 클릭했을 때 어떻게 처리할지 코딩
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// reset을 눌렀을 때, idText, pwText에 공백을 넣어라.
				idText.setText(""); // 값을 넣어줄 때 set(setting)을 많이 쓴다.
				pwText.setText("");	
			}
		}); // reset add end
		
		

		f.add(top);
		f.add(id); f.add(idText);
		f.add(pw); f.add(pwText);
		f.add(login); f.add(reset);
		
		f.setVisible(true);
	}

}
