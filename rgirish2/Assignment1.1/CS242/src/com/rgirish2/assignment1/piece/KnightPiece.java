package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.movementValidity.TwoDimensionMovementsValidator;

/**
 * A chess piece which is of type KNIGHT of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class KnightPiece extends AbstractTwoDimensionalPiece {

	public KnightPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.KNIGHT, ordinal, ordinal.equals(NormalPlayerOrdinal.ONE) ? PiecesUnicode.WHITEKNIGHT : PiecesUnicode.BLACKKNIGHT);
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
		if (TwoDimensionMovementsValidator.isWithinRange(board, this.getPosX(), this.getPosY(), newPosX, newPosY)) {
			int diffX = Math.abs(newPosX - this.getPosX());
			int diffY = Math.abs(newPosY - this.getPosY());
			
			if ((diffX == 1 && diffY == 2) || (diffX == 2 && diffY == 1)) {
				AbstractTwoDimensionalPiece piece = board.getBoard()[newPosX][newPosY].getPiece();
				if (piece != null) {
					if (!piece.getOrdinal().equals(this.getOrdinal())) {
						return true;
					} else {
						return false;
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
