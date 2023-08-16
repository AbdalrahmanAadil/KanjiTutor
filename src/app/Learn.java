package app;

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import app.LearnByLJPTLevel.Level;

public class Learn extends Window {
	
	private ArrayList<ImageIcon> cards = new ArrayList<>();
	private int numOfCards;
	
	private int currentCard;
	private JLabel label;

	
	private JButton nextButton;
	private JButton prevButton;
	private JButton goToFirst;
	private JButton goToLast;
	private JButton backButton;
	
	private JPanel cardPanel;
	private JPanel controlPanel;
	
	private Level level;
	
	public Learn(StateStack stack, JFrame frame, Level level) {
		// 3rd argument is layout
		super(stack, frame, null);
		
		this.level= level;
		
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
		backButton = new JButton("Back to JLPT Levels");
	}
	
	protected void loadCards() {
		
		String levelFolder = getLevel(level);
		this.numOfCards = new File("kanji/" + levelFolder).list().length;
		for(int i = 0; i < numOfCards; ++i) {
			cards.add(new ImageIcon("kanji/" + levelFolder + "/" + i + ".png"));
		}
	}
	
	private String getLevel(Level level) {
		switch (level) {
		
			case N5: return "N5";
			case N4: return "N4";
			case N3: return "N3";
			case N2: return "N2";
			case N1: return "N1";
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + level);
		}
	}

	@Override
	protected void addComponents() {
		
		cardPanel.add(label);
		
		controlPanel.add(nextButton);
		controlPanel.add(prevButton);
		controlPanel.add(goToFirst);
		controlPanel.add(goToLast);
		controlPanel.add(backButton);
		
		
		frame.add(cardPanel);
		frame.add(controlPanel);
	}
	
	private void updateCard() {
		label.setIcon(cards.get(currentCard));
		label.setText( (currentCard+1) + " / " + numOfCards);
	}
	
	@Override
	protected void addActionListeners() {
		nextButton.addActionListener(
				e -> {
					if (currentCard == cards.size() - 1) {
						return;
					}
					++currentCard;
					updateCard();
				}
		);
		
		prevButton.addActionListener(
				e -> {
					if (currentCard == 0) {
						return;
					}
					--currentCard;
					updateCard();
				}
		);
		
		goToFirst.addActionListener(
				e -> {
					currentCard = 0;
					updateCard();
				}
		);
		
		goToLast.addActionListener(
				e -> {
					currentCard = cards.size() - 1;
					updateCard();
				}
		);
		
		backButton.addActionListener(
				e -> {
					stack.pop();
					stack.push(new LearnByLJPTLevel(stack, frame));
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
		
		label.setText( (currentCard+1) + " / " + numOfCards);
		label.setIcon(cards.get(currentCard));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(0xFFFFFF));
		label.setFont(new Font("Arial", Font.PLAIN, 30));	

		label.setBounds(frame.getWidth() / 2 - 75, cardPanel.getHeight() / 2 - 75, 180, 180);
		
		int controlsBtnsTotalWidth = 200;
		int halfWidth = (controlPanel.getWidth() / 2) - (controlsBtnsTotalWidth / 2);
		int marginTop = 30;
		prevButton.setBounds(halfWidth, marginTop, 100, 50);
		nextButton.setBounds(halfWidth + 100, marginTop, 100, 50);
		goToFirst.setBounds(halfWidth + 0, 50 + marginTop, 100, 50);
		goToLast.setBounds(halfWidth + 100, 50 + marginTop, 100, 50);
		backButton.setBounds(halfWidth, 100 + marginTop, 200, 50);
		
		prevButton.setFocusable(false);
		nextButton.setFocusable(false);
		goToFirst.setFocusable(false);
		goToLast.setFocusable(false);
		
		
	}
}
