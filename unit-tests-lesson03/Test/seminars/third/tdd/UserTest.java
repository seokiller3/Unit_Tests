package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Pavel", "qwerty");
    }

    @Test
    void userCreationSuccess() {
        String login = "Pavel";
        String pass = "qwerty";
        assertTrue((BooleanSupplier) user.auth(login, pass));
    }

    @Test
    void userCreationFail() {
        String login = "Pavel321";
        String pass = "qwerty123";
        assertFalse((BooleanSupplier) user.auth(login, pass));
    }
@Test
    void userFromTheRepository(){
    assertTrue((BooleanSupplier) UserRepository.main(login, pass));
}

}