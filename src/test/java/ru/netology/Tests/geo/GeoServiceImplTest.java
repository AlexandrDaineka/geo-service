package ru.netology.Tests.geo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    Random random = new Random();
    @Test
    public void testRU() {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        Location loc = geoService.byIp("172." + String.valueOf(random.nextDouble()));
        String actual = "RUSSIA";
        String expected = String.valueOf(loc.getCountry());
        assertEquals(expected, actual);
    }
}