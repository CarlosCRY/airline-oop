package org.ies.tierno.objects.aerolinea.reader.random;

import org.ies.tierno.objects.aerolinea.model.Airline;
import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.reader.AirlineReader;
import org.ies.tierno.objects.aerolinea.reader.FlightReader;

import java.util.Random;

public class AirlineRandomer implements AirlineReader {
    private final static String[] CITIES = {
            // 16 [15]
            "Atlanta", "Beijing", "Casablanca", "Düsseldorf", "Estambul", "Hanoi", "Incheon", "Johannesburgo",
            "Londres", "Madrid", "Osaka", "París", "Roma", "Santiago", "Toronto", "Zúrich"
    };

    private final Random random;
    private final FlightReader flightReader;

    public AirlineRandomer(Random random, FlightReader flightReader) {
        this.random = random;
        this.flightReader = flightReader;
    }

    @Override
    public Airline read () {
        String name = CITIES[random.nextInt(CITIES.length)];

        Flight[] flights = new Flight[random.nextInt(1, 100)];

        for (int i = 0; i < flights.length; i++) {
            flights[i] = flightReader.read();
        }

        return new Airline (
                CITIES[random.nextInt(CITIES.length)],
                flights
                );
    }


}
