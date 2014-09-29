package com.rgirish2.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.movementValidity.TwoDimensionMovementsValidator;

/**
 * A chess piece which is of type KING of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class KingPiece extends AbstractTwoDimensionalPiece {

	public KingPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.KING, ordinal, ordinal.equals(NormalPlayerOrdinal.ONE) ? PiecesUnicode.WHITEKING : PiecesUnicode.BLACKKING);
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
		try {
			if (isCastlingMove(board, newPosX, newPosY)) {
				return true;
			} else if (TwoDimensionMovementsValidator.isWithinRange(board, this.getPosX(), this.getPosY(), newPosX, newPosY)) {
				int diffX = Math.abs(newPosX - this.getPosX());
				int diffY = Math.abs(newPosY - this.getPosY());
				
				if ((diffX == 1 && diffY == 1) || (diffX == 0 && diffY == 1) || (diffX == 1 && diffY == 0)) {
					if (!board.getBoard()[newPosX][newPosY].isMarked()) {
						if (board.getBoard()[newPosX][newPosY].getPiece() != null) {
							if (board.getBoard()[newPosX][newPosY].getPiece().getOrdinal() != this.getOrdinal()) {
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
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
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
