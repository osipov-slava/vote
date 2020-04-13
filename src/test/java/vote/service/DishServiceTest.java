package vote.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vote.DishTestData;
import vote.model.Dish;
import vote.repository.DishRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static vote.DishTestData.*;

class DishServiceTest extends AbstractServiceTest{

    DishRepository repository;

    @Autowired
    DishService service;

    @Test
    void findAll() {
        List<Dish> dishes = service.findAll();
        assertEquals(dishes, DISHES);
    }

    @Test
    void save() {
        Dish newDish = DishTestData.getNew();
        Dish dishFromBase = service.save(newDish);
        newDish.setId(dishFromBase.getId());
        assertEquals(newDish, dishFromBase);
    }

    @Test
    void delete() {
        service.delete(DISH1);
        assertThrows(NoSuchElementException.class, () -> {
            service.get(DISH1_ID);
        });
    }

    @Test
    void get() {
        Dish dish = service.get(DISH1_ID);
        System.out.println(dish.toString());
    }

    @Test
    void getNotFound() throws NoSuchElementException{
        assertThrows(NoSuchElementException.class, () -> {
             service.get(1);
        });
    }
}