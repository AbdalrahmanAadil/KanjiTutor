package app;

import java.awt.BorderLayout;

//import java.awt.Color;
//import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
//import javax.swing.JPanel;



public class PickMaterial extends Window {
	

	
	private JButton startButton;
	private JComboBox<String> catCombo;
	private JComboBox<String> subcatCombo;
	
	String[] categories;
	
	ArrayList<String> firstCombo; 
	ArrayList<String[]> secondCombo;
	
	String[] folders;
	String[] subfolders;
	
	public PickMaterial(StateStack stack, JFrame frame) {
		super(stack, frame, new BorderLayout());
		
		frame.setLayout(null);
		
		firstCombo = new ArrayList<>(); 
		secondCombo = new ArrayList<String[]>();
		
		firstCombo.add("Fruits");
		firstCombo.add("Animals");
		firstCombo.add("Things");
		
		secondCombo.add(new String[]{"Apple", "Banana", "Cherry"});
		secondCombo.add(new String[]{"Duck", "Crocodile", "Fish"});
		secondCombo.add(new String[]{"Pen", "Pencil", "Eraser"});
		
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

	private String[] foldersInDir(String foldername) {
		
		// array of files
		String[] folders = new File(foldername).list();
		
		if (folders == null) return new String[0];
		
		for (int i = 0; i < folders.length; ++i) {
			if (! new File(foldername + "/" + folders[i]).isDirectory()) {
				 folders[i] = "";
			}
		}
		return folders;
	}
	
	@Override
	protected void addComponents() {
		
		//String[] folders = getDirectories("kanji");
		/*
		folders = foldersInDir("kanji"); // array
		
		for (int i = 0; i < folders.length; ++i) {
			if ( ! folders[i].isEmpty()) {
				Item item = new Item(folders[i], i);
				
				subfolders = foldersInDir("kanji/" + folders[i]);
				
				for (int j = 0; j < subfolders.length; ++j) {
					if ( ! subfolders[j].isEmpty()) {
						item.add(subfolders[j]);
						
						subcatCombo.addItem(new Item(subfolders[j], j));
					}
				}

				catCombo.addItem(item);
			}
				
		}
		*/
	
		
		//catCombo.setSelectedIndex(0);
		
		/*
		subcatCombo.removeAllItems();
		
		subcatCombo.addItem(new Item("A", 0));
		subcatCombo.addItem(new Item("B", 1));
		subcatCombo.addItem(new Item("C", 2));
		
		
		

		
		*/
		frame.add(startButton);
		frame.add(catCombo);
		frame.add(subcatCombo);
	}

	@Override
	protected void initComponents() {
		addActionListeners();
		
		for (String string : firstCombo) {
			catCombo.addItem(string);
		}
		
		catCombo.setBounds(220, 100, 100, 50);
		subcatCombo.setBounds(340, 100, 100, 50);

		startButton.setBounds(230, 230, 200, 50);
	}

	@Override
	protected void addActionListeners() {
		/*startButton.addActionListener(
				e -> {
					stack.pop();
					stack.push(new Learn(stack, frame, Level.N5,
							"kanji/" + catCombo.getSelectedItem() + "/"
						   + subcatCombo.getSelectedItem()));
				}
		);*/
		
		catCombo.addActionListener(
				e -> {
					
					subcatCombo.removeAllItems();
					
					int index = catCombo.getSelectedIndex();
					
					for (String string : secondCombo.get(index)) {
						subcatCombo.addItem(string);
					}
					// get all sub-categories associated with this index
					
					
					
					
					
					
					// update 2nd JComboBox with
					
					// subcatCombo.removeAllItems();
					
					//subcatCombo.removeAllItems();
					
					//int i = catCombo.getSelectedIndex();
					
					//subcatCombo.addItem(new Item("Julian", 0));
					
					
					//catCombo.getSelectedIndex();
					// populate the 2nd JComboBox with the corresponding items
					
					//subcatCombo.;
					
				}
				);
	}
}