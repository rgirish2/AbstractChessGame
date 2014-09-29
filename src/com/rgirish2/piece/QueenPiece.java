package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.movementValidity.TwoDimensionMovementsValidator;

/**
 * A chess piece which is of type QUEEN of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class QueenPiece extends AbstractTwoDimensionalPiece {

	public QueenPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.QUEEN, ordinal, ordinal.equals(NormalPlayerOrdinal.ONE) ? PiecesUnicode.WHITEQUEEN : PiecesUnicode.BLACKQUEEN);
	}
	
	/**
	 * This method verifies whether the move being request is valid or not.
	 * @param board The board on which this movement is being requested.
	 * @param newPosX The new X dimensional position of this piece in a 2-D board.
	 * @param newPosY The new Y dimensional position of this piece in a 2-D board.
	 * @return True if this move valid, False otherwise.
	 */
	@Override
	public boolean isValidMove(AbstractTwoDimensionalBoard board, int newPosX, int newPosY) {
		int curPosX = this.getPosX();
		int curPosY = this.getPosY();
		
		try {
			boolean isValidHorizontal = TwoDimensionMovementsValidator.isValidHorizontalMovement(board, curPosX, curPosY, newPosX, newPosY);
			boolean isValidVertical = TwoDimensionMovementsValidator.isValidVerticalMovement(board, curPosX, curPosY, newPosX, newPosY);
			boolean isValidDiagonal = TwoDimensionMovementsValidator.isValidDiagonalMovement(board, curPosX, curPosY, newPosX, newPosY);
			
			return isValidHorizontal || isValidVertical || isValidDiagonal;
		} catch (NullPointerException e) {
			return false;
		}
	}
}
