package com.gmail.kss95kss.CrudService.controller.domain.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PageDto <T>{

    private List content;
    private int totalElements;
}
