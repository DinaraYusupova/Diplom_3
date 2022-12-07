public class DefaultUserData {

    private final String DEFAULT_USER_NAME = "Вася";
    private final String DEFAULT_USER_EMAIL = "uilogintest@yandex.ru";
    private final String DEFAULT_USER_PASSWORD = "123456";
    private final String ERROR_USER_PASSWORD = "12345";

    public String getERROR_USER_PASSWORD() {
        return ERROR_USER_PASSWORD;
    }


    public String getDEFAULT_USER_NAME() {
        return DEFAULT_USER_NAME;
    }

    public String getDEFAULT_USER_EMAIL() {
        return DEFAULT_USER_EMAIL;
    }

    public String getDEFAULT_USER_PASSWORD() {
        return DEFAULT_USER_PASSWORD;
    }
}
