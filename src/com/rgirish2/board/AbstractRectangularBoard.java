package com.rgirish2.board;

/**
 * A rectangular representation of a two dimensional chess board.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractRectangularBoard extends AbstractTwoDimensionalBoard {
	
	public AbstractRectangularBoard(int dimensionOne, int dimensionTwo, int playerCount) {
		super(dimensionOne, dimensionTwo, playerCount);
	}
}
