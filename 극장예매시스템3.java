package 배열응용;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 극장예매시스템3 {

	public static void main(String[] args) {
		// 프레임 만들기
		JFrame f = new JFrame("CGV예매");
		f.getContentPane().setBackground(new Color(242, 242, 242));
		f.setSize(800, 750);
		
		// 폰트
		Font font1 = new Font("12롯데마트드림", Font.BOLD, 40);
		Font font2 = new Font("12롯데마트드림", Font.PLAIN, 15);
		
		// 레이아웃 부품
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		// 상단 스크린 부분
		JLabel title = new JLabel("Screen", JLabel.CENTER);
		title.setPreferredSize(new Dimension(1000, 180));
		title.setFont(font1);
		f.add(title);
		
		JLabel seat = new JLabel(" 0~59번 좌석: 8000원 60~99번 좌석:10000원", JLabel.LEFT);
		seat.setPreferredSize(new Dimension(400, 20));
		f.add(seat);
		// 선택된 좌석
		JLabel select = new JLabel("선택된 좌석 ", JLabel.RIGHT);
		select.setPreferredSize(new Dimension(300, 30));
		f.add(select);
		
		
		// 임의의 버튼 배열 만들기
		JButton[] btn = new JButton[100];
		
		int[] rev = new int[btn.length]; //예약자 확인 배열
				
		// 반복해서 프레임에 넣어주기
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(i + ""); // btn 배열 안에 Jbutton을 하나씩 넣는다.
			btn[i].setBorderPainted(false);
			btn[i].setPreferredSize(new Dimension(70, 30));
			if (i < 60) {
				btn[i].setBackground(Color.LIGHT_GRAY);
			}  else {
				btn[i].setBackground(Color.white);
			}
			f.add(btn[i]); // f에 올려주기
			btn[i].setFont(font2);
			
			// 버튼에 액션 기능 추가
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 클릭했을 때의 값 가져오기
					String clickText = e.getActionCommand(); 
					// 가져온 값을 int로 변환해줘야 함
					int click = Integer.parseInt(clickText);
					// 클릭되면 rev 변수에 1을 하나씩 넣어준다.
					if (rev[click] == 0) {
						rev[click] = 1;
						select.setText("선택된 좌석" + clickText + "번 ");
						btn[click].setBackground(new Color(77, 77, 255));
						btn[click].setForeground(Color.white);
					} else {
						JOptionPane.showMessageDialog(f, "이미 선택된 좌석입니다.");
						btn[click].setEnabled(false);
					} // else
				}
			});
			
		} // for
		

		// 여백
		JLabel empty = new JLabel("", JLabel.CENTER);
		empty.setPreferredSize(new Dimension(1000, 50));
		f.add(empty);
		
		// 결제버튼, 내역확인버튼
		JButton pay = new JButton("결제하기");
		
		pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int count1 = 0; // 0~59번 좌석 카운트
				int count2 = 0; // 60~99번 좌석 카운트
				String seatNo = "";
				for (int i = 0; i < 60; i++) { // i가 0~ 59일 때
					if (rev[i] == 1) {
						count1++;
						seatNo = seatNo + " " + i;
					}
					
				} // for
				for (int i = 60; i < btn.length; i++) {
					if (rev[i] == 1) {
						count2++;
						seatNo = seatNo + " " + i;
					}
					
				} // for
				
				int normal = count1 * 8000;
				int premium = count2 * 10000;
				
				JOptionPane.showMessageDialog(f, "예약 좌석" + seatNo + "번");
				int result = JOptionPane.showConfirmDialog(f, "총 결제금액: " + (normal + premium) + "원\n 결제하시겠습니까?");
				if (result == JOptionPane.YES_OPTION ) {
					JOptionPane.showMessageDialog(f, "결제 성공!");
				} else if (result == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
				// if
			}
		});
	
		
		pay.setPreferredSize(new Dimension(300, 40));
		pay.setBackground(new Color(77, 77, 255));
		pay.setForeground(Color.white);
		pay.setBorderPainted(false);
		
		f.add(pay);
		
		f.setVisible(true);
	}

}
