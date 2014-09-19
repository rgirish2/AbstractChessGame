package com.rgirish2.assignment1.board;

import java.util.List;

import com.rgirish2.assignment1.piece.AbstractPieceSet;
import com.rgirish2.assignment1.piece.BishopPiece;
import com.rgirish2.assignment1.piece.KingPiece;
import com.rgirish2.assignment1.piece.KnightPiece;
import com.rgirish2.assignment1.piece.NormalPieceSet;
import com.rgirish2.assignment1.piece.PawnPiece;
import com.rgirish2.assignment1.piece.QueenPiece;
import com.rgirish2.assignment1.piece.RookPiece;
import com.rgirish2.assignment1.tile.Colors;
import com.rgirish2.assignment1.tile.SquareTile;

/**
 * Represents a concrete chess board which is of square shape
 * and of width and height 8. 
 * This represents a normal chess board in my understanding.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class EightByEightBoard extends AbstractSquareBoard {
	
	/**
	 * Create a new 8 by 8 board by calling the constructor for SquareBoard with arguments 8 and 8. And the board is designed for two players.
	 */
	public EightByEightBoard() {
		super(8, 8, 2);
	}
	
	/**
	 * Builds a chess board for all the players game using the piece-Sets passed along
	 * as the argument.
	 * 
	 * @param pieceSet A list of pieceSets that encapsulates all the pieces for a single player.
	 */
	@Override
	public void buildBoard(List<AbstractPieceSet> pieceSet) {
		boolean flag = false;
		for (int i = 0; i < 8; i++) {
			Colors color = Colors.WHITE;
			if (flag) {
				color = Colors.BLACK;
				flag = !flag;
			} else {
				flag = !flag;
			}
			for (int j = 0; j < 8; j++) {
				this.board[j][i] = new SquareTile(null, color);
				color = color.equals(Colors.BLACK) ? Colors.WHITE : Colors.BLACK;
			}
		}
		
		for (AbstractPieceSet onePieceSet : pieceSet) {
			if (onePieceSet instanceof NormalPieceSet) {
				NormalPieceSet asNormalPieceSet = (NormalPieceSet)onePieceSet;
				for (PawnPiece onePawn : asNormalPieceSet.getPawnList()) {
					int x = onePawn.getPosX();
					int y = onePawn.getPosY();
					this.board[x][y].setPiece(onePawn);
				}
				
				for (RookPiece oneRook : asNormalPieceSet.getRookList()) {
					int x = oneRook.getPosX();
					int y = oneRook.getPosY();
					this.board[x][y].setPiece(oneRook);
				}
				
				for (KnightPiece oneKnight : asNormalPieceSet.getKnightList()) {
					int x = oneKnight.getPosX();
					int y = oneKnight.getPosY();
					this.board[x][y].setPiece(oneKnight);
				}
				
				for (BishopPiece oneBishop : asNormalPieceSet.getBishopList()) {
					int x = oneBishop.getPosX();
					int y = oneBishop.getPosY();
					this.board[x][y].setPiece(oneBishop);
				}
				
				for (QueenPiece oneQueen : asNormalPieceSet.getQueenList()) {
					int x = oneQueen.getPosX();
					int y = oneQueen.getPosY();
					this.board[x][y].setPiece(oneQueen);
				}
				
				for (KingPiece oneKing : asNormalPieceSet.getKingList()) {
					int x = oneKing.getPosX();
					int y = oneKing.getPosY();
					this.board[x][y].setPiece(oneKing);
				}
			} else {
				throw new IllegalArgumentException("This pieceSet is not supported at this moment. Please try again later.");
			}
		}
	}
	
	/**
	 * Returns a string representation of the this chess board.
	 * Marks X where the tiles are NULL, otherwise calls the toString()
	 * method of the tile.
	 * 
	 * @return A string representation of this chess board.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.dimensions.get(0); i++) {
			for (int j = 0; j < this.dimensions.get(1); j++) {
				if (this.board[i][j] == null) {
					builder.append("X");
				} else {
					builder.append(this.board[i][j]);
				}
				builder.append("\t");
			}
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}
}
