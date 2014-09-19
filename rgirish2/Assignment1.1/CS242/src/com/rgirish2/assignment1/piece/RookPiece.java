package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

/**
 * A chess piece which is of type ROOK of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class RookPiece extends AbstractTwoDimensionalPiece {

	public RookPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.ROOK, ordinal);
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
		} else if (isCastlingMove(board, newPosX, newPosY)) {
			return true;
		} else {
			int diffX = Math.abs(newPosX - this.getPosX());
			int diffY = Math.abs(newPosY - this.getPosY());
			
			if (diffX > 0 && diffY > 0) {
				return false;
			}
			
			AbstractTwoDimensionalPiece piece = board.getBoard()[newPosX][newPosY].getPiece();
			if (piece != null) {
				if (piece.getOrdinal().equals(this.getOrdinal())) {
					return false;
				}
			}
			
			boolean north = diffX == 0 && diffY > 0 ? true : false;
			boolean south = diffX == 0 && diffY < 0 ? true : false;
			boolean east = diffX > 0 && diffY == 0 ? true : false;
			boolean west = diffX < 0 && diffY == 0 ? true : false;
			
			if (north) {
				for (int i = this.getPosY(); i < newPosY; i++) {
					if (i != this.getPosY() && board.getBoard()[newPosX][i] != null) {
						return false;
					}
				}
				return true;
			} else if (south) {
				for (int i = newPosY; i < this.getPosY(); i++) {
					if (i != newPosY && board.getBoard()[newPosX][i] != null) {
						return false;
					}
				}
				return true;
			} else if (east) {
				for (int i = this.getPosX(); i < newPosX; i++) {
					if (i != this.getPosX() && board.getBoard()[i][newPosY] != null) {
						return false;
					}
				}
				return true;
			} else if (west) {
				for (int i = newPosX; i < this.getPosX(); i++) {
					if (i != newPosX && board.getBoard()[i][newPosY] != null) {
						return false;
					}
				}
				return true;
			} else {
				return false;			
			}
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
