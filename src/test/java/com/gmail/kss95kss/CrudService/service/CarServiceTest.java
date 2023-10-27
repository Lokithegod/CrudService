package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.config.PageSettings;
import com.gmail.kss95kss.CrudService.exception.*;
import com.gmail.kss95kss.CrudService.mapper.CarMapper;
import com.gmail.kss95kss.CrudService.model.Car;
import com.gmail.kss95kss.CrudService.repository.CarRepositoryCrud;
import com.gmail.kss95kss.CrudService.repository.CarSearchRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.repository.specification.CarSearchParams;
import com.gmail.kss95kss.CrudService.utilities.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepositoryCrud carRepository;
    @Mock
    private CarSearchRepository carSearchRepository;
    @Mock
    private CarMapper carMapper;
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CarServiceImpl carService;

    private  PageSettings pageSettings = new PageSettings();

    private CarSearchParams defaultParams = new CarSearchParams(null,2023,9999999,"","");

    private  Pageable firstPage = PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage());
   // private static Pageable firstPage = PageRequest.of(0, 10);


    @Test
    void ifFindAllCarsThenSuccess() {
        //given
        var expected = TestData.getCarsPage();
        //When
        when(carSearchRepository.findCarsByCriteria(defaultParams,firstPage)).thenReturn(TestData.getCarsPage());
        var actual = carSearchRepository.findCarsByCriteria(defaultParams,firstPage);
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

/*    @Test
    void ifFindCarByIdThenSuccess() {
        //Given
        var expected = TestData.getCar(73);
        //When
        when(carService.findCarById(73)).thenReturn(TestData.getCar(73));
        var actual = carService.findCarById(73);
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }*/

    @Test
    void ifFindCarsByCompanyNameThenThrowCompanyNotFoundException() {
        //Given
        when(companyRepository.findCompanyByName("Baza")).thenReturn(null);
        //Then
        assertThatExceptionOfType(CompanyNotFoundException.class)
                //when
                .isThrownBy(() -> carService.findCarsByCompanyName("Baza"));

    }

    @Test
    void ifAddNewCarThenSuccess() {
        //Given
        //When
        assertThatCode(() -> carService.addNewCar(TestData.getCar("JH4KA7670PC005516")))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void ifAddNewCarThenDuplicateVinCodeException() {
        //Given
        var car = TestData.getCar();
        when(carRepository.existsByVin(car.getVin())).thenReturn(true);
        //When
        assertThatExceptionOfType(DuplicateVinCodeException.class)
                //when
                .isThrownBy(() -> carService.addNewCar(TestData.getCar(2)));
    }

    @Test
    void ifDeleteCarThenSuccess() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCar());
        //When
        assertThatCode(() -> carService.deleteCarById(0))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void ifDeleteCarThenThrowCarNotFoundException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(null);
        //Then
        assertThatExceptionOfType(CarNotFoundException.class)
                //when
                .isThrownBy(() -> carService.deleteCarById(0));
    }

    @Test
    void ifUpdateCarThenSuccess() {
        //Given
        when(carMapper.toCarDto(carRepository.findCarById(1))).thenReturn(TestData.getCarDto("JHADA9390MS033554"));
        when(carRepository.existsByVin(TestData.getCarDto("JHADA9390MS033552").getVin())).thenReturn(false);
        //Then
        assertThatCode(() -> carService.updateCar(0,carMapper.toCarDto(carRepository.findCarById(0))))
                //then
                .doesNotThrowAnyException();
    }
    @Test
    void ifUpdateCarThenThenThrowCarNotFoundException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(null);
        //Then
        assertThatExceptionOfType(CarNotFoundException.class)
                //when
                .isThrownBy(() -> carService.updateCar(0,carMapper.toCarDto(carRepository.findCarById(0))));
    }

    @Test
    void ifUpdateCarThenThenThrowDuplicateVinCodeException() {
        //Given
        when(carMapper.toCarDto(carRepository.findCarById(1))).thenReturn(TestData.getCarDto("JHADA9390MS033554"));
        when(carRepository.existsByVin(TestData.getCarDto("JHADA9390MS033554").getVin())).thenReturn(true);
        //Then
        assertThatExceptionOfType(DuplicateVinCodeException.class)
                //when
                .isThrownBy(() -> carService.updateCar(1,carMapper.toCarDto(carRepository.findCarById(0))));
    }

    @Test
    void ifAddCarToCompanyThenSuccess() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCarWithEmptyCompany());
        when(companyRepository.findCompanyByName("Baza")).thenReturn(TestData.getCompany());
        when(carRepository.findByCompanyEntityName("Baza", PageRequest.of(pageSettings.getPage(), pageSettings.getElementPerPage()))).thenReturn(TestData.getCarsPage(2));
        //Then
        assertThatCode(() -> carService.addCarToCompany(0,"Baza"))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void ifAddCarToCompanyThenThrowCarNotFoundException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(null);
        //Then
        assertThatExceptionOfType(CarNotFoundException.class)
                //when
                .isThrownBy(() -> carService.addCarToCompany(0,"Baza"));
    }
    @Test
    void ifAddCarToCompanyThenThrowCompanyNotFoundException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCarWithEmptyCompany());
        when(companyRepository.findCompanyByName("Baza")).thenReturn(null);
        //Then
        assertThatExceptionOfType(CompanyNotFoundException.class)
                //when
                .isThrownBy(() -> carService.addCarToCompany(0,"Baza"));
    }

    @Test
    void ifAddCarToCompanyThenThrowCarAlreadyInCompanyException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCar());
        //Then
        assertThatExceptionOfType(CarAlreadyInCompanyException.class)
                //when
                .isThrownBy(() -> carService.addCarToCompany(0,"Baza"));
    }

    @Test
    void ifAddCarToCompanyThenThrowCompanyCarsIsFullException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCarWithEmptyCompany());
        when(companyRepository.findCompanyByName("Baza")).thenReturn(TestData.getCompany());
        when(carRepository.findByCompanyEntityName("Baza",firstPage)).thenReturn(TestData.getCarsPage(20));
        //Then
        assertThatExceptionOfType(CompanyCarsIsFullException.class)
                //when
                .isThrownBy(() -> carService.addCarToCompany(0,"Baza"));
    }

}
