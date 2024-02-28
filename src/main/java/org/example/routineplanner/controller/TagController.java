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

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Tag> getAllTags() {
        return tagService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.create(tag);
    }


    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable UUID id, @RequestBody Tag tag) {
        return tagService.update(id, tag);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable UUID id) {
        tagService.delete(id);
    }

}

