package app;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window3 extends Window {
	
	
	
	private ArrayList<ImageIcon> cards = new ArrayList<>();
	private int currentCard;
	private JLabel label;
	
	private JButton nextButton;
	private JButton prevButton;
	private JButton goToFirst;
	private JButton goToLast;
	
	private JPanel cardPanel;
	private JPanel controlPanel;
	
	public Window3(StateStack stack, JFrame frame) {
		// 3rd argument is layout
		super(stack, frame, null);
		
		currentCard = 0;
		
		createComponents();
		loadCards();
		addComponents();
		initComponents();
		
	}
	
	@Override
	protected void createComponents() {
		cardPanel = new JPanel();
		controlPanel = new JPanel();
		label = new JLabel();
		
		nextButton = new JButton("Next");
		prevButton = new JButton("Prev");
		goToFirst = new JButton("First");
		goToLast = new JButton("Last");
	}
	
	protected void loadCards() {
		for(int i = 1; i < 32; ++i) {
			cards.add(new ImageIcon("kanji/N5/" + i + ".png"));
		}
	}
	
	@Override
	protected void addComponents() {
		
		cardPanel.add(label);
		
		controlPanel.add(nextButton);
		controlPanel.add(prevButton);
		controlPanel.add(goToFirst);
		controlPanel.add(goToLast);
		
		frame.add(cardPanel);
		frame.add(controlPanel);
	}
	
	@Override
	protected void addActionListeners() {
		nextButton.addActionListener(
				e -> {
					if (currentCard == cards.size() - 1) {
						return;
					}
					++currentCard;
					label.setIcon(cards.get(currentCard));
				}
		);
		
		prevButton.addActionListener(
				e -> {
					if (currentCard == 0) {
						return;
					}
					--currentCard;
					label.setIcon(cards.get(currentCard));
				}
		);
		
		goToFirst.addActionListener(
				e -> {
					currentCard = 0;
					label.setIcon(cards.get(currentCard));
				}
		);
		
		goToLast.addActionListener(
				e -> {
					currentCard = cards.size() - 1;
					label.setIcon(cards.get(currentCard));
				}
		);
	}
	
	@Override
	protected void initComponents() {
		
		cardPanel.setBounds(0, 0, frame.getWidth(), 250);
		cardPanel.setBackground(new Color(0x22BCF0));
		cardPanel.setLayout(null);
		
		controlPanel.setBounds(0, 250, frame.getWidth(), 250);
		controlPanel.setBackground(new Color(0xaaaaaa));
		controlPanel.setLayout(null);
		
		addActionListeners();
		
		label.setIcon(cards.get(currentCard));
		label.setBounds(frame.getWidth() / 2 - 75, cardPanel.getHeight() / 2 - 75, 150, 150);
		
		int controlsBtnsTotalWidth = 200;
		int halfWidth = (controlPanel.getWidth() / 2) - (controlsBtnsTotalWidth / 2);
		prevButton.setBounds(halfWidth, 0, 100, 50);
		nextButton.setBounds(halfWidth + 100, 0, 100, 50);
		goToFirst.setBounds(halfWidth + 0, 50, 100, 50);
		goToLast.setBounds(halfWidth + 100, 50, 100, 50);
		
		prevButton.setFocusable(false);
		nextButton.setFocusable(false);
		goToFirst.setFocusable(false);
		goToLast.setFocusable(false);
		
		
	}
	


	
}
