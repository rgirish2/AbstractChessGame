package com.rgirish2.assignment1.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.game.TwoDimensionalChessGame;
import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;
import com.rgirish2.assignment1.tile.AbstractTile;
import com.rgirish2.assignment1.tile.SquareTile;

/**
 * The main view for the 8X8 2 player chess game.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class EightByEightBoardGUI extends JFrame implements ActionListener {
	/**
	 * Adding default serialVersionUID;
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Final width and height for the 8X8 chess board.
	 * Final grid row and column count for the 8X8 chess board.
	 */
	private static final int gridRowCount = 8;
	private static final int gridColCount = 8;
	private static final int frameWidth = 800;
	private static final int frameHeight = 800;
	private static final boolean isOpaque = true;
	private static final boolean isBorderPainted = false;
	
	/**
	 * The control variables to allow the users to play the game.
	 */
	private int count = 1;
	private int curPosX = -1, curPosY = -1, newPosX, newPosY;
	
	/**
	 * The Swing panels and frames and game representation used to
	 * render the view. 
	 */
	public JFrame board;
	private JPanel panel;
	private TwoDimensionalChessGame game;

	/**
	 * Constructor for this 8X8 2 player chess board game GUI. 
	 * @param game The game that needs to provide the backing model for the view.
	 */
	public EightByEightBoardGUI(TwoDimensionalChessGame game) {
		this.game = game;
        this.board = new JFrame("8 X 8 Chess Board");
		this.panel = new JPanel();
		
        this.board.setSize(frameWidth, frameHeight);

        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		this.setCrossPlatformLookAndFeel();
		this.setChessPieces(this.game);
	}
	
	/**
	 * Makes the UI platform independent.
	 */
	private void setCrossPlatformLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			return;
		}
	}
	
	/**
	 * Sets the chess pieces on the chess board based on the input game.
	 * @param game The game that needs to be rendered on the view.
	 */
	private void setChessPieces(TwoDimensionalChessGame game) {
		GridLayout layout = new GridLayout(gridRowCount, gridColCount);
        
		this.panel.setLayout(layout);
		this.board.remove(this.panel);
		this.board.setContentPane(this.panel);
		this.setUpMenuBar();
		
        AbstractTwoDimensionalBoard board = game.getBoard();
        SquareTile [][] tiles = board.getBoard();
        for (int x = 0 ; x < board.getDimensionOne(); x++) {
        	for (int y = 0; y < board.getDimensionTwo(); y++) {
        		if (tiles[y][x].getPiece() != null) {
        			AbstractTile tile = tiles[y][x];
        			AbstractTwoDimensionalPiece piece = tile.getPiece();
        			JButton button = new JButton(piece.getUnicodeValue());
        			button.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        			button.setBackground(tile.getColor());
        			button.setOpaque(isOpaque);
        			button.setBorderPainted(isBorderPainted);
        			button.setToolTipText(piece.getPieceType().toString());
        			button.putClientProperty("x", y);
        			button.putClientProperty("y", x);
        			button.addActionListener(this);
        			this.panel.add(button);
        		} else {
        			AbstractTile tile = tiles[y][x];
        			JButton button = new JButton();
        			button.putClientProperty("x", y);
        			button.putClientProperty("y", x);
        			button.setBackground(tile.getColor());
        			button.setOpaque(isOpaque);
        			button.setBorderPainted(isBorderPainted);
        			button.addActionListener(this);
        			this.panel.add(button);
        		}
        	}
        }
	}
	
	/**
	 * Sets up the menubar on the JPanel of the view.
	 */
	private void setUpMenuBar() {
		JMenuBar menubar = new JMenuBar();
        
		JMenu options = new JMenu("Options");
        
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem restart = new JMenuItem("Restart");
        JMenuItem exit = new JMenuItem("Exit");
        
        undo.putClientProperty("name", "UNDO");								// Naive way of understand calling signal. Think of better implementation.
        restart.putClientProperty("name", "RESTART");
        exit.putClientProperty("name", "EXIT");
        undo.addActionListener(this);
        restart.addActionListener(this);
        exit.addActionListener(this);
        
        options.add(undo);
        options.add(restart);
        options.add(exit);
        
        menubar.add(options);
        
        this.board.setJMenuBar(menubar);
	}
	
	/**
	 * Check the action performed by the user and makes the request to the
	 * chess board to make movements on the view.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton button = (JButton)e.getSource();
			if (this.count == 2) {
				if (button.getClientProperty("x") instanceof Integer && button.getClientProperty("y") instanceof Integer) {
					this.newPosX = (Integer)button.getClientProperty("x");						
					this.newPosY = (Integer)button.getClientProperty("y");
				} else {
					this.count = 1;
					return;
				}
				
		        boolean result = this.game.movePiece(curPosX, curPosY, newPosX, newPosY);
		        
		        if (result) {
		        	this.renderView();
		        	this.count = 1;
		        } else {
		        	String invalidMove = String.format("Invalid move. Please try again. Tried:\ncurX: %s\ncurY: %s\nnewX: %s\nnewY: %s", this.curPosX, this.curPosY, this.newPosX, this.newPosY);
			        JOptionPane.showMessageDialog(null, invalidMove, "Invalid Move", JOptionPane.INFORMATION_MESSAGE);
		        	this.count = 1;
		        }
			} else {
				if (button.getClientProperty("x") instanceof Integer && button.getClientProperty("y") instanceof Integer) { 
					this.curPosX = (Integer)button.getClientProperty("x");
					this.curPosY = (Integer)button.getClientProperty("y");
					this.count++;
				} else {
					this.count++;
				}
			}
		} else if (e.getSource() instanceof JMenuItem) {
			JMenuItem jMenuItem = (JMenuItem)e.getSource();
			if (jMenuItem.getClientProperty("name") instanceof String) {
				String item = (String)jMenuItem.getClientProperty("name");
				if (item.equals("UNDO")) {
					this.game.undoLastMove();
					this.renderView();
				} else if (item.equals("RESTART")) {
					this.game.restartGame();
					this.renderView();
				} else if (item.equals("EXIT")){
					this.game = null;
					this.board.dispose();
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
	}
	
	/**
	 * Re-renders the view for the user of the GUI.
	 */
	public void renderView() {
    	this.panel.removeAll();
    	this.setChessPieces(this.game);
    	this.panel.revalidate();
    	this.panel.repaint();
	}
}
