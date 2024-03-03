package routineplanner.service;


import jakarta.persistence.EntityNotFoundException;
import routineplanner.model.Tag;
import routineplanner.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        // TODO check if tag already exists
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
                .orElseThrow(() -> new EntityNotFoundException("Tag with UUID: " + id + " does not exist"));
    }

    public void delete(UUID id) {
        tagRepository.deleteById(id);
    }
}
