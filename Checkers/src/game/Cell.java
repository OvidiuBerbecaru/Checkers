package game;

public class Cell {
	
	private String index;
	private Piece piece;
	private int cellRow;
	private int cellCol;
	
	public Cell(int row, int col) {
		cellRow = row;
		cellCol = col;
		
		index = intCoordonatesToString(row, col);
		
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece p) {
		piece = p;
	}
	
	public String getIndex() {
		return index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public int getCellRow() {
		return cellRow;
	}
	
	public int getCellCol() {
		return cellCol;
	}
	
	public String intCoordonatesToString(int row, int column) {
		
		String rowS;
		String colS;
		char colLetters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		
		rowS = Integer.toString(8 - row);
		colS = Character.toString(colLetters[column]);
		
		return rowS + colS;
	} 
}
