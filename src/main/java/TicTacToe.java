import java.util.Scanner;

public class TicTacToe {
    private static final Scanner playerInput = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();

        game.startGame();
        System.out.println("O goes first");
        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("Player " + game.getCurrentPlayer() + " turn");
            System.out.println("Choose a cell (0 to 8): ");
            gameFinished = game.run(playerInput.nextInt());
        }
    }

}
