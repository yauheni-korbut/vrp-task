package utils;

import static utils.ICommonConstants.BROWSER_NAME_PROPERTIES;
import static utils.ICommonConstants.DEFAULT_BROWSER;

public class PropertyHelper {

    public static String getBrowserName() {
        if (System.getProperty(BROWSER_NAME_PROPERTIES) != null) {
            return System.getProperty(BROWSER_NAME_PROPERTIES);
        }
        return DEFAULT_BROWSER;
    }
}
