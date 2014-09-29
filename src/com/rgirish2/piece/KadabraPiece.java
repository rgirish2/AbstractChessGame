package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

/**
 * A hypothetical piece created just to explain the process of creating new
 * pieces in this project structure.
 * @author Rishi Girish(rgirish2ATillinoisDOTedu)
 *
 */
public class KadabraPiece extends AbstractTwoDimensionalPiece {

	public KadabraPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.KADABRA, ordinal, "KADABRA");
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
		} else {
			if (board.getBoard()[newPosX][newPosY] != null) {
				AbstractTwoDimensionalPiece piece = board.getBoard()[newPosX][newPosY].getPiece();
				if (piece.getPieceType().equals(PieceType.KING) && piece.getOrdinal().equals(this.getOrdinal())) {
					return true;
				}
			}
		}
		return false;
	}
}
