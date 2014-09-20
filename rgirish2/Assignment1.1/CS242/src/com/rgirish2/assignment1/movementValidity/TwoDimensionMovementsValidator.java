package com.rgirish2.assignment1.movementValidity;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;

/**
 * An class representing all the possible movements in a
 * two dimensional square tiles boards.
 * This is used to validate all the movements in a 2-D space.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class TwoDimensionMovementsValidator {
	
	/**
	 * Method to verify if the vertical movement being requested by the piece is valid
	 * in the current state of the board that is being passed in.
	 * And the conditional verifies if there exists any other piece in the path of the movement. 
	 * @param board The abstract two dimensional board where this movement is being requested.
	 * @param curPosX The current X location of the piece requesting the movement.
	 * @param curPosY The current Y location of the piece requesting the movement.
	 * @param newPosX The new X location for the piece.
	 * @param newPosY The new Y location for the piece.
	 * @return True if the movement being request is valid on this board, False otherwise.
	 * @throws NullPointerException if the board or the tiles used to represent the board is not initialized.
	 */
	public static boolean isValidVerticalMovement (AbstractTwoDimensionalBoard board, int curPosX, int curPosY, int newPosX, int newPosY) throws NullPointerException {
		try {
			if (TwoDimensionMovementsValidator.isWithinRange(board, curPosX, curPosY, newPosX, newPosY)) {
				
				int diffX = newPosX - curPosX;
				int diffY = newPosY - curPosY;
				
				if (diffX != 0) {
					return false;
				}
				
				boolean north = (diffX == 0 && diffY > 0) ? true : false;
				boolean south = (diffX == 0 && diffY < 0) ? true : false;			// Not required since on 2-D board it's either N or S. Implemented just to make things explicit.
				
				if (north) {
					for (int y = curPosY; y < newPosY; y++) {
						if (y != curPosY && board.getBoard()[curPosX][y].getPiece() != null) {
							return false;
						}
					}
					return true;
				} else if (south) {
					for (int y = curPosY; y > newPosX; y--) {
						if (y != curPosY && board.getBoard()[curPosX][y].getPiece() != null) {
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
		} catch (NullPointerException e) {
			throw new NullPointerException("Boards or tiles or pieces are not initialized.");
		}
	}
	
	/**
	 * Method to verify if the horizontal movement being requested by the piece is valid
	 * in the current state of the board that is being passed in.
	 * And the conditional verifies if there exists any other piece in the path of the movement. 
	 * @param board The abstract two dimensional board where this movement is being requested.
	 * @param curPosX The current X location of the piece requesting the movement.
	 * @param curPosY The current Y location of the piece requesting the movement.
	 * @param newPosX The new X location for the piece.
	 * @param newPosY The new Y location for the piece.
	 * @return True if the movement being request is valid on this board, False otherwise.
	 * @throws NullPointerException if the board or the tiles used to represent the board is not initialized.
	 */
	public static boolean isValidHorizontalMovement (AbstractTwoDimensionalBoard board, int curPosX, int curPosY, int newPosX, int newPosY) throws NullPointerException {
		try {
			if (TwoDimensionMovementsValidator.isWithinRange(board, curPosX, curPosY, newPosX, newPosY)) {
				
				int diffX = newPosX - curPosX;
				int diffY = newPosY - curPosY;
				
				if (diffY != 0) {
					return false;
				}
				
				boolean east = diffX > 0 && diffY == 0 ? true : false;
				boolean west = diffX < 0 && diffY == 0 ? true : false;		// Not required on a 2-D board since every horizontal movement is either E or W. Done to make things explicit.
				
				if (east) {
					for (int x = curPosX; x < newPosX; x++) {
						if (x != curPosX && board.getBoard()[x][curPosY].getPiece() != null) {
							return false;
						}
					}
					return true;
				} else if (west) {
					for (int x = curPosX; x > newPosX; x--) {
						if (x != curPosX && board.getBoard()[x][curPosY].getPiece() != null) {
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
		} catch (NullPointerException e) {
			throw new NullPointerException("Boards or tiles or pieces are not initialized.");
		}
	}
	
	/**
	 * Method to verify if the diagonal movement being requested by the piece is valid
	 * in the current state of the board that is being passed in.
	 * And the conditional verifies if there exists any other piece in the path of the movement. 
	 * @param board The abstract two dimensional board where this movement is being requested.
	 * @param curPosX The current X location of the piece requesting the movement.
	 * @param curPosY The current Y location of the piece requesting the movement.
	 * @param newPosX The new X location for the piece.
	 * @param newPosY The new Y location for the piece.
	 * @return True if the movement being request is valid on this board, False otherwise.
	 * @throws NullPointerException if the board or the tiles used to represent the board is not initialized.
	 */
	public static boolean isValidDiagonalMovement (AbstractTwoDimensionalBoard board, int curPosX, int curPosY, int newPosX, int newPosY) throws NullPointerException {
		try {
			if (TwoDimensionMovementsValidator.isWithinRange(board, curPosX, curPosY, newPosX, newPosY)) {
				
				int diffX = newPosX - curPosX;
				int diffY = newPosY - curPosY;
				
				if (Math.abs(diffX) != Math.abs(diffY)) {
					return false;
				}
				
				boolean northEast = diffX > 0 && diffY > 0 ? true : false;
				boolean northWest = diffX < 0 && diffY > 0 ? true : false;
				boolean southWest = diffX < 0 && diffY < 0 ? true : false;
				boolean southEast = diffX > 0 && diffY < 0 ? true : false;	// Not needed since there can be only 4 diagonal movements possible in 2-D grid in a normal chess game.
				
				if (northEast) {
					for (int x = curPosX, y = curPosY; x < newPosX && y < newPosY; x++, y++) {
						if (x != curPosX && y != curPosY && board.getBoard()[x][y].getPiece() != null) {
							return false;
						}
					}
					return true;
				} else if (northWest) {
					for (int x = curPosX, y = curPosY; x > newPosX && y < newPosY; x--, y++) {
						if (x != curPosX && y != curPosY && board.getBoard()[x][y].getPiece() != null) {
							return false;
						}
					}
					return true;
				} else if (southWest) {
					for (int x = curPosX, y = curPosY; x > newPosX && y > newPosY; x--, y--) {
						if (x != curPosX && y != curPosY && board.getBoard()[x][y].getPiece() != null) {
							return false;
						}
					}
					return true;
				} else if (southEast) {
					for (int x = curPosX, y = curPosY; x < newPosX && y > newPosY; x++, y--) {
						if (x != curPosX && y != curPosY && board.getBoard()[x][y].getPiece() != null) {
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
		} catch (NullPointerException e) {
			throw new NullPointerException("Boards or tiles or pieces are not initialized.");
		}
	}
	
	/**
	 * Preliminary check to verify the bounds of the movement that is being requested.
	 * This method only works in a 2-D euclidean space.
	 * The first conditional verifies the board is of the correct dimension.
	 * The second conditional verifies the newPositions are within the valid range of the board.
	 * The third conditional verifies the curPositions are within the valid range of the board.
	 * The fourth conditional verifies that the new position are not the same as the current position.
	 * The fifth conditional verifies that the piece at the new position are not of the same player as the current position.
	 * @param board The abstract two dimensional board where this movement is being requested.
	 * @param curPosX The current X location of the piece requesting the movement.
	 * @param curPosY The current Y location of the piece requesting the movement.
	 * @param newPosX The new X location for the piece.
	 * @param newPosY The new Y location for the piece.
	 * @return True if the movement being request is valid on this board, False otherwise.
	 * @throws NullPointerException if the board or the tiles used to represent the board is not initialized.
	 */
	public static boolean isWithinRange (AbstractTwoDimensionalBoard board, int curPosX, int curPosY, int newPosX, int newPosY) throws NullPointerException {
		try {
			if (board.getDimensionCount() != 2) {
				return false;
			} else if (newPosX < 0 || newPosX >= board.getDimensionOne() || newPosY < 0 || newPosY >= board.getDimensionTwo()){
				return false;
			} else if (curPosX < 0 || curPosX >= board.getDimensionOne() || curPosY < 0 || curPosY >= board.getDimensionTwo()) {
				return false;
			} else if (newPosX == curPosX && newPosY == curPosY) {
				return false;
			} else {
				if (board.getBoard()[newPosX][newPosY].getPiece() != null) {
					AbstractTwoDimensionalPiece otherPiece = board.getBoard()[newPosX][newPosY].getPiece();
					AbstractTwoDimensionalPiece currentPiece = board.getBoard()[curPosX][curPosY].getPiece();
					if (currentPiece.getOrdinal().equals(otherPiece.getOrdinal())) {
						return false;
					}
				}
				return true;
			}
		} catch (NullPointerException e) {
			throw new NullPointerException ("Boards or tiles or pieces are not initialized.");
		}
	}
}
