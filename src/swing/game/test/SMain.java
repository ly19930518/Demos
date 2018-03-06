package swing.game.test;

import javax.swing.JFrame;

public class SMain extends JFrame{
	public SMain() {
		this.setTitle("Hello World");
		this.setSize(600, 500);
		this.setVisible(true);
		this.add(new StartPanel());
	}
	
	
	
	public static void main(String[] args) {
		SMain s = new SMain();
	}
}
