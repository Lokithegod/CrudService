package com.gmail.kss95kss.CrudService.service;

import com.gmail.kss95kss.CrudService.exception.*;
import com.gmail.kss95kss.CrudService.repository.CarRepository;
import com.gmail.kss95kss.CrudService.repository.CompanyRepository;
import com.gmail.kss95kss.CrudService.utilities.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CarServiceImpl carService;


    @Test
    void ifFindAllCarsThenSuccess() {
        //given
        var expected = TestData.getCars();
        //When
        when(carRepository.findAll()).thenReturn(TestData.getCars());
        var actual = carService.findAllCar();
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void ifFindCarByIdThenSuccess() {
        //Given
        var expected = TestData.getCar(73);
        //When
        when(carService.findCarById(73)).thenReturn(TestData.getCar(73));
        var actual = carService.findCarById(73);
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void ifFindCarByYearThenSuccess() {
        //Given
        var expected = TestData.getCarsByYear();
        //When
        when(carRepository.findByYear(2016)).thenReturn(TestData.getCarsByYear());
        var actual = carService.findCarsByYear(2016);
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void ifFindCarsByCompanyNameThenSuccess() {
        //Given
        var expected = TestData.getCars();
        //When
        when(companyRepository.findCompanyByName("Baza")).thenReturn(TestData.getCompany());
        when(carRepository.findByCompanyEntityName("Baza")).thenReturn(TestData.getCars());
        var actual = carService.findCarsByCompanyName("Baza");
        //Then
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void ifFindCarsByCompanyNameThenThrowCompanyNotFounException() {
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
        when(carRepository.findAll()).thenReturn(TestData.getCars());
        //When
        assertThatCode(() -> carService.addNewCar(TestData.getCar("testVin")))
                //then
                .doesNotThrowAnyException();
    }

    @Test
    void ifAddNewCarThenDuplicateVinCodeException() {
        //Given
        when(carService.findAllCar()).thenReturn(TestData.addInToGetCars(TestData.getCar(1)));
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
        when(carRepository.findCarById(0)).thenReturn(TestData.getCar());
        //Then
        assertThatCode(() -> carService.updateCar(0,carRepository.findCarById(0)))
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
                .isThrownBy(() -> carService.updateCar(0,carRepository.findCarById(0)));
    }

    @Test
    void ifUpdateCarThenThenThrowDuplicateVinCodeException() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCar());
        when(carRepository.findAll()).thenReturn(TestData.getCars());
        //Then
        assertThatExceptionOfType(DuplicateVinCodeException.class)
                //when
                .isThrownBy(() -> carService.updateCar(0,carRepository.findCarById(0)));
    }

    @Test
    void ifAddCarToCompanyThenSuccess() {
        //Given
        when(carRepository.findCarById(0)).thenReturn(TestData.getCarWithEmptyCompany());
        when(companyRepository.findCompanyByName("Baza")).thenReturn(TestData.getCompany());
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
        when(carRepository.findByCompanyEntityName("Baza")).thenReturn(TestData.getCars());
        //Then
        assertThatExceptionOfType(CompanyCarsIsFullException.class)
                //when
                .isThrownBy(() -> carService.addCarToCompany(0,"Baza"));
    }

}
