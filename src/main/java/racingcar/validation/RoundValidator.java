package racingcar.validation;

import racingcar.constant.RoundRange;
import racingcar.constant.InvalidRoundMessage;
import racingcar.constant.RoundRegex;

public class RoundValidator {

    public void validateRound(String rounds) {
        validateIsNumeric(rounds);
        validateNumberInRange(rounds);
    }

    private void validateIsNumeric(String rounds) {
        if (!rounds.matches(RoundRegex.NUMBER.getRegex())) {
            throw new IllegalArgumentException(InvalidRoundMessage.NOT_NUMERIC.getMessage());
        }
    }

    private void validateNumberInRange(String rounds) {
        int parsedNumber = Integer.parseInt(rounds);

        if (parsedNumber < RoundRange.MIN.getValue() || parsedNumber > RoundRange.MAX.getValue()) {
            throw new IllegalArgumentException(InvalidRoundMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
