package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

/**
 * A chess piece which is of type PAWN of the normal chess piece.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class PawnPiece extends AbstractTwoDimensionalPiece {
	private boolean isFirstMove = true;
	
	public PawnPiece(String playerName, int posX, int posY, NormalPlayerOrdinal ordinal) {
		super(playerName, posX, posY, PieceType.PAWN, ordinal);
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
			
			if (this.getOrdinal().equals(NormalPlayerOrdinal.ONE)) {
				if (diffX == 0 && diffY == 1) {
					if (board.getBoard()[newPosX][newPosY] == null) {
						this.isFirstMove = false;
						return true;
					}
				} else if (diffX == 0 && diffY == 2) {
					if (this.isFirstMove) {
						if (board.getBoard()[newPosX][newPosY] == null && board.getBoard()[newPosX][newPosY - 1] == null) {
							this.isFirstMove = false;
							return true;
						}
					}
				} else if (Math.abs(diffX) == 1 && diffY == 1) {
					if (board.getBoard()[newPosX][newPosY] == null) {
						return false;
					} else if (!board.getBoard()[newPosX][newPosY].getPiece().getOrdinal().equals(this.getOrdinal())) {			// Check whether the piece at this this tile is not null before dereferencing it.
						this.isFirstMove = false;
						return true;
					}
				}
			} else if (this.getOrdinal().equals(NormalPlayerOrdinal.TWO)){
				if (diffX == 0 && diffY == -1) {
					if (board.getBoard()[newPosX][newPosY] == null) {
						this.isFirstMove = false;
						return true;
					}
				} else if (diffX == 0 && diffY == -2) {
					if (this.isFirstMove) {
						if (board.getBoard()[newPosX][newPosY] == null && board.getBoard()[newPosX][newPosY + 1] == null) {
							this.isFirstMove = false;
							return true;
						}
					}
				} else if (Math.abs(diffX) == 1 && diffY == -1) {
					if (board.getBoard()[newPosX][newPosY] == null) {
						return false;
					} else if (!board.getBoard()[newPosX][newPosY].getPiece().getOrdinal().equals(this.getOrdinal())) {			// Check whether the piece at this this tile is not null before dereferencing it.
						this.isFirstMove = false;
						return true;
					}
				}
			}
		}
		return false;
	}
}
