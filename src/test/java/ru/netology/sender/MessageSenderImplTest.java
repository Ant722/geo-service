package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;

class MessageSenderImplTest {
    GeoService geoServiceMock = Mockito.mock(GeoServiceImpl.class);
    LocalizationService localizationServiceMock = Mockito.mock(LocalizationServiceImpl.class);
    MessageSender messageSender = new MessageSenderImpl(geoServiceMock,localizationServiceMock);



    @Test
    void sendRusText() {
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry())
                .thenReturn(Country.RUSSIA);
        Mockito.when(geoServiceMock.byIp(Mockito.anyString()))
                .thenReturn(location);
        Mockito.when(localizationServiceMock.locale(location.getCountry()))
                .thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.12.19");
        String actual = messageSender.send(headers);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected,actual);

    }

    @Test
    void sendUSAText() {
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry())
                .thenReturn(Country.USA);
        Mockito.when(geoServiceMock.byIp(Mockito.anyString()))
                .thenReturn(location);
        Mockito.when(localizationServiceMock.locale(location.getCountry()))
                .thenReturn("Welcome");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.15.128.1");
        String actual = messageSender.send(headers);
        String expected = "Welcome";
        Assertions.assertEquals(actual,expected);

    }
}