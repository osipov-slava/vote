package vote;

import vote.model.Vote;

import java.time.LocalDate;
import java.util.List;

import static vote.RestaurantTestData.RESTAURANT1;
import static vote.RestaurantTestData.RESTAURANT2;
import static vote.UserTestData.*;
import static vote.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
//    public static TestMatcher<Vote> VOTE_MATCHER = TestMatcher.usingFieldsComparator(Vote.class);

    public static final int VOTE1_ID = START_SEQ + 23;

    public static final Vote VOTE1 = new Vote(VOTE1_ID, USER, RESTAURANT2, LocalDate.of(2020, 4, 7));
    public static final Vote VOTE2 = new Vote(VOTE1_ID + 1, ADMIN, RESTAURANT2, LocalDate.of(2020, 4, 7));
    public static final Vote VOTE3 = new Vote(VOTE1_ID + 2, USER2, RESTAURANT2, LocalDate.of(2020, 4, 7));
    public static final Vote VOTE4 = new Vote(VOTE1_ID + 3, USER, RESTAURANT1);
    public static final Vote VOTE5 = new Vote(VOTE1_ID + 4, ADMIN, RESTAURANT2);

    public static final List<Vote> Votes = List.of(VOTE1, VOTE2, VOTE3, VOTE4, VOTE5);

    public static Vote getNew() {
        return new Vote(null, USER, RESTAURANT1, LocalDate.of(2020, 4, 10));
    }

    public static Vote getUpdated() {
        return new Vote(VOTE1_ID, USER, RESTAURANT1, LocalDate.of(2020, 4, 7));
    }
}
