package vote.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vote.model.Menu;
import vote.repository.MenuRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu createOrUpdate(@NotNull(message = "Must not be null.") @Valid Menu menu) {
        return repository.save(menu);
    }

    public Menu get(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Menu with parameter \"id\" = " + id + " not found."));
    }

    public void delete(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Menu with parameter \"id\" = " + id + " not found.");
        }
    }

    public List<Menu> getAll() {
        return repository.findAll();
    }

}
