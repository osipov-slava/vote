package vote;


import vote.model.Dish;

import java.math.BigDecimal;
import java.util.List;

import static vote.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {

//    public static TestMatcher<Dish> DISH_MATCHER = TestMatcher.usingFieldsComparator(Dish.class);

    public static final int DISH1_ID = START_SEQ + 7;

    public static final Dish DISH1 = new Dish(DISH1_ID, "Салат Столичный", new BigDecimal("350.00"));
    public static final Dish DISH2 = new Dish(DISH1_ID + 1, "Борщ Сибирский с фасолью", new BigDecimal("590.00"));
    public static final Dish DISH3 = new Dish(DISH1_ID + 2, "Куринные биточки", new BigDecimal("690.00"));
    public static final Dish DISH4 = new Dish(DISH1_ID + 3, "Рис Микс", new BigDecimal("200.00"));

    public static final Dish DISH5 = new Dish(DISH1_ID + 4, "Салат Карелия", new BigDecimal("220.00"));
    public static final Dish DISH6 = new Dish(DISH1_ID + 5, "Суп Лапша по домашнему", new BigDecimal("450.00"));
    public static final Dish DISH7 = new Dish(DISH1_ID + 6, "Зразы мясные с томатным соусом", new BigDecimal("470.00"));
    public static final Dish DISH8 = new Dish(DISH1_ID + 7, "Греча", new BigDecimal("90.00"));

    public static final Dish DISH9 = new Dish(DISH1_ID + 8, "Салат Оливье", new BigDecimal("70.00"));
    public static final Dish DISH10 = new Dish(DISH1_ID + 9, "Суп Гороховый с копченностями", new BigDecimal("90.00"));
    public static final Dish DISH11 = new Dish(DISH1_ID + 10, "Поджарка из свинины", new BigDecimal("160.00"));
    public static final Dish DISH12 = new Dish(DISH1_ID + 11, "Макароны", new BigDecimal("50.00"));

    public static final List<Dish> DISHES = List.of(DISH1, DISH2, DISH3, DISH4, DISH5, DISH6,
            DISH7, DISH8, DISH9, DISH10, DISH11, DISH12);

    public static Dish getNew() {
        return new Dish(null, "Новое блюдо", new BigDecimal("777.00"));
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "Обновленный завтрак", new BigDecimal("888.00"));
    }
}
