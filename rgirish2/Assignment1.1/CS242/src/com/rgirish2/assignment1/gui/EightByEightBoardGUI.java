package com.rgirish2.assignment1.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.board.EightByEightBoard;
import com.rgirish2.assignment1.piece.AbstractPieceSet;
import com.rgirish2.assignment1.player.AbstractPlayer;
import com.rgirish2.assignment1.player.NormalChessPlayer;

@SuppressWarnings("serial")
public class EightByEightBoardGUI extends JFrame {
	private JFrame board;
	
	public EightByEightBoardGUI() {
        this.board = new JFrame("8 X 8 Chess Board");
        
        this.board.setSize(800, 800);
        
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.board.setLayout(new FlowLayout());
	}
	
	public void setChessPieces(AbstractTwoDimensionalBoard board) {
        System.out.println("New Chess Board");
        
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
		int playerCount = 2;
		
		AbstractPlayer [] players = new NormalChessPlayer[playerCount];
		AbstractTwoDimensionalBoard chessBoard = new EightByEightBoard();
		List<AbstractPieceSet> allPieceSet = new ArrayList<AbstractPieceSet>();
		
		for (int i = 0; i < playerCount; i++) {
			players[i] = new NormalChessPlayer("", i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}
		
		chessBoard.buildBoard(allPieceSet);
		
		EightByEightBoardGUI chessBoardGUI = new EightByEightBoardGUI();
		
		chessBoardGUI.setChessPieces(chessBoard);
	}
}
