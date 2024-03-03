package routineplanner.repository;

import routineplanner.controller.dto.RoutineHeaderDto;
import routineplanner.model.Routine;
import routineplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository extends JpaRepository<Routine, UUID> {


    List<RoutineHeaderDto> findAllByUser(User user);

    Optional<Routine> findByUserAndId( User user, UUID uuid);


}
