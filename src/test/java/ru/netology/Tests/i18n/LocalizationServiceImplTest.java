package ru.netology.Tests.i18n;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    public void testRuMessage() {
        Country country = Country.RUSSIA;
        LocalizationService localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String actual = "Добро пожаловать";
        String expected = localizationService.locale(country);
        assertEquals(expected, actual);
    }
}