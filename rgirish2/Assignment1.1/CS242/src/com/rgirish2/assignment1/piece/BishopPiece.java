package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

/**
 * A chess piece which is of type BISHOP of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class BishopPiece extends AbstractTwoDimensionalPiece {

	public BishopPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.BISHOP, ordinal, ordinal.equals(NormalPlayerOrdinal.ONE) ? PiecesUnicode.WHITEBISHOP : PiecesUnicode.BLACKBISHOP);
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
			int diffX = newPosX - this.getPosX();
			int diffY = newPosY - this.getPosY();
			
			if (Math.abs(diffX) != Math.abs(diffY)) {
				return false;
			}
			
			boolean northEast = diffX > 0 && diffY > 0 ? true : false;
			boolean northWest = diffX < 0 && diffY > 0 ? true : false;
			boolean southWest = diffX < 0 && diffY < 0 ? true : false;
			@SuppressWarnings("unused")
			boolean southEast = diffX > 0 && diffY < 0 ? true : false;	// Not needed since there can be only 4 movements possible.
			
			AbstractTwoDimensionalPiece piece = board.getBoard()[newPosX][newPosY].getPiece();
			if (piece != null) {
				if (piece.getOrdinal().equals(this.getOrdinal())) {
					return false;
				}
			}
			
			if (northEast) {
				for (int x = this.getPosX(), y = this.getPosY(); x < newPosX && y < newPosY; x++, y++) {
					if (x != this.getPosX() && y != this.getPosY() && board.getBoard()[x][y] != null) {
						return false;
					}
				}
				return true;
			} else if (northWest) {
				for (int x = this.getPosX(), y = this.getPosY(); x > newPosX && y < newPosY; x--, y++) {
					if (x != this.getPosX() && y != this.getPosY() && board.getBoard()[x][y] != null) {
						return false;
					}
				}
				return true;
			} else if (southWest) {
				for (int x = this.getPosX(), y = this.getPosY(); x > newPosX && y > newPosY; x--, y--) {
					if (x != this.getPosX() && y != this.getPosY() && board.getBoard()[x][y] != null) {
						return false;
					}
				}
				return true;
			} else {
				for (int x = this.getPosX(), y = this.getPosY(); x < newPosX && y > newPosY; x++, y--) {
					if (x != this.getPosX() && y != this.getPosY() && board.getBoard()[x][y] != null) {
						return false;
					}
				}
				return true;
			}
		}
	}
}
