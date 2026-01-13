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

    public FlightRandomer(Random random) {
        this.random = random;
    }

    @Override
    public Flight read () {
        String origin = CITIES[random.nextInt(CITIES.length)];
        String destination;
        do {
            destination = CITIES[random.nextInt(CITIES.length)];
        } while (destination.equals(origin));

        return new Flight (
                random.nextInt(1000, 9999),
                origin,
                destination,
                "T" + random.nextInt(1, 4),
                passengers
                );
    }


}
