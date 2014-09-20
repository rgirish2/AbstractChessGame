package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

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
		if (board.getDimensionCount() != 2) {
			return false;
		} else if (newPosX < 0 || newPosX > board.getDimensionOne() || newPosY < 0 || newPosY > board.getDimensionTwo()){
			return false;
		} else if (newPosX == this.getPosX() && newPosY == this.getPosY()) {
			return false;
		} else {
			int diffX = newPosX - this.getPosX();
			int diffY = newPosY - this.getPosY();
			
			int absDiffX = Math.abs(diffX);
			int absDiffY = Math.abs(diffY);
			
			if ((absDiffX == 0 && absDiffY > 0) || (absDiffX == absDiffY) || (absDiffX > 0 && absDiffY == 0)) {
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
				boolean northEast = diffX > 0 && diffY > 0 ? true : false;
				boolean northWest = diffX < 0 && diffY > 0 ? true : false;
				boolean southWest = diffX < 0 && diffY < 0 ? true : false;
				boolean southEast = diffX > 0 && diffY < 0 ? true : false;
				
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
				} else if (southEast){
					for (int x = this.getPosX(), y = this.getPosY(); x < newPosX && y > newPosY; x++, y--) {
						if (x != this.getPosX() && y != this.getPosY() && board.getBoard()[x][y] != null) {
							return false;
						}
					}
					return true;
				} else if (north) {
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
			} else {
				return false;
			}
		}
	}
}
