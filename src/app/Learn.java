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

	private int currentCard;
	private JLabel label;
	
	private JButton nextButton;
	private JButton prevButton;
	private JButton goToFirst;
	private JButton goToLast;
	private JButton backButton;
	
	private JPanel cardPanel;
	private JPanel controlPanel;
	
	private String directory;
	
	private final int CARD_IMAGE_WIDTH = 576;
	private final int CARD_IMAGE_HEIGHT = 180;
	
	File[] files;
	
	public Learn(StateStack stack, JFrame frame, String directory) {
		// 3rd argument is layout
		super(stack, frame, null);
		
		this.directory = directory;
		
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
		backButton = new JButton("Back");
	}
	
	protected void loadCards() {
		
		files = new File(directory).listFiles();
		
		for (File file : files)
			cards.add(new ImageIcon(file.getPath()));
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
		label.setText( (currentCard+1) + " / " + files.length);
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
					stack.push(new PickMaterial(stack, frame));
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
		
		label.setText( (currentCard+1) + " / " + files.length);
		label.setIcon(cards.get(currentCard));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(0xFFFFFF));
		label.setFont(new Font("Arial", Font.PLAIN, 30));	

		int startX = (frame.getWidth() - label.getIcon().getIconWidth()) >> 1;
		int startY = cardPanel.getHeight() / 2 - 75;
		
		label.setBounds(startX, startY, CARD_IMAGE_WIDTH, CARD_IMAGE_HEIGHT);
		
		int controlsBtnsTotalWidth = 200;
		int halfWidth = (controlPanel.getWidth() - controlsBtnsTotalWidth) >> 1;
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
