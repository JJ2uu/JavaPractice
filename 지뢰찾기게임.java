package 지뢰찾기;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class 지뢰찾기게임 {

	public static void main(String[] args) {
		JFrame f = new JFrame("지뢰찾기");
		f.setSize(450, 500);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		JLabel title = new JLabel("지뢰찾기", JLabel.CENTER);
		title.setPreferredSize(new Dimension(500,50));
		f.add(title);
		
		JButton[] btn = new JButton[42];
		
		JLabel result = new JLabel();
		
		int[] onClick = new int[btn.length];
		
		Random r = new Random(10);
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(i + "");
			btn[i].setPreferredSize(new Dimension(50,50));
			btn[i].setBackground(Color.white);
			f.add(btn[i]);
			
			btn[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String clickText = e.getActionCommand();
					int click = Integer.parseInt(clickText);
					onClick[click] = r.nextInt(10);
					if (onClick[click]== 1) {
						JOptionPane.showMessageDialog(f, "지뢰 펑!");
						btn[click].setEnabled(false);
					} else {
						result.setText( click + "번 통과");
						System.out.println(onClick[click]);
					} // else if
				} 
			}); //btn action
		} // for
		
		
		f.add(result);
		
		f.setVisible(true);
	}

}
