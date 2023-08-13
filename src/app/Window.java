package app;

import javax.swing.JFrame;

public abstract class Window /*extends JFrame*/ {
	
	StateStack stack;
	JFrame frame;
	
	public Window() {
		this.stack = null;
	}
	
	public Window(StateStack stack, JFrame frame) {
		this.stack = stack;
		this.frame = frame;
	}
	
	protected abstract void createComponents();
	protected abstract void initialize();
	protected abstract void addComponents();
	protected abstract void initComponents();
	protected abstract void addActionListeners();
	
	protected void clear() {
		frame.removeAll();
	}
	
}
