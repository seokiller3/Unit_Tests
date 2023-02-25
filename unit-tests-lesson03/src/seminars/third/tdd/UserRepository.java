package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    User user = new User("null", "null");
    public static List main() {
        List list = new ArrayList<>();
        list.add(Integer.parseInt("Pavel"), "qwerty");
        list.add(Integer.parseInt("Artyom"), "tuition");
        return list;
    }
}
