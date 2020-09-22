public class Board {
    private final char[] cells;
    private final BoardPrinter printer;

    public Board() {
        this.cells = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.printer = new BoardPrinter(this);
    }

    public void play(char symbol, int cell) throws CellNotEmptyException {
        if (!isEmptyCell(cell)) {
            throw new CellNotEmptyException();
        }
        cells[cell] = symbol;
    }

    public void draw() {
        printer.draw();
    }

    public boolean isEmptyCell(int position) {
        return cells[position] == ' ';
    }

    public char getCell(int position) {
        return cells[position];
    }

    static class CellNotEmptyException extends Throwable {

        @Override
        public String getMessage() {
            return "Chosen cell is not empty";
        }
    }
}
