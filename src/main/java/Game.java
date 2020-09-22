public class Game {
    private Board board;
    private GameState gameState;

    public boolean run(int playerChoice) {
        try {
            board.play(gameState.getCurrentPlayer(), playerChoice);
            gameState.oTurn = !gameState.oTurn;
            board.draw();
            return gameState.isGameFinished(playerChoice);
        } catch (Board.CellNotEmptyException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void startGame() {
        board = new Board();
        gameState = new GameState(board);
    }

    public char getCurrentPlayer() {
        return gameState.getCurrentPlayer();
    }
}