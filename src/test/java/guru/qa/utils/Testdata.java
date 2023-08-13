package guru.qa.utils;

import static guru.qa.utils.RandomUtils.*;

public class Testdata {

    public static String
            userFullName = getRandomFullName(),
            userEmail = getRandomEmail(),
            userCurrentAddress = getRandomAddress(),
            userPermanentAddress = getRandomAddress();
}
