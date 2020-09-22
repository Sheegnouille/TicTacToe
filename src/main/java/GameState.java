public class GameState {
    private final Board board;
    boolean oTurn = true;

    public GameState(Board board) {
        this.board = board;
    }

    public char getCurrentPlayer() {
        if (oTurn) {
            return 'O';
        }
        return 'X';
    }

    public boolean isGameFinished(int chosenCell) {
        if (isWinningColumn(chosenCell / 3)) {
            return true;
        }
        if (isWinningRow(chosenCell % 3)) {
            return true;
        }
        if (chosenCell % 2 == 0) {
            return isWinningDiagonal();
        }
        return isBoardFull();
    }

    private boolean isWinningRow(int row) {
        int firstCellInRow = 3 * row;
        if (board.isEmptyCell(firstCellInRow)) {
            return false;
        }
        return board.getCell(firstCellInRow) == board.getCell(firstCellInRow + 1) &&
                board.getCell(firstCellInRow) == board.getCell(firstCellInRow + 2);
    }

    private boolean isWinningColumn(int column) {
        if (board.isEmptyCell(column)) {
            return false;
        }
        return board.getCell(column) == board.getCell(column + 3) &&
                board.getCell(column) == board.getCell(column + 6);
    }

    private boolean isWinningDiagonal() {
        if (board.isEmptyCell(0) || board.isEmptyCell(2)) {
            return false;
        }
        return isLeftDiagonalWinning() || isRightDiagonalWinning();
    }

    private boolean isRightDiagonalWinning() {
        return board.getCell(2) == board.getCell(4)
                && board.getCell(2) == board.getCell(6);
    }

    private boolean isLeftDiagonalWinning() {
        return board.getCell(0) == board.getCell(4) &&
                board.getCell(0) == board.getCell(8);
    }

    private boolean isBoardFull() {
        boolean hasEmptyCell = false;
        for (int i = 0; i < 9; i++) {
            char symbol = board.getCell(i);
            if (symbol == ' ') {
                hasEmptyCell = true;
                break;
            }
        }
        return !hasEmptyCell;
    }
}