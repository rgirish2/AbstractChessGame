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
	private List<PawnPiece> pawnList;
	private List<RookPiece> rookList;
	private List<KnightPiece> knightList;
	private List<BishopPiece> bishopList;
	private List<KingPiece> kingList;
	private List<QueenPiece> queenList;
	
	public NormalPieceSet(NormalPlayerOrdinal ordinal, String playerName) {		
		this.pawnList = new ArrayList<PawnPiece>();
		this.rookList = new ArrayList<RookPiece>();
		this.knightList = new ArrayList<KnightPiece>();
		this.bishopList = new ArrayList<BishopPiece>();
		this.kingList = new ArrayList<KingPiece>();
		this.queenList = new ArrayList<QueenPiece>();
		
		this.init(playerName, ordinal);
	}
	
	private void init(String playerName, NormalPlayerOrdinal ordinal) {
		int pawnFactor = 1;
		int factor = 0;
		if (ordinal.equals(NormalPlayerOrdinal.TWO)) {
			pawnFactor = 6;
			factor = 7;
		}
		
		for (int i = 0; i < 8; i++) {
			int [] position = {i, pawnFactor};
			PawnPiece pawn = new PawnPiece(playerName, position[0], position[1], ordinal);
			this.pawnList.add(pawn);
			
			int [] otherPosition = {i, factor};
			
			switch (i) {
				case 0 : case 7:
					RookPiece rook = new RookPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.rookList.add(rook);
					break;
				case 1 : case 6:
					KnightPiece knight = new KnightPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.knightList.add(knight);
					break;
				case 2 : case 5:
					BishopPiece bishop = new BishopPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.bishopList.add(bishop);
					break;
				case 3 :
					QueenPiece queen = new QueenPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.queenList.add(queen);
					break;
				case 4 :
					KingPiece king = new KingPiece(playerName, otherPosition[0], otherPosition[1], ordinal);
					this.kingList.add(king);
					break;
				default :
					break;
			}
		}
	}

	public List<PawnPiece> getPawnList() {
		return pawnList;
	}

	public void setPawnList(List<PawnPiece> pawnList) {
		this.pawnList = pawnList;
	}

	public List<RookPiece> getRookList() {
		return rookList;
	}

	public void setRookList(List<RookPiece> rookList) {
		this.rookList = rookList;
	}

	public List<KnightPiece> getKnightList() {
		return knightList;
	}

	public void setKnightList(List<KnightPiece> knightList) {
		this.knightList = knightList;
	}

	public List<BishopPiece> getBishopList() {
		return bishopList;
	}

	public void setBishopList(List<BishopPiece> bishopList) {
		this.bishopList = bishopList;
	}

	public List<KingPiece> getKingList() {
		return kingList;
	}

	public void setKingList(List<KingPiece> kingList) {
		this.kingList = kingList;
	}

	public List<QueenPiece> getQueenList() {
		return queenList;
	}

	public void setQueenList(List<QueenPiece> queenList) {
		this.queenList = queenList;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.pawnList.toString());
		builder.append(System.getProperty("line.separator"));
		builder.append(this.rookList.toString());
		builder.append(this.knightList.toString());
		builder.append(this.bishopList.toString());
		builder.append(this.queenList.toString());
		builder.append(this.kingList.toString());
		return builder.toString();
	}
}
