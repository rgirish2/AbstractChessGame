package com.rgirish2.assignment1.piece;

import java.util.UUID;

/**
 * Super class representing all the pieces in a chess game.
 * Only include variable at this level and their getters and setters.
 * These should only be fields that are common across all pieces.
 * Do not include any business logic.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractPiece {
	protected final String uniqueID;
	protected final int dimensions;
	protected final String playerName;
	protected final PieceType pieceType;
	protected final String unicodeValue;
	
	public AbstractPiece(int dimensions, String playerName, PieceType pieceType, String unicodeValue) {
		this.dimensions = dimensions;
		this.uniqueID = UUID.randomUUID().toString();
		this.playerName = playerName;
		this.pieceType = pieceType;
		this.unicodeValue = unicodeValue;
	}
	
	/**
	 * The type of piece it is. Once set, this cannot be changed.
	 * @return An enum representing the type of piece this is.
	 */
	public PieceType getPieceType() {
		return pieceType;
	}
	
	/**
	 * The name of the player who owns this piece. Once set, this cannot be changed.
	 * @return The name of the piece owning player.
	 */
	public String getPlayerName() {
		return this.playerName;
	}
	
	/**
	 * The dimensions in which this piece exists in. Once set, this cannot be changed.
	 * @return The dimensions of this pieces.
	 */
	public int getDimensions() {
		return this.dimensions;
	}
	
	/**
	 * Each piece is assigned a unique ID. This is generated at piece construction and cannot be changed.
	 * Presently, this is a random UUID, but a better method needs to be thought of.
	 * @return The unique ID of this piece.
	 */
	public String getUniqueID() {
		return this.uniqueID;
	}
	
	/**
	 * Each piece is associated with a unicode value that is used to render it on the view.
	 * @return The string representing the unicode value for this piece. 
	 */
	public String getUnicodeValue() {
		return this.unicodeValue;
	}
	
	/**
	 * Method to verify the current object is equal to this piece.
	 * @param piece
	 */
	@Override
	public boolean equals(Object piece) {
		if (piece instanceof AbstractPiece) {
			if (this.dimensions == ((AbstractPiece)piece).dimensions) {
				if (this.uniqueID.equals(((AbstractPiece)piece).uniqueID)) {
					if (this.playerName.equals(((AbstractPiece)piece).playerName)) {
						if (this.pieceType.equals(((AbstractPiece)piece).pieceType)) {
							return true;
						}
					}
				}
			}
		} else {
			return false;
		}	
		return false;
	}
}
