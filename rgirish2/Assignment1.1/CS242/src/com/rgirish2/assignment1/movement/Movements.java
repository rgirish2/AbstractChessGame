package com.rgirish2.assignment1.movement;

import com.rgirish2.assignment1.board.AbstractBoard;

/**
 * An interface representing all the possible movements in a
 * two dimensional square tiles boards.
 * Should be implemented by the moveTile() method inside the AbstractBoard.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public interface Movements {
	
	/**
	 * Linear movement on the chess board. Either up or down or left or right on a 2-D chess board.
	 */
	public abstract void linearMove(AbstractBoard board, int movementLength, MovementDirection direction);
	
	/**
	 * Represents the diagonal movement on the chess board.
	 */
	public abstract void diagonalMove(AbstractBoard board, int movementLength, MovementDirection direction);
}
