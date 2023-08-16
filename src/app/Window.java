package app;

import java.awt.LayoutManager;

import javax.swing.JFrame;

enum Level {
	N1, N2, N3, N4, N5
}

public abstract class Window {
	
	StateStack stack;
	JFrame frame;
	
	public Window() {
		this.stack = null;
	}
	
	public Window(StateStack stack, JFrame frame, LayoutManager layout) {
		this.stack = stack;
		this.frame = frame;
		frame.setLayout(layout);
	}
	
	protected abstract void createComponents();
	protected abstract void addComponents();
	protected abstract void initComponents();
	protected abstract void addActionListeners();
	
	protected void clear() {
		frame.removeAll();
	}
	
}
