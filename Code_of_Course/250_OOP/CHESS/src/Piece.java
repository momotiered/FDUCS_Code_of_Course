public enum Piece {
    BLACK("●"),
    WHITE("○"),
    EMPTY("·");

    private final String symbol;

    Piece(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
} 