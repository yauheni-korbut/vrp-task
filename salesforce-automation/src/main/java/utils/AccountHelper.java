package utils;

import business_objects.Account;
import org.apache.commons.lang3.RandomStringUtils;

public class AccountHelper {

    public static Account generateAccount(){
        return new Account(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomNumeric(8));
    }
}
