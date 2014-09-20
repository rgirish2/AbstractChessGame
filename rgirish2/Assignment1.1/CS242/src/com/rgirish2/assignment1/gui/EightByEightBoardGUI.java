package com.rgirish2.assignment1.gui;

import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.game.TwoDimensionalChessGame;
import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;
import com.rgirish2.assignment1.tile.AbstractTile;
import com.rgirish2.assignment1.tile.SquareTile;

@SuppressWarnings("serial")
public class EightByEightBoardGUI extends JFrame {
	private JFrame board;
	private JPanel panel;
	
	public EightByEightBoardGUI() {
        this.board = new JFrame("8 X 8 Chess Board");
		this.panel = new JPanel();
		
        this.board.setSize(2000, 1200);
        
        this.board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		this.panel.setLayout(new GridBagLayout());
		this.board.setContentPane(panel);
	}
	
	public void setChessPieces(TwoDimensionalChessGame game) {
        System.out.println("New Chess Board");
        AbstractTwoDimensionalBoard board = game.getBoard(); 

        SquareTile [][] tiles = board.getBoard();
        for (int x = 0 ; x < board.getDimensionOne(); x++) {
        	for (int y = 0; y < board.getDimensionTwo(); y++) {
        		if (tiles[y][x].getPiece() != null) {
        			AbstractTile tile = tiles[y][x];
        			AbstractTwoDimensionalPiece piece = tile.getPiece();
        			
        			JButton button = new JButton(piece.getUnicodeValue());
        			button.setFont(new Font("Piece", Font.BOLD, 50));
        			button.setBackground(tile.getColor());
        			this.panel.add(button);
        		} else {
        			AbstractTile tile = tiles[y][x];
        			JButton button = new JButton(x + ", " + y);
        			button.setBackground(tile.getColor());
        			this.panel.add(button);
        		}
        	}
        }
/*        
        JButton king = new JButton("\u2654");
        king.setFont(new Font("King", Font.BOLD, 50));
        
        JButton queen = new JButton("\u2655");
        queen.setFont(new Font("Queen", Font.BOLD, 50));
        
        JButton rook = new JButton("\u2656");
        rook.setFont(new Font("Rook", Font.BOLD, 50));
        
        JButton bishop = new JButton("\u2657");
        bishop.setFont(new Font("Bishop", Font.BOLD, 50));
        
        JButton knight = new JButton("\u2658");
        knight.setFont(new Font("Knight", Font.BOLD, 50));
        
        JButton pawn = new JButton("\u2659");
        pawn.setFont(new Font("Pawn", Font.BOLD, 50));
        
        JButton Bking = new JButton("\u265A");
        Bking.setFont(new Font("King", Font.BOLD, 50));
        
        JButton Bqueen = new JButton("\u265B");
        Bqueen.setFont(new Font("Queen", Font.BOLD, 50));
        
        JButton Brook = new JButton("\u265C");
        Brook.setFont(new Font("Rook", Font.BOLD, 50));
        
        JButton Bbishop = new JButton("\u265D");
        Bbishop.setFont(new Font("Bishop", Font.BOLD, 50));
        
        JButton Bknight = new JButton("\u265E");
        Bknight.setFont(new Font("Knight", Font.BOLD, 50));
        
        JButton Bpawn = new JButton("\u265F");
        Bpawn.setFont(new Font("Pawn", Font.BOLD, 50));
        
        this.panel.add(king);
        this.panel.add(queen);
        this.panel.add(rook);
        this.panel.add(bishop);
        this.panel.add(knight);
        this.panel.add(pawn);
        
        this.panel.add(Bking);
        this.panel.add(Bqueen);
        this.panel.add(Brook);
        this.panel.add(Bbishop);
        this.panel.add(Bknight);
        this.panel.add(Bpawn);
*/
        this.board.setVisible(true);
	}
	
	public static void main(String [] args) {
		String [] names = {"Rishi", "Neo"};
		
		TwoDimensionalChessGame game = new TwoDimensionalChessGame(names);
		
		EightByEightBoardGUI chessBoardGUI = new EightByEightBoardGUI();
		
		chessBoardGUI.setChessPieces(game);
	}
}
