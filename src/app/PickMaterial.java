package app;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class PickMaterial extends Window {
	
	private JButton startButton;
	
	private JComboBox<String> catCombo, subcatCombo;
	
	private ArrayList<String> firstComboList;
	private ArrayList<String[]> secondComboList;
	
	public PickMaterial(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		frame.setLayout(null);
		
		firstComboList = new ArrayList<>(); 
		secondComboList = new ArrayList<String[]>();
		
		createComponents();
		initComponents();
		addComponents();
		
		frame.setVisible(true);
	}
	
	@Override
	protected void createComponents() {
		
		catCombo = new JComboBox<>();
		subcatCombo = new JComboBox<>();
		startButton = new JButton("Start");
	}
	
	@Override
	protected void addComponents() {
		
		frame.add(startButton);
		frame.add(catCombo);
		frame.add(subcatCombo);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		String[] folders = new File("kanji").list(); // array
		
		for (int i = 0; i < folders.length; ++i) {
			firstComboList.add(folders[i]);	
			secondComboList.add(new File("kanji/" + folders[i]).list());
		}
		
		for (String x : firstComboList) {
			catCombo.addItem(x);
		}
		
		String[] xx = secondComboList.get(0);
		
		for (String x : xx) {
			subcatCombo.addItem(x);
		}
		
		catCombo.setBounds(220, 100, 100, 50);
		subcatCombo.setBounds(340, 100, 100, 50);

		startButton.setBounds(230, 230, 200, 50);
	}

	private String getPath() {
		return "kanji/" + catCombo.getSelectedItem() + "/"
				   + subcatCombo.getSelectedItem();
	}
	
	@Override
	protected void addActionListeners() {
		
		startButton.addActionListener(
				e -> {
					stack.pop();
					var learnState = new Learn(stack, frame, getPath()); 
					stack.push(learnState);
				}
		);
		
		catCombo.addActionListener(
				e -> {
					subcatCombo.removeAllItems();
					catCombo.getSelectedIndex();
					
					 for (String string : secondComboList.get(catCombo.getSelectedIndex())) {
						subcatCombo.addItem(string);
					}
				}
		);
	}
}