package vote.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vote.model.Restaurant;
import vote.repository.RestaurantRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class RestaurantService {
    
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant createOrUpdate(@NotNull(message = "Must not be null.") @Valid Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant get(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Restaurant with parameter \"id\" = " + id + " not found."));
    }

    public void delete(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Restaurant with parameter \"id\" = " + id + " not found.");
        }
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

}
