package app;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends Window {

	private JButton masteredKanjiButton;
	private JButton kanjiTargetsButton;
	private JButton learnButton;
	private JButton takeQuizButton;

	public MainMenu(StateStack stack, JFrame frame) {
		super(stack, frame);
		
		createComponents();
		initialize();
		addComponents();
		initComponents();
		
	}
	
	@Override
	protected void createComponents() {
		masteredKanjiButton = new JButton("Mastered Kanji");
		kanjiTargetsButton = new JButton("Add Kanji");
		learnButton = new JButton("Learn");
		takeQuizButton = new JButton("Take a Quiz");
	}

	@Override
	protected void initialize() {}

	@Override
	protected void addComponents() {
		frame.add(masteredKanjiButton);
		frame.add(kanjiTargetsButton);
		frame.add(learnButton);
		frame.add(takeQuizButton);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		// Position buttons
		
		masteredKanjiButton.setBounds(0, 0, 150, 50);
		kanjiTargetsButton.setBounds(0 + 150, 0, 150, 50);
		learnButton.setBounds(0 + 0, 50, 150, 50);
		takeQuizButton.setBounds(0 + 150, 50, 150, 50);
		
	}

	@Override
	protected void addActionListeners() {
		takeQuizButton.addActionListener(
				e -> {
					stack.pop();
					stack.push(new Quiz(stack, frame));
				}
		);
	}
	
}
