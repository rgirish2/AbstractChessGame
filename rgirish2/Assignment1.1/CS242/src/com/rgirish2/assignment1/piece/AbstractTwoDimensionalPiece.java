package com.rgirish2.assignment1.piece;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;

/**
 * An abstraction for pieces that only exist in 2 dimensions.
 * Was needed to make the movement of pieces on the board easier to implement and visualize.
 * Similarly, if we want to make new dimensions, we could come up with a generic piece movement
 * implementation for all the pieces, otherwise, create a new abstraction like this for other dimensions
 * and implement the piece movement logic separately for each kind of dimension. 
 * 
 * @author Rishi Girish(rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractTwoDimensionalPiece extends AbstractPiece {
	private final NormalPlayerOrdinal ordinal;
	private int posX;
	private int posY;
	
	public AbstractTwoDimensionalPiece(String playerName, int posX, int posY, PieceType pieceType, NormalPlayerOrdinal ordinal) {
		super(2, playerName, pieceType);
		this.setPosX(posX);
		this.setPosY(posY);
		this.ordinal = ordinal;
	}
	
	/**
	 * Get the current Y position of this piece in a two dimensional grid.
	 * @return The current Y position.
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Set the current Y position of this piece in a two dimensional grid.
	 * @param posY The new Y position for this piece.
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	/**
	 * Get the current X position of this piece in a two dimensional grid.
	 * @return The current X position.
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Set the current X position of this piece in a two dimensional grid.
	 * @param posY The new X position for this piece.
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Get the ordinal of the player against which this piece is associated with.
	 * @return The ordinal of the associated player.
	 */
	public NormalPlayerOrdinal getOrdinal() {
		return ordinal;
	}
	
	/**
	 * Movement helper function. This function is called by the move to verify whether the movement requested is valid.
	 * @param board The board on which this movement needs to be made.
	 * @param newPosX The new X position in this 2 dimensional grid.
	 * @param newPosY The new Y position in this 2 dimensional grid.
	 * @return True if this is a valid movement. False otherwise.
	 */
	public abstract boolean isValidMove(AbstractTwoDimensionalBoard board, int newPosX, int newPosY);
	
	/**
	 * @return The string representation of this piece object of the type PIECETYPE (posX, posY)
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.pieceType);
		builder.append(": (");
		builder.append(this.posX);
		builder.append(", ");
		builder.append(this.posY);
		builder.append(")");
		return builder.toString();
	}
}
