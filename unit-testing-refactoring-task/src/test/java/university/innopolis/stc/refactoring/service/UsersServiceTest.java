package university.innopolis.stc.refactoring.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UsersServiceTest {

    @Test
    void changePassword() {
    }

    @Test
    void authorize() {
        UsersService usersService = new UsersService();
        boolean authorize = usersService.authorize("kosmonaFFFt", "1234567890");
        assertTrue(authorize);
    }
}