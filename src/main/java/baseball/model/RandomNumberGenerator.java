package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int[] pickRandomNumbers(int size, int min, int max) {
        // Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        int[] pickedNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (isNumberInArray(randomNumber, pickedNumbers)) {
                continue;
            }
            pickedNumbers[i] = randomNumber;
        }
        return pickedNumbers;
    }

    // 중복 체크
    public static boolean isNumberInArray(int number, int[] array) {
        for (int value : array) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
}