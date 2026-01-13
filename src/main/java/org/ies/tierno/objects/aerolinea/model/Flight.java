package org.ies.tierno.objects.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight {
    private int number;
    private String origin;
    private String destination;
    private String depGate;
    private Passenger[] passengers;

    public void showInfo() {
        System.out.println("\nVuelo " + number + " en puerta " + depGate + " desde " + origin
                + " con destino a " + destination);
    }

    public boolean hasPassenger (String nif) {
        for (Passenger passenger: passengers) {
            if (passenger.getNif().equals(nif)) {
                return true;
            }
        }
        return false;
    }

    public Passenger findPassenger (String nif) {
        for (Passenger passenger: passengers) {
            if (passenger.getNif().equals(nif)) {
                return passenger;
            }
        }
        return null;
    }
}
