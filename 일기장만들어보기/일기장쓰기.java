package 부품응용하기;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class 일기장쓰기 {
	// 멤버변수 - 없으면 안써도 됨
	// 멤버메서드
	public void open() {
		// jframe 화면이 보이는 기능 정의
		//	System.out.println("화면이 open");
		JFrame f = new JFrame();
		f.setTitle("내 일기장 작성화면");
		f.setSize(400, 350);
		f.getContentPane().setBackground(Color.pink);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		Font font = new Font("NanumGothic", Font.BOLD, 22);
		Font font2 = new Font("NanumGothic", Font.BOLD, 25);
		Font font3 = new Font("NanumGothic", Font.BOLD, 15);
		
		JLabel day = new JLabel("오늘의 날짜", JLabel.LEFT);
		day.setFont(font3);
		day.setPreferredSize(new Dimension(100,40));
		
		JLabel title = new JLabel("오늘의 제목", JLabel.LEFT);
		title.setFont(font3);
		title.setPreferredSize(new Dimension(100,40));
		
		JLabel content = new JLabel("오늘의 내용", JLabel.LEFT);
		content.setFont(font3);
		content.setPreferredSize(new Dimension(100,40));
		
		JTextField dayText = new JTextField(10);
		JTextField titleText = new JTextField(10);
		dayText.setFont(font2);
		titleText.setFont(font2);
		
		JTextArea contentText = new JTextArea(5, 10);
		contentText.setFont(font2);
		
		JButton btn = new JButton("파일에 일기 저장");
		btn.setFont(font);
		btn.setPreferredSize(new Dimension(340,50));
		btn.setBackground(Color.darkGray);
		btn.setForeground(Color.white);
		btn.setBorder(null);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 날짜, 제목, 내용 입력한 것 갖고오기
				String day2 = dayText.getText(); //day로 써도 상관 없음 btn 안에서만 있는 변수이기 때문
				String title2 = titleText.getText();
				String content2 = contentText.getText();
				System.out.println(day2 + " " + title2 + " " + content2);
				// FileWriter > 파일도 만들어주고, 파일과 자바프로그램간의 연결통로(강물, Stream)을 만들어준다.
				// 외부에 있는 파일, 네트워크, CPU 등을 자바에서 연결할 때는 아주 위험한 상황이라고 인식!
				// 이렇게 위험한 상황에서 만약 문제가 발생하면 어떻게 처리할지를 꼭 써주어야한다. ( try - catch로 묶어준다 )
				try {
					FileWriter file = new FileWriter(day2 +".txt");
					file.write(day2 + "\n");
					file.write(title2 + "\n");
					file.write(content2 + "\n");
					file.close();
				} catch (IOException e1) {
					// 어떻게 처리할 지 적는 곳
					System.out.println("파일로 저장하는 중 문제가 생김!");
				}
			}
		});
		
		f.add(day); f.add(dayText);
		f.add(title); f.add(titleText);
		f.add(content); f.add(contentText);
		f.add(btn);
		
		f.setVisible(true);
	}
}
