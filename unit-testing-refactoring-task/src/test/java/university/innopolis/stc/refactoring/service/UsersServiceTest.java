package university.innopolis.stc.refactoring.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.innopolis.stc.refactoring.repository.UsersRepository;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsersServiceTest {

    private static UsersRepository userRepository;

    @BeforeAll
    private static void init() {
        userRepository = Mockito.mock(UsersRepository.class);
    }

    @Test
    void changePassword() {
    }

    @Test
    void authorize() {
        UsersService usersService = new UsersService(userRepository);
        boolean authorize = usersService.authorize("kosmonaFFFt", "1234567890");
        assertTrue(authorize);
    }
}
