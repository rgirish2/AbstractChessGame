package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

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
		if (board.getDimensionCount() != 2) {
			return false;
		} else if (newPosX < 0 || newPosX > board.getDimensionOne() || newPosY < 0 || newPosY > board.getDimensionTwo()){
			return false;
		} else if (newPosX == this.getPosX() && newPosY == this.getPosY()) {
			return false;
		} else if (board.getBoard()[newPosX][newPosY] != null && board.getBoard()[newPosX][newPosY].isMarked()) {
			return false;
		} else if (isCastlingMove(board, newPosX, newPosY)) {
			return true;
		} else {
			int diffX = newPosX - this.getPosX();
			int diffY = newPosY - this.getPosY();
			
			if (Math.abs(diffX) <= 1 && Math.abs(diffY) <= 1) {
				if (board.getBoard()[newPosX][newPosY] == null || board.getBoard()[newPosX][newPosY].getPiece().getOrdinal() != this.getOrdinal()) {		// Check whether the piece at this this tile is not null before dereferencing it.
					return true;
				}
			}
		}
		return false;
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
