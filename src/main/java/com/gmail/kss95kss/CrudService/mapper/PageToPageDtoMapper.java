package com.gmail.kss95kss.CrudService.mapper;


import com.gmail.kss95kss.CrudService.controller.domain.dto.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageToPageDtoMapper<T> {


    public PageDto<T> pageToPageDto(Page<T> page) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setContent(page.getContent());
        pageDto.setTotalElements(page.getNumberOfElements());
        return pageDto;
    }
}
