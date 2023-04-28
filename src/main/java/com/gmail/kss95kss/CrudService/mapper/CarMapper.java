package com.gmail.kss95kss.CrudService.mapper;

import com.gmail.kss95kss.CrudService.controller.domain.dto.CarDto;
import com.gmail.kss95kss.CrudService.model.Car;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CarMapper {

    //@Mapping(target = "id", ignore = true)
    Car toCarEntity(CarDto car);

    CarDto toCarDto(Car car);

    List<CarDto> toListCarDto(List<Car> car);
}