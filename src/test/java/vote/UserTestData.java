package vote;


import vote.model.Role;
import vote.model.User;

import java.util.Collections;
import java.util.Date;

import static vote.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
//    public static TestMatcher<User> USER_MATCHER = TestMatcher.usingFieldsComparator(User.class, "registered", "meals");

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);
    public static final User USER2 = new User(USER_ID + 2, "User2", "user2@yandex.ru", "password", Role.ROLE_USER);
    public static final User USER3 = new User(USER_ID + 3, "User3", "user3@yandex.ru", "password", Role.ROLE_USER);

    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", false, new Date(), Collections.singleton(Role.ROLE_USER));
    }

    public static User getUpdated() {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setRoles(Collections.singletonList(Role.ROLE_ADMIN));
        return updated;
    }
}
