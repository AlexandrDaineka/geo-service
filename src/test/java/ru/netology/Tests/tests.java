package ru.netology.Tests;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tests {

        Random random = new Random();




        //Поверить, что MessageSenderImpl всегда отправляет только английский текст, если ip относится к американскому сегменту адресов.
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

