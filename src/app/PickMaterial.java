package app;

import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.GridLayout;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
//import javax.swing.JPanel;

public class PickMaterial extends Window {

	private JButton startButton;
	private JComboBox<String> categoriesCombo;
	private JComboBox<String> levelsCombo;
	
	String[] categories = {
						 "adj", "animals", "human_body",
						 "nature", "city", "everyday", "numbers",
						 "people", "prepositions", "time", "verbs"};
	
	String[] levels = { "N5", "N4", "N3", "N2", "N1" };
	
	public PickMaterial(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		frame.setLayout(null);
		
		createComponents();
		initComponents();
		addComponents();
		
		
		frame.setVisible(true);
	}
	
	@Override
	protected void createComponents() {
		
		levelsCombo = new JComboBox<>();
		categoriesCombo = new JComboBox<>();
		
		startButton = new JButton("Start");
		
		for(String s : levels) {
			levelsCombo.addItem(s);
		}
		
		for(String s : categories) {
			categoriesCombo.addItem(s);
		}
	}

	@Override
	protected void addComponents() {
		
		frame.add(startButton);
		frame.add(levelsCombo);
		frame.add(categoriesCombo);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		levelsCombo.setBounds(220, 100, 100, 50);
		categoriesCombo.setBounds(340, 100, 100, 50);

		startButton.setBounds(230, 230, 200, 50);
	}

	@Override
	protected void addActionListeners() {
		startButton.addActionListener(
				e -> {
					stack.pop();
					
					stack.push(new Learn(stack, frame, Level.N5, (String)categoriesCombo.getSelectedItem()));
				}
			);
	}
}