package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomInputData {

    public static String generateString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

}
