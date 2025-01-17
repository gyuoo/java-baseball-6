package baseball.controller;

import static baseball.model.RandomNumberGenerator.pickRandomNumbers;
import static baseball.view.SystemMessagePrinter.printHintMessage;

import baseball.model.Game;
import baseball.model.InputManager;
import baseball.view.SystemMessagePrinter;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    static final int SIZE = 3;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final int RESTART = 1;
    static final int EXIT = 2;
    static String userInput;
    static int ball;
    static int strike;
    static int[] pickedNumbers;

    // 게임 진행
    public static void playGame() {
        startGame();
        while (!Game.isGameWon()) {
            SystemMessagePrinter.printInputNumberMessage();
            getUserInput();
            validateUserInput(userInput);
            int[] hint = Game.generateHint(userInput, pickedNumbers);
            ball = hint[0];
            strike = hint[1];
            printHintMessage(ball, strike);
        }
        endGame();
    }

    // 시작 화면 출력 요청
    public static void startGame() {
        SystemMessagePrinter.printGameStartMessage();
        pickedNumbers = pickRandomNumbers(SIZE, MIN_NUMBER, MAX_NUMBER);
        Game.initializeCounts();
    }

    public static void getUserInput() {
        userInput = Console.readLine();
    }

    // 사용자 입력 처리
    // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
    public static void validateUserInput(String value) {
        if (!InputManager.isNumberInRange(userInput, MIN_NUMBER, MAX_NUMBER)) {
            throw new IllegalArgumentException(MIN_NUMBER + '~' + MAX_NUMBER + "에 해당하는 수만 입력해주세요.");
        }
        if (!InputManager.isSizeValid(userInput, SIZE)) {
            throw new IllegalArgumentException(SIZE + "자리의 수를 입력해주세요.");
        }
        if (InputManager.hasDuplicates(userInput, SIZE)) {
            throw new IllegalArgumentException("수를 중복되지 않게 입력해주세요.");
        }
    }

    // 게임 종료 여부 판단
    public static void endGame() {
        SystemMessagePrinter.printGameEndMessage();
        askForRestartOrExit();
    }

    // 게임 종료 시, 재시작 또는 완전히 종료 여부 입력 요청
    // 사용자 입력에 따라 게임 재시작 or 완전히 종료
    public static void askForRestartOrExit() {
        SystemMessagePrinter.printRestartOrExit();
        int userInput = Integer.parseInt(Console.readLine());
        if (!InputManager.isRestartInputValid(userInput)) {
            throw new IllegalArgumentException(RESTART + " 혹은 " + EXIT + "를 입력해주세요.");
        }
        if (userInput == RESTART) {
            SystemMessagePrinter.printRestartGame();
            playGame();
        }
        if (userInput == EXIT) {
            SystemMessagePrinter.printExitGame();
        }
    }
}
