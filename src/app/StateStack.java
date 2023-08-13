package app;

import java.util.Stack;

import javax.swing.JFrame;

public class StateStack {
	
	JFrame frame;
	Stack<Window> stack = new Stack<>();
	
	public StateStack(JFrame frame) {
		this.frame = frame;
	}
	
	public void push(Window window) {
		stack.push(window);
	}
	
	public void pop() {
		frame.getContentPane().removeAll();
		frame.repaint();
		stack.pop();
		
	}
}

