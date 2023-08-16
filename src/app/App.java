package app;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {
	
	private JFrame frame;
	private StateStack stack;
	
	private App() {
		
		frame = new JFrame();
		frame.setTitle("Kanji Tutor");
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		stack = new StateStack(frame);

		stack.push(new MainMenu(stack, frame));
	}
	
	public static void main(String[] args) {
		
		try {
			new App();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}

