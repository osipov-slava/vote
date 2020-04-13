package vote.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import vote.model.Vote;
import vote.repository.VoteRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Validated
public class VoteService {
    
    private final VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public Vote createOrUpdate(@NotNull(message = "Must not be null.") @Valid Vote vote) {
        return repository.save(vote);
    }

    public Vote get(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Vote with parameter \"id\" = " + id + " not found."));
    }

    public void delete(@NotNull(message = "Must not be null.") @Positive(message = "Must be positive.") Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new NoSuchElementException("Vote with parameter \"id\" = " + id + " not found.");
        }
    }

    public List<Vote> getAll() {
        return repository.findAll();
    }

}
