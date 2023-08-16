package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class LearnOptionsWindow extends Window {

	private JPanel panel;
	
	private JButton level_N5;
	private JButton level_N4;
	private JButton level_N3;
	private JButton level_N2;
	private JButton level_N1;
	
	public LearnOptionsWindow(StateStack stack, JFrame frame) {
		super(stack, frame, null);
		
		createComponents();
		addComponents();
		initComponents();
		
	}
	
	@Override
	protected void createComponents() {
		
		panel = new JPanel();
		
		level_N5 = new JButton("Level N5");
		level_N4 = new JButton("Level N4");
		level_N3 = new JButton("Level N3");
		level_N2 = new JButton("Level N2");
		level_N1 = new JButton("Level N1");
		
	}

	@Override
	protected void addComponents() {
		
		panel.add(level_N5);
		panel.add(level_N4);
		panel.add(level_N3);
		panel.add(level_N2);
		panel.add(level_N1);
		
		frame.add(panel);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		int buttonWidth = 200;
		int buttonHeight = 50;
		
		// Position buttons
		panel.setBounds(frame.getWidth() / 2 - buttonWidth / 2, 100, frame.getWidth(), frame.getHeight());
		//menuOptionsPanel.setLayout(new GridLayout());
		
		level_N5.setBounds(0, 0, buttonWidth, buttonHeight);
		level_N4.setBounds(0, buttonHeight, buttonWidth, buttonHeight);
		level_N3.setBounds(0, buttonHeight * 2, buttonWidth, buttonHeight);
		level_N2.setBounds(0, buttonHeight * 3, buttonWidth, buttonHeight);
		level_N1.setBounds(0, buttonHeight * 4, buttonWidth, buttonHeight);

	}
	
	@Override
	protected void addActionListeners() {
	}
	
}
