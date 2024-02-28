package org.example.routineplanner.services;


import org.example.routineplanner.model.Tag;
import org.example.routineplanner.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag update(UUID id, Tag newTag) {
        return tagRepository.findById(id)
                .map(currentTag -> {
                    currentTag.setIconId(newTag.getIconId());
                    currentTag.setColor(newTag.getColor());
                    currentTag.setName(newTag.getName());
                    return tagRepository.save(currentTag);
                })
                .orElseThrow(() -> new NoSuchElementException("Noone found"));
    }

    public void delete(UUID id) {
        tagRepository.deleteById(id);
    }
}
