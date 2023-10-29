package praktikum.user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static String generatorRandomString() {
        return RandomStringUtils.randomAlphanumeric(7, 10);
    }
    public static final String DOMAIN = "@yandex.ru";
    public static User genericUserRandom(){
        return new User(generatorRandomString()+DOMAIN, generatorRandomString(), generatorRandomString());

    }
}
