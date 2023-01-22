package ru.netology.i18n;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.netology.entity.Country.*;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @ParameterizedTest
    @MethodSource("localeWithDataSource")
    public void locale(Country country, String expected){

        //when
        String actual = localizationService.locale(country);

        //then
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> localeWithDataSource(){
        return Stream.of(Arguments.of(RUSSIA, "Добро пожаловать"),
                Arguments.of(USA, "Welcome"),
                Arguments.of(GERMANY, "Welcome"),
                Arguments.of(BRAZIL, "Welcome"));

    }
}
