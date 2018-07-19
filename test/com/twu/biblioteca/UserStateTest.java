package com.twu.biblioteca;

import org.junit.Before;

public class UserStateTest {

    private UserState userState;
    private User user;

    @Before
    public void setUp() {
        userState = new UserState();
        user = new User("Rushil Gala-Shah",
                "rushil@example.com",
                "020 8000 0000",
                1352341,
                "test!Password");
    }
}
