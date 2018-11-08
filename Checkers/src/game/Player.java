package game;

public class Player {
	private String name;
	private Side side;
	private final int pieceNumber = 12; 
	private Piece pieceArray[] = new Piece[pieceNumber];
	private Direction dir;
	
	public Player(Direction dir) {
		this.dir = dir;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSide(Side side) {
		this.side = side;
	}
	
	public Side getSide() {
		return side;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setPieceArray() {
		for(int i = 0 ; i < pieceNumber ; i++) {
			pieceArray[i] = new Checkers(side, dir);
		}
	}
	
	public Piece getPieceAtIndex(int index) {
		return pieceArray[index];
	}
	
	public void move(Board board, String from, String to) {
		int fromRow = board.getCellRow(from);
		int fromCol = board.getCellCol(from);
		int toRow = board.getCellRow(to);
		int toCol = board.getCellCol(to);
		
		if(board.getCell(from).getPiece().isValidMove(board, from, to)) {
			if(board.getCell(from).getPiece().getSide() == side) {
				board.getCell(to).setPiece(board.getCell(from).getPiece());
				board.getCell(from).setPiece(new Space());
				if(board.getCell(from).getPiece().isValidCapture(board, from, to)) {
					// daca miscarea diag de la una din piesele din lista de enamy la to e valida o stergem
				}
			}
		}
	}
}
