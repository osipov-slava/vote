package vote.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vote.model.User;
import vote.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class UserService {
    
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createOrUpdate(@NotNull(message = "Must not be null.") @Valid User user) {
        return repository.save(user);
    }

    public User get(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("User with parameter \"id\" = " + id + " not found."));
    }

    public void delete(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("User with parameter \"id\" = " + id + " not found.");
        }
    }

    public List<User> getAll() {
        return repository.findAll();
    }

}
