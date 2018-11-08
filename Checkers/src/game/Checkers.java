package game;

import java.util.ArrayList;
import java.util.List;

public class Checkers extends Piece {
	private Direction dir;
	
	public Checkers(Side s, Direction dir) {
		
		this.setPieceType(PieceType.CHECKERS);
		this.setSide(s);
		this.dir = dir;
		
		switch(s) {
			case BLACK :
				this.setSymbol("\u26AB");
				break;
			case WHITE :
				this.setSymbol("\u26AA");
				break;				
		}
	}
	
	// Checks if the overall move is valid
	
	public boolean isValidMove(Board board, String from, String to) {
		
		if(isFreeSpace(board, to)) {
			if(isValidRegularMove(board, from, to) || isValidCapture(board, from, to)) {
				return true;
			}
		}
		return false;
	}
	
	// Checks if the move is valid and is a regular diagonal move
	
	public boolean isValidRegularMove(Board board, String from, String to) {
		
		switch(dir) {
			case UP:
				if(isDiagonalMove(board, from, to) && (board.getCellRow(from) - board.getCellRow(to) == 1) ) {
					return true;
				}
				break;
			
			case DOWN:
				if(isDiagonalMove(board, from, to) && (board.getCellRow(to) - board.getCellRow(from) == 1) ) {
					return true;
				}
				break;
		}
		return false;
	}
	
	// Checks if you can capture the peace between your position and the position you want to move on
	
	public boolean isValidCapture(Board board, String from, String to) {
		
		int fromRow = board.getCellRow(from);
		int fromCol = board.getCellCol(from);
		int toRow = board.getCellRow(to);
		int toCol = board.getCellCol(to);
		Side fromSide = board.getCell(from).getPiece().getSide();
		
		switch(dir) {
			case UP: 
					if(fromRow - toRow == 2 
					&& ((fromRow - fromCol == toRow - toCol
							&& board.getCell(fromRow - 1, fromCol - 1).getPiece().getSide() != null
							&& board.getCell(fromRow - 1, fromCol - 1).getPiece().getSide() != fromSide)
						|| (fromRow + fromCol == toRow + toCol
							&& board.getCell(fromRow - 1, fromCol + 1).getPiece().getSide() != null
							&& board.getCell(fromRow - 1, fromCol + 1).getPiece().getSide() != fromSide))
					){	
						return true;	
					}
					break;
					
			case DOWN:
				if(toRow - fromRow == 2 
				&& ((fromRow - fromCol == toRow - toCol
						&& board.getCell(fromRow + 1, fromCol + 1).getPiece().getSide() != null
						&& board.getCell(fromRow + 1, fromCol + 1).getPiece().getSide() != fromSide)
					|| (fromRow + fromCol == toRow + toCol
						&& board.getCell(fromRow + 1, fromCol - 1).getPiece().getSide() != null
						&& board.getCell(fromRow + 1, fromCol - 1).getPiece().getSide() != fromSide))
				){	
					return true;	
				}
				break;					
		}
		
		return false;
		
	}
	
	// Checks if the cell you want to move too is free 
	
	public boolean isFreeSpace(Board board, String to) {
		if(board.getCell(to).getPiece().getPieceType() == PieceType.SPACE) {
			return true;
		}
		return false;
	}
	
	// Checks if a move is diagonal, but only for one space moves
	
	public boolean isDiagonalMove(Board board, String from, String to) {
		int fromCol = board.getCellCol(from);
		int toCol = board.getCellCol(to);
		
		if(Math.abs(toCol - fromCol) == 1) {
			return true;
		}
		return false;
	}
	
	public List<String> enemyDiagonalArray(Board board, String from) {
		List<String> list = new ArrayList<>();
		
		for(int i = 0 ; i < board.getRowNumber() ; i++) {
			for(int j = 0 ; j < board.getColNumber() ; j++) {
				if(isDiagonalMove(board, from, board.intCoordToString(i, j))
					&& board.getCell(i, j).getPiece().getSide() != this.getSide()
					&& board.getCell(i, j).getPiece().getSide() != null) {
						
						list.add(board.intCoordToString(i, j));
				}
			}
		}
		
		return list;
	}
	
}
