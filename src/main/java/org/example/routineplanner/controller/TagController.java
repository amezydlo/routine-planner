package org.example.routineplanner.controller;


import org.example.routineplanner.model.Tag;
import org.example.routineplanner.services.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/tags")
public class TagController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }


    @GetMapping()
    public List<Tag> getAllTags() {
        return service.getAllTags();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag) {
        return service.createTag(tag);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTag(@PathVariable UUID id, @RequestBody Tag tag) {
        service.updateTag(tag);
    }

}

