package app;

import javax.swing.JFrame;
import java.awt.BorderLayout;
//import javax.swing.JButton;
//import javax.swing.JPanel;

public class Window2 extends Window {

	public Window2(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		createComponents();
		addComponents();
		initComponents();
		
	}
	
	@Override
	protected void createComponents() {
	}
	
	@Override
	protected void addComponents() {
	}

	@Override
	protected void initComponents() {
		addActionListeners();
	}
	
	@Override
	protected void addActionListeners() {
	}
	
}
