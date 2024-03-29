package routineplanner.service;

import jakarta.persistence.EntityNotFoundException;
import routineplanner.controller.dto.RoutineHeaderDto;
import routineplanner.model.Routine;
import routineplanner.model.User;
import routineplanner.repository.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoutineService {
    private final RoutineRepository repository;

    public RoutineService(RoutineRepository repository) {
        this.repository = repository;
    }


    // wszystkie rutyny danego użytkownika
    public List<RoutineHeaderDto> getRoutineHeaders() {
        User u = new User();
        // TODO security...
        return repository.findAllByUser(u);
    }


    // konkretna rutyna danego użytkownika
    public Routine getRoutine (UUID uuid) {
        User u = new User();
        return repository.findByUserAndId(u, uuid)
                .orElseThrow(() -> new EntityNotFoundException("Routine with UUID: " + uuid + " does not exist"));
    }


    public Routine createRoutine(Routine routine) {
        return repository.save(routine);
    }

    public void deleteRoutine(UUID id) {
        repository.deleteById(id);
    }
}
