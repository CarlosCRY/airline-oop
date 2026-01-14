package org.ies.tierno.objects.aerolinea.reader.random;

import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.model.Passenger;
import org.ies.tierno.objects.aerolinea.reader.FlightReader;
import org.ies.tierno.objects.aerolinea.reader.PassengerReader;

import java.util.Random;

public class FlightRandomer implements FlightReader {
    private final static String[] CITIES = {
            // 16 [15]
            "Atlanta", "Beijing", "Casablanca", "Düsseldorf", "Estambul", "Hanoi", "Incheon", "Johannesburgo",
            "Londres", "Madrid", "Osaka", "París", "Roma", "Santiago", "Toronto", "Zúrich"
    };

    private final Random random;
    private final PassengerReader passengerReader;

    public FlightRandomer (Random random, PassengerReader passengerReader) {
        this.random = random;
        this.passengerReader = passengerReader;
    }

    @Override
    public Flight read () {
        String origin = CITIES[random.nextInt(CITIES.length)];
        String destination;
        do {
            destination = CITIES[random.nextInt(CITIES.length)];
        } while (destination.equals(origin));

        Passenger[] passengers = new Passenger[random.nextInt(1, 200)];

        for (int i = 0; i < passengers.length; i++) {
            passengers[i] = passengerReader.read();
        }

        return new Flight (
                random.nextInt(1000, 9999),
                origin,
                destination,
                "T" + random.nextInt(1, 4),
                passengers
                );
    }


}
