package utils;

public class StringHelper {

    public static String parsePhoneNumber(String phone){
        return String.format("(%s) %s-%s", phone.substring(0,3), phone.substring(3,6), phone.substring(6));
    }

}
