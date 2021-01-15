package forum.rest;

import forum.entity.Section;
import forum.repository.SectionRepository;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SectionsRestController {

    private final SectionRepository sectionRepository;

    public SectionsRestController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @GetMapping("/api/sections")
    public Page<Section> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Pageable request = PageRequest.of(page, size, Sort.by("id"));
        Page<Section> pageResponse = sectionRepository.findAll(request);
        return pageResponse;
    }

    @GetMapping("/api/{name}/byname")
    public Page<Section> getByName(@PathVariable(value = "name") String name,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "1") Integer size) {
        Pageable request = PageRequest.of(page, size, Sort.by("id"));
        val section = sectionRepository.findByName(name, request);
        return section;
    }

    @GetMapping("/api/sections/{id}")
    public Section getById(@PathVariable("id") Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Transactional
    @GetMapping("/api/sections/generate/{count}")
    public Long generate(@PathVariable("count") Long count) {
        for (long i = 0; i < count; ++i) {
            Section section = new Section();
            section.setName("" + i + i + i);
            sectionRepository.save(section);
        }

        return count;
    }
}
