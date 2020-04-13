package vote;


import vote.model.Restaurant;

import java.util.List;

import static vote.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {

//    public static TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingFieldsComparator(Restaurant.class);

    public static final int RESTAURANT1_ID = START_SEQ + 4;

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "Royal Palace");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT1_ID + 1, "Castle Wall");
    public static final Restaurant RESTAURANT3 = new Restaurant(RESTAURANT1_ID + 2, "Uncle Вася");

    public static final List<Restaurant> Restaurants = List.of(RESTAURANT1, RESTAURANT2, RESTAURANT3);

    public static Restaurant getNew() {
        return new Restaurant(null, "Новое ресторан");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "Обновленный ресторан");
    }
}
