package vote;


import vote.model.Menu;

import java.util.List;

import static vote.DishTestData.*;
import static vote.RestaurantTestData.RESTAURANT1;
import static vote.model.AbstractBaseEntity.START_SEQ;


public class MenuTestData {
//    public static TestMatcher<Menu> MENU_MATCHER = TestMatcher.usingFieldsComparator(Menu.class);

    public static final int MENU1_ID = START_SEQ + 19;

    public static final Menu MENU1 = new Menu(MENU1_ID, RESTAURANT1, DISH1);
    public static final Menu MENU2 = new Menu(MENU1_ID + 1, RESTAURANT1, DISH2);
    public static final Menu MENU3 = new Menu(MENU1_ID + 2, RESTAURANT1, DISH3);
    public static final Menu MENU4 = new Menu(MENU1_ID + 3, RESTAURANT1, DISH4);

    public static final List<Menu> Menus = List.of(MENU1, MENU2, MENU3, MENU4);

    public static Menu getNew() {
        return new Menu(null, RESTAURANT1, DISH1);
    }

    public static Menu getUpdated() {
        return new Menu(MENU1_ID, RESTAURANT1, DISH6);
    }
}
