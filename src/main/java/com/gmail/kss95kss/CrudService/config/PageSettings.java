package com.gmail.kss95kss.CrudService.config;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Setter
@Getter
public class PageSettings {

    private int page = 1;

    private int elementPerPage = 5;

    private String direction = "dsc";

    private String key;

    public Sort buildSort() {
        switch (direction) {
            case "dsc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
                LOG.warn("Invalid direction provided in PageSettings, using descending direction as default value");
                return Sort.by(key).descending();
        }
    }
}
