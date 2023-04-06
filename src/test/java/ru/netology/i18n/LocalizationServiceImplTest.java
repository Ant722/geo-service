package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    LocalizationService localizationService = Mockito.mock(LocalizationService.class);
    LocalizationServiceImpl localizationServiceMock = new LocalizationServiceImpl();;

    @Test
    void localeRus() {

        Location locationMock = Mockito.mock(Location.class);
        Mockito.when(locationMock.getCountry())
                .thenReturn(Country.RUSSIA);

        String actual = localizationServiceMock.locale(locationMock.getCountry());
        String expected = "Добро пожаловать";
        Assertions.assertEquals(actual,expected);
    }

    @Test
    void localeNotRus() {

        Location locationMock = Mockito.mock(Location.class);
        Mockito.when(locationMock.getCountry())
                .thenReturn(Country.BRAZIL);

        String actual = localizationServiceMock.locale(locationMock.getCountry());
        String expected = "Welcome";
        Assertions.assertEquals(actual,expected);

    }
}