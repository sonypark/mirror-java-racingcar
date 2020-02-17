package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.utils.RandomNumber;

public class RacingGame {

    private static final int ZERO = 0;
    private List<Car> racingCars;

    public RacingGame(List<Car> racingCars) {
        // 검증 로직 구현
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void moveCar() {
        racingCars.forEach(car -> car.move(RandomNumber.generateRandomIntIntRange()));
    }

    public static List<Car> generateCars(String[] carNames) {
        checkNameNull(carNames);
        final List<Car> racingCars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            racingCars.add(new Car(new CarName(carName)));
        }
        return racingCars;
    }

    private static void checkNameNull(String[] carNames) {
        if (carNames.length == ZERO) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
    }

}
