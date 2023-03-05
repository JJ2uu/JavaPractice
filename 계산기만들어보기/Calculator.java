package ���⸸����;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	public static void main(String[] args) {
		Calculator f = new Calculator();
	}
	
	public Calculator() {
		setTitle("����");
		setSize(400, 500);
		setResizable(false); // ũ������ ���ϰ�
		setLayout(new BorderLayout()); // ���̾ƿ� �����¿� ��ġ
		getContentPane().setBackground(new Color(242, 242, 242));
		
		Font font = new Font("NanumGothic", Font.BOLD, 70);
		Font font2 = new Font("NanumGothic", Font.BOLD, 20);
		
		JTextField text = new JTextField();
		text.setText("0");
		text.setPreferredSize(new Dimension(400,150));
		text.setBackground(new Color(242, 242, 242));
		text.setFont(font);
		text.setEditable(false); // �Է� ����
		text.setBorder(null);
		text.setHorizontalAlignment(JTextField.RIGHT); // �۾� ������ ����
		
		add(text, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5)); // ���� ĭ, ���� ĭ, �¿� ����, ���� ����
		
		String[] buttonName = { "C", "��", "��", "��" , "7", "8", "9", "+" ,"4", "5", "6", "-" , "1", "2", "3", "0"}; // ��ư �̸� �迭
		JButton[] buttons = new JButton[buttonName.length]; // ��ư �迭
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonName[i]);
			buttons[i].setFont(font2);
			buttons[i].setBackground(Color.white);
			buttons[i].setBorder(null);
			buttons[i].setPreferredSize(new Dimension(100, 70));
			buttonPanel.add(buttons[i]);
			if (i == 3) {
				buttons[i].setBackground(new Color(0, 153, 204));
				buttons[i].setForeground(Color.white);
			}
			
			buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String buttonAc = e.getActionCommand(); // ��ư �� ��������
					
					if (buttonAc.equals("C")) {
						text.setText("");
					} else if (buttonAc.equals("��")) {

					} else {
						text.setText(text.getText() + e.getActionCommand());
					}
				}
			});
		}
		
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
