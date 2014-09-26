package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.movementValidity.TwoDimensionMovementsValidator;

/**
 * A chess piece which is of type ROOK of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class RookPiece extends AbstractTwoDimensionalPiece {

	public RookPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.ROOK, ordinal, ordinal.equals(NormalPlayerOrdinal.ONE) ? PiecesUnicode.WHITEROOK : PiecesUnicode.BLACKROOK);
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
		if (isCastlingMove(board, newPosX, newPosY)) {
			return true;
		} else {
			int curPosX = this.getPosX();
			int curPosY = this.getPosY();
			
			boolean isValidHorizontal = TwoDimensionMovementsValidator.isValidHorizontalMovement(board, curPosX, curPosY, newPosX, newPosY);
			boolean isValidVertical = TwoDimensionMovementsValidator.isValidVerticalMovement(board, curPosX, curPosY, newPosX, newPosY);
			
			return isValidHorizontal || isValidVertical;
		}
	}
	
	/**
	 * Method to verify whether the move being made is castling
	 * @param board The 2-D chess board on which this move needs to be made.
	 * @param newPosX The new X dimensional position of this piece in a 2-D board.
	 * @param newPosY The new Y dimensional position of this piece in a 2-D board.
	 * @return true if it is a valid castling move, false otherwise.
	 */
	private boolean isCastlingMove(AbstractTwoDimensionalBoard board, int newPosX, int newPosY) {
		return false;
	}
}
