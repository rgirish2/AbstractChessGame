package com.rgirish2.board;

/**
 * A square representation of a rectangular chess board.
 * Every square is a rectangle, hence it extends a rectangular-board
 * and not a two dimensional board directly.
 * 
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 * 
 */
public abstract class AbstractSquareBoard extends AbstractRectangularBoard {
	
	public AbstractSquareBoard(int dimensionOne, int dimensionTwo, int playerCount) {
		super(dimensionOne, dimensionTwo, playerCount);
	}
}
