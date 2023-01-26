package exercise;

import java.util.List;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .filter(email -> hasFreeDomain(email))
                .count();
    }
    private static boolean hasFreeDomain(String email) {
        String[] freeDomains = {"@gmail.com", "@yandex.ru", "@hotmail.com"};
        for (String freeDomain: freeDomains) {
            if (email.contains(freeDomain)) {
                return true;
            }
        }
        return false;
    }
}

// END
