package zeus.playground.collection;

import zeus.playground.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : KG
 * description:
 * create date: 4:58 PM 2020/3/16
 * modified by:
 */

public class ListSetConvertionDemo {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        User user = new User(1, "kg");
        user.setEnrollDate(strToLocalDateTime("2019-10-05 00:00:00"));
        users.add(user);

        user = new User(2, "kelvin");
        user.setEnrollDate(strToLocalDateTime("2020-01-01 00:00:00"));
        users.add(user);

        user = new User(1, "kg");
        user.setEnrollDate(strToLocalDateTime("2019-11-10 00:00:00"));
        users.add(user);

        user = new User(2, "kelvin");
        user.setEnrollDate(strToLocalDateTime("2020-02-07 00:00:00"));
        users.add(user);

        user = new User(3, "david");
        user.setEnrollDate(strToLocalDateTime("2019-05-01 00:00:00"));
        users.add(user);

        // display user list
        System.out.println("**** User List: ****");
        users.forEach(System.out::println);
        System.out.println("------------------------------------");

        Set<User> userSet = new HashSet<>(users);

        System.out.println("**** User Set: ****");
        userSet.forEach(System.out::println);
        System.out.println("------------------------------------");
    }

    private static LocalDateTime strToLocalDateTime(String strDate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return LocalDateTime.parse(strDate, df);
    }
}
