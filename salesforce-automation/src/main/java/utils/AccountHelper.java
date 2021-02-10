package utils;

import business_objects.Account;
import org.apache.commons.lang3.RandomStringUtils;

import static utils.ICommonConstants.*;

public class AccountHelper {

    public static Account generateAccount() {
        return new Account(RandomStringUtils.randomAlphabetic(ACCOUNT_NAME_LENGTH),
                RandomStringUtils.randomNumeric(PHONE_LENGTH));
    }
}
