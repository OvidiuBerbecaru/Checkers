package game;

public class Piece {
	
	private PieceType pieceType;
	private Side side;
	private String symbol;
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public void setPieceType(PieceType pt) {
		pieceType = pt;
	}
	
	public Side getSide() {
		return side;
	}
	
	public void setSide(Side s) {
		side = s;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String s) {
		symbol = s;
	}
	
	public boolean isValidMove(Board board, String from, String to) {
		return false;
	}
	
	public boolean isValidCapture(Board board, String from, String to) {
		return false;
	}
}
