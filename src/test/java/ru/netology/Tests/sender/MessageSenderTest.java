package ru.netology.Tests.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {
    Random random = new Random();
    @Test
    public void test_Mock() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> map = new HashMap<String, String>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");

        String expected = messageSender.send(map);
        String actual = "Добро пожаловать";

        assertEquals(expected, actual);
    }

    @Test
    public void testUSA_with_testUSAMessage() {
        GeoService geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Location loc = geoService.byIp("96." + String.valueOf(random.nextDouble()));
        Country country = loc.getCountry();
        String actual = "Welcome";
        String expected = localizationService.locale(country);
        assertEquals(expected, actual);
    }
}