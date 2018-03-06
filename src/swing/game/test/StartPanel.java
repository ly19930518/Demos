package swing.game.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel{
	JPanel panel = null;
	public StartPanel() {
		panel = this;
		JButton jButton = new JButton("开始");
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		this.add(jButton);
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("0011",16));
	}
	
}
