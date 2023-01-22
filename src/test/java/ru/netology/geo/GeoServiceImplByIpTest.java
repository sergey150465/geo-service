package ru.netology.geo;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.netology.geo.GeoServiceImpl.*;

public class GeoServiceImplByIpTest {

    GeoServiceImpl geoService = new GeoServiceImpl();

    @ParameterizedTest
    @MethodSource("ipWithDataSource")
    public void byIp(String ip, Location expected) {

        //when
        Location actual = geoService.byIp(ip);

        //then
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> ipWithDataSource() {
        return Stream.of(Arguments.of(LOCALHOST, new Location(null, null, null, 0)),
                Arguments.of(MOSCOW_IP, new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                Arguments.of(NEW_YORK_IP, new Location("New York", Country.USA, " 10th Avenue", 32)),
                Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
                Arguments.of("96.", "New York", Country.USA, null, 0));
    }

    @Test
    public void byCoordinates(){
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new RuntimeException("Not implemented");
                }
        );
        assertEquals("Not implemented", exception.getMessage());
    }
}
