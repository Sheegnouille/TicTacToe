public class BoardPrinter {
    private final Board board;
    public static final char VERTICAL_LINE = '┃';
    public static final char HORIZONTAL_LINE = '━';
    public static final char CROSS = '╋';

    public BoardPrinter(Board board) {
        this.board = board;
    }

    public void draw() {
        drawFirstRow();
        drawVerticalLine();
        drawSecondRow();
        drawVerticalLine();
        drawThirdRow();
    }

    private void drawVerticalLine() {
        System.out.println(String.valueOf(HORIZONTAL_LINE) + CROSS + HORIZONTAL_LINE + CROSS + HORIZONTAL_LINE);
    }

    private void drawFirstRow() {
        System.out.println(String.valueOf(board.getCell(0)) + VERTICAL_LINE + board.getCell(1) + VERTICAL_LINE + board.getCell(2));
    }

    private void drawSecondRow() {
        System.out.println(String.valueOf(board.getCell(3)) + VERTICAL_LINE + board.getCell(4) + VERTICAL_LINE + board.getCell(5));
    }

    private void drawThirdRow() {
        System.out.println(String.valueOf(board.getCell(6)) + VERTICAL_LINE + board.getCell(7) + VERTICAL_LINE + board.getCell(8));
    }
}