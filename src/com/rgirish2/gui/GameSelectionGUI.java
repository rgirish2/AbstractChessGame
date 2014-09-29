package com.rgirish2.assignment1.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameSelectionGUI extends JFrame implements ActionListener {

	/**
	 * Adding default serialVersionUID;
	 */
	private static final long serialVersionUID = 1L;
	
    private JPanel gameSelection;
	private final JTextField player1Name = new JTextField("Player 1 Name", 20);
	private final JTextField player2Name = new JTextField("Player 2 Name", 20);
	private final JButton btnSubmit= new JButton("Submit");
	
	private String player1;
	private String player2;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.player1 = this.player1Name.getText();
		this.player2 = this.player2Name.getText();
		this.dispose();
	}
     
    public void addComponentToPane(Container pane) {
    	this.btnSubmit.addActionListener(this);
         
        JPanel playerNamesPanel = new JPanel();
        playerNamesPanel.add(this.player1Name);
        playerNamesPanel.add(this.player2Name);
        playerNamesPanel.add(this.btnSubmit); 
        
        //Create the panel that contains the "gameSelection".
        gameSelection = new JPanel(new CardLayout());
        gameSelection.add(playerNamesPanel, "Player Names");

        pane.add(gameSelection, BorderLayout.PAGE_START);
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Game Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        GameSelectionGUI demo = new GameSelectionGUI();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
