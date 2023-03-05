package 계산기만들어보기;

import java.awt.Color;
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

public class 계산기예시 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(300, 500);
		
		Font font = new Font("Noto Sans CJK", 1, 30);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		JLabel icon2 = new JLabel();
		ImageIcon icon = new ImageIcon("011.jpg");
		icon2.setIcon(icon);
		
		JLabel text1 = new JLabel();
		text1.setText("숫자 1");
		
		JTextField input1 = new JTextField(10);
		input1.setBackground(Color.white);
		JTextField input2 = new JTextField(10);
		input2.setBackground(Color.white);
		
		JLabel text2 = new JLabel();
		text2.setText("숫자 2");
		
		JButton b1 = new JButton();
		b1.setText("+");
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		
		JButton b2 = new JButton();
		b2.setText("-");
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		
		JButton b3 = new JButton();
		b3.setText("*");
		b3.setBackground(Color.blue);
		b3.setForeground(Color.white);
		
		JButton b4 = new JButton();
		b4.setText("/");
		b4.setBackground(Color.blue);
		b4.setForeground(Color.white);
		
		text1.setFont(font);
		input1.setFont(font);
		text2.setFont(font);
		input2.setFont(font);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		
		f.add(icon2);
		f.add(text1);
		f.add(input1);
		f.add(text2);
		f.add(input2);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭했을 때의 처리 내용 (+)
				// 1) input1, input2에 있는 글자를 가지고 온다.
				String s1 = input1.getText();
				String s2 = input2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				int result = n1 + n2;
				
				JOptionPane.showMessageDialog(f, result);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭했을 때의 처리 내용 (+)
				// 1) input1, input2에 있는 글자를 가지고 온다.
				String s1 = input1.getText();
				String s2 = input2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				int result = n1 - n2;
				
				JOptionPane.showMessageDialog(f, result);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭했을 때의 처리 내용 (+)
				// 1) input1, input2에 있는 글자를 가지고 온다.
				String s1 = input1.getText();
				String s2 = input2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				int result = n1 * n2;
				
				JOptionPane.showMessageDialog(f, result);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 클릭했을 때의 처리 내용 (+)
				// 1) input1, input2에 있는 글자를 가지고 온다.
				String s1 = input1.getText();
				String s2 = input2.getText();
				
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				double result = (double)n1 / n2;
				
				JOptionPane.showMessageDialog(f, String.format("%.3f", result));
			}
		});
		
		f.setVisible(true);
		
	}

}
