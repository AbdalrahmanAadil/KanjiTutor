package app;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends Window {

	private JPanel mainMenuOptionsPanel;
	private JButton learnWindow;
	//private JButton window_2_Button;
	//private JButton window_3_Button;
	//private JButton window_4_Button;

	public MainMenu(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		createComponents();
		addComponents();
		initComponents();
		
	}
	
	@Override
	protected void createComponents() {
		
		mainMenuOptionsPanel = new JPanel();
		
		learnWindow = new JButton("Learn by JLPT Level");
		//window_2_Button = new JButton("Window 2");
		//window_3_Button = new JButton("Window 3");
		//window_4_Button = new JButton("Window 4");
		
	}

	@Override
	protected void addComponents() {
		
		mainMenuOptionsPanel.add(learnWindow);
		//mainMenuOptionsPanel.add(window_2_Button);
		//mainMenuOptionsPanel.add(window_3_Button);
		//mainMenuOptionsPanel.add(window_4_Button);
		
		frame.add(mainMenuOptionsPanel);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		int buttonWidth = 200;
		int buttonHeight = 50;
		
		// Position buttons
		mainMenuOptionsPanel.setBounds(frame.getWidth() / 2 - buttonWidth / 2, 100, frame.getWidth(), frame.getHeight());
		//menuOptionsPanel.setLayout(new GridLayout());
		
		learnWindow.setBounds(0, 0, buttonWidth, buttonHeight);
		//window_2_Button.setBounds(0, buttonHeight, buttonWidth, buttonHeight);
		//window_3_Button.setBounds(0, buttonHeight * 2, buttonWidth, buttonHeight);
		//window_4_Button.setBounds(0, buttonHeight * 2, buttonWidth, buttonHeight);
		
	}

	@Override
	protected void addActionListeners() {
		learnWindow.addActionListener(
				e -> {
					stack.pop();
					stack.push(new LearnByLJPTLevel(stack, frame));
				}
		);
	}
	
}
