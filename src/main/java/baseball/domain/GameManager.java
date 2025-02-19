package baseball.domain;

import java.util.List;

import baseball.utils.RandomNumberList;

public class GameManager {

    private List<Integer> answerList;
    private boolean isRunning = true;

    public GameManager() {
        resetGame();
    }

    private void resetGame() {
        this.answerList = RandomNumberList.generate();
    }

    public void run() {
        while (this.isRunning) {
            this.startGame();
            this.checkRestart();
        }
    }

    private void startGame() {
        boolean isGameOver = false;

        while (!isGameOver) {
            isGameOver = this.checkAnswerInput();
        }
    }

    private boolean checkAnswerInput() {
        List<Integer> input = Player.getAnswerInput();
        String hint = Judge.checkAnswerInput(input, this.answerList);

        System.out.println(hint);

        return Judge.checkGameOver(hint);
    }

    private void checkRestart() {
        boolean shouldRestart = Player.getGameRestartInput();

        if (shouldRestart) {
            resetGame();
        }
        this.isRunning = shouldRestart;
    }
}
