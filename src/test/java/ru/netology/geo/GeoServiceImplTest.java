package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import javax.tools.JavaFileManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class GeoServiceImplTest {
    GeoService geoService = Mockito.mock(GeoService.class);
    GeoServiceImpl geoServiceTest = new GeoServiceImpl();


    @Test
    void byIpRusTest() {

        String ipRus1 =  "172.0.32.11";
        String ipRus2 = "172.15.0";

        Location actualObject = geoServiceTest.byIp(ipRus1);
        String actual = actualObject.getStreet();
        String actual1 = geoServiceTest.byIp(ipRus2).getCity();
        String expected = "Lenina";
        String expected1 = "Moscow";

        Assertions.assertEquals(actual,expected);
        Assertions.assertEquals(actual1,expected1);
    }
    @Test
    void byIpAnyTest() {

        String ip1 =  "96.34.5";
        String ipUSA = "96.44.183.149";

        Location actualObject = geoServiceTest.byIp(ip1);
        String actual = actualObject.getCity();
        String actual1 = geoServiceTest.byIp(ipUSA).getStreet();
        String expected1 = " 10th Avenue";
        String expected = "New York";

        Assertions.assertEquals(actual,expected);
        Assertions.assertEquals(actual1,expected1);
    }
    }

