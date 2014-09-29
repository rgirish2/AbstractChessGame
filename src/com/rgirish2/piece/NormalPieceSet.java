package com.rgirish2.assignment1.piece;

import java.util.ArrayList;
import java.util.List;

/**
 * A normal piece-set is a set of normal 8X8 2-D chess board, where the number of pieces is 16.
 * A better implementation would be to use fixed sized arrays rather than Lists.
 * @author Rishi Girish(rgirish2ATillinoisDOTedu)
 *
 */
public class NormalPieceSet extends AbstractPieceSet {
	private List<AbstractTwoDimensionalPiece> pieces;
	
	/**
	 * The Normal Piece set constructor for the players.
	 * @param ordinal The ordinal of player with whom this piece set is associated with.
	 * @param playerName The name of the player name with whom this piece set is associated with.
	 */
	public NormalPieceSet(NormalPlayerOrdinal ordinal, String playerName) {
		this.setPieces(new ArrayList<AbstractTwoDimensionalPiece>());		
		this.init(playerName, ordinal);
	}
	
	/**
	 * Initializes this piece set and all the chess pieces.
	 * @param playerName The name of the player with whom this piece is associated with.
	 * @param ordinal The ordinal of the player associated with this piece set.
	 */
	private void init(String playerName, NormalPlayerOrdinal ordinal) {
		int pawnFactor = 1;
		int otherPieceFactor = 0;
		if (ordinal.equals(NormalPlayerOrdinal.TWO)) {
			pawnFactor = 6;
			otherPieceFactor = 7;
		}
		
		for (int i = 0; i < 8; i++) {
			int [] position = {i, pawnFactor};
			
			AbstractTwoDimensionalPiece pawns = new PawnPiece(playerName, position[0], position[1], ordinal);
			this.pieces.add(pawns);
			
			int [] otherPosition = {i, otherPieceFactor};
			
			switch (i) {
				case 0 : case 7:
					AbstractTwoDimensionalPiece rooks = new RookPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.pieces.add(rooks);		
					break;
				case 1 : case 6:
					AbstractTwoDimensionalPiece knights = new KnightPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.pieces.add(knights);
					break;
				case 2 : case 5:				
					AbstractTwoDimensionalPiece bishops = new BishopPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.pieces.add(bishops);
					break;
				case 3 :				
					AbstractTwoDimensionalPiece queens = new QueenPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.pieces.add(queens);
					break;
				case 4 :				
					AbstractTwoDimensionalPiece kings = new KingPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.pieces.add(kings);
					break;
				default :
					break;
			}
		}
		return;
	}

	public List<AbstractTwoDimensionalPiece> getPieces() {
		return pieces;
	}

	public void setPieces(List<AbstractTwoDimensionalPiece> pieces) {
		this.pieces = pieces;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.pieces.toString());
		return builder.toString();
	}
}
