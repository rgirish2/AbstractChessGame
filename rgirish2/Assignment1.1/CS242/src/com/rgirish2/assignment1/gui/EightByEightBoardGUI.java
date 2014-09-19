package com.rgirish2.assignment1.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.game.TwoDimensionalChessGame;

@SuppressWarnings("serial")
public class EightByEightBoardGUI extends JFrame {
	private JFrame board;
	
	public EightByEightBoardGUI() {
        this.board = new JFrame("8 X 8 Chess Board");
        
        this.board.setSize(800, 800);
        
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.board.setLayout(new FlowLayout());
	}
	
	public void setChessPieces(TwoDimensionalChessGame game) {
        System.out.println("New Chess Board");
        AbstractTwoDimensionalBoard board = game.getBoard(); 
        
        String [] columnNames = new String [board.getDimensionOne()];
        for (int i = 1; i <= board.getDimensionOne(); i++) {
        	columnNames[i - 1] = Integer.toString(i);
        }
        
        JTable jTable = new JTable(board.getBoard(), columnNames);
        
        this.board.add(jTable);
        
        this.board.pack();
        this.board.setVisible(true);
	}
	
	public static void main(String [] args) {
		String [] names = {"Rishi", "Neo"};
		
		TwoDimensionalChessGame game = new TwoDimensionalChessGame(names);
		
		EightByEightBoardGUI chessBoardGUI = new EightByEightBoardGUI();
		
		chessBoardGUI.setChessPieces(game);
	}
}
