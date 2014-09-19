package com.rgirish2.assignment1.tile;

import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;

/**
 * Abstract representation of the tiles used to build a chess board.
 * This could be used to make tiles of any shape.
 * Contains only the variables like piece, isMarked, etc., and their getters and setters.
 * Do not implement any business logic at this stage.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractTile {
	private AbstractTwoDimensionalPiece piece;
	private boolean isMarked;
	private boolean isOccupied;
	
	public AbstractTile(AbstractTwoDimensionalPiece piece) {
		this.piece = piece;
		this.isOccupied = true;
		this.isMarked = false;
	}
	
	/**
	 * The piece that is present on this tile.
	 * @return AbstractPiece that is present on this tile.
	 */
	public AbstractTwoDimensionalPiece getPiece() {
		return piece;
	}

	public void setPiece(AbstractTwoDimensionalPiece piece) {
		this.piece = piece;
	}
	
	/**
	 * Return whether this tile isMarked. Which means this tile can
	 * be reached by a piece of the opposing team. This would be used
	 * to quickly figure out if their is a check mate or not.
	 * @return True if this is reachable by opposing player piece, false otherwise.
	 */
	public boolean isMarked() {
		return isMarked;
	}

	public void setMarked(boolean isMarked) {
		this.isMarked = isMarked;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	@Override
	public String toString() {
		return this.piece.toString();
	}
}
