package edu.citytech.cst.s23253396.cst4713project.security.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Security Service Test")
class UserServiceTest {

    private final UserService userService = new UserService();

    @DisplayName("Security test with a valid password")
    @Order(1)
    @Test
    void testValidPassword() {
        boolean condition = this.userService.isAuthenticated("user-1", "hulk");
        assertTrue(condition);
    }

    @DisplayName("Security test with an invalid password")
    @Order(2)
    @Test
    void testInvalidPassword() {
        boolean condition = this.userService.isAuthenticated("user-1", "smash");
        assertFalse(condition);
    }

    @DisplayName("Security test with an invalid password and lock user")
    @Order(3)
    @RepeatedTest(3)
    void testInvalidPasswordAndLockUser() {
        boolean condition = this.userService.isAuthenticated("user-1", "smash");
        assertTrue(condition);
    }

    @DisplayName("Test 4")
    @Order(4)
    @Test
    void resetPassword() {
        var user = this.userService.getUserInfo("user-1");
        user.setDisabled(false);
        user.setLoginAttempts(0);
        this.userService.updateFile(user);

        assertTrue(true);
    }
}