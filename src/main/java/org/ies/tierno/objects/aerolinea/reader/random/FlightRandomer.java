package org.ies.tierno.objects.aerolinea.reader.random;

import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.reader.FlightReader;

import java.util.Random;

public class FlightRandomer implements FlightReader {
    private final static String[] NAMES = {
            // 21 [20]
            "Abigail", "Benito", "Celia", "David", "Emilia", "Fernando", "Gloria", "Hugo", "Isabel", "Juan", "Laura",
            "María", "Nicolás", "Olivia", "Pablo", "Raquel", "Santiago", "Tatiana", "Víctor", "Yolanda", "Zacarías"
    };

    private final static String[] SURNAMES = {
            // 14 [13]
            "Aguilar", "Barrantes", "Cortázar", "Garza", "Huertas", "Iñiguez", "Morales",
            "Osorio", "Ponce", "Quesada", "Rivas", "Serrano", "Urriaga", "Vázquez"
    };

    private final Random random;

    public FlightRandomer(Random random) {
        this.random = random;
    }

    @Override
    public Flight read () {
        return new Flight (
                random.nextInt(1000, 9999),
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)],
                random.nextInt(1, 200)
                );
    }


}
