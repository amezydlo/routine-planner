package org.example.routineplanner.controller;


import org.example.routineplanner.controller.dto.RoutineHeaderDto;
import org.example.routineplanner.model.Routine;
import org.example.routineplanner.repositories.RoutineRepository;
import org.example.routineplanner.services.RoutineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/routines")
public class RoutineController {

    private final RoutineService service;


    public RoutineController(RoutineService service) {
        this.service = service;
    }

    @GetMapping
    private List<RoutineHeaderDto> getUserRoutines() {
        return service.getRoutineHeaders();
    }

    @GetMapping("/{id}")
    private Routine getSingleRoutine(@PathVariable UUID id) {
        return service.getRoutine(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    private Routine createRoutine(@RequestBody Routine routine) {
        return service.createRoutine(routine);
    }

    // TODO - czy robić put?

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteRoutine(@PathVariable UUID id) {
        service.deleteRoutine(id);
    }

}
