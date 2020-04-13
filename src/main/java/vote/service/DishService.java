package vote.service;

import org.springframework.stereotype.Service;
import vote.model.Dish;
import vote.repository.DishRepository;

import java.util.List;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    List<Dish> findAll(){
        return repository.findAll();
    }

    Dish save(Dish dish){
        return repository.save(dish);
    }

    void delete(Dish dish){
        repository.delete(dish);
    }

    public Dish get(int id) {
        return repository.findById(id).orElseThrow();
    }
}
