package app;


import javax.swing.JFrame;

public class App extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private App() {
		
		setTitle("Kanji Tutor");
		setSize(700, 500);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		StateStack stack = new StateStack(this);

		stack.push(new MainMenu(stack, this));
	}
	
	public static void main(String[] args) {
		
		try {
			new App();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}

