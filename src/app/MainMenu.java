package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends Window {

	private JPanel panel;
	private JButton learnWindow;
	private JButton window_2_Button;
	private JButton window_3_Button;
	private JButton window_4_Button;

	public MainMenu(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		frame.setLayout(null);
		
		createComponents();
		initComponents();
		addComponents();
		
		
		frame.setVisible(true);
	}
	
	@Override
	protected void createComponents() {
		
		panel = new JPanel();
		
		learnWindow = new JButton("Learn by JLPT Level");
		
		window_2_Button = new JButton("Window 2");
		window_3_Button = new JButton("Window 3");
		window_4_Button = new JButton("Window 4");
		
	}

	@Override
	protected void addComponents() {
		
		panel.add(learnWindow);
		panel.add(window_2_Button);
		panel.add(window_3_Button);
		panel.add(window_4_Button);
		
		frame.add(panel);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		int offsetX = 250;
		int panelHeight = 400;
		
		panel.setBounds(offsetX, 80, 200, panelHeight);
		panel.setLayout(new GridLayout(6, 2, 10, 10));
		
		//panel.setBackground(new Color(0x00ff00));
		//panel.setBorder(BorderFactory.createLineBorder(new Color(0x777777)));
		//panel.s
	}

	@Override
	protected void addActionListeners() {
		learnWindow.addActionListener(
				e -> {
					stack.pop();
					stack.push(new PickMaterial(stack, frame));
				}
		);
	}
	
}
