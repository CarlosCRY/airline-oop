package org.ies.tierno.objects.aerolinea.reader.random;

import org.ies.tierno.objects.aerolinea.model.Passenger;
import org.ies.tierno.objects.aerolinea.reader.PassengerReader;

import java.util.Random;

public class PassengerRandomer implements PassengerReader {
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

    public PassengerRandomer (Random random) {
        this.random = random;
    }

    @Override
    public Passenger read () {
        return new Passenger (
                random.nextInt(1000000, 99999999) + "X",
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)],
                random.nextInt(1, 200)
                );
    }


}
