package org.example.routineplanner.services;


import org.example.routineplanner.TagDto;
import org.example.routineplanner.model.Tag;
import org.example.routineplanner.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    public List<Tag> getAllTags() {
        return (List<Tag>) repository.findAll();
    }

    public Tag createTag(TagDto tag) {
        System.out.println(tag);
        Tag t = new Tag(tag);
        return repository.save(t);
    }

    public void updateTag(Tag tag) {
        repository.save(tag);
    }
}
