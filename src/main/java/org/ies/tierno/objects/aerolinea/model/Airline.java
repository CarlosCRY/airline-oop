package org.ies.tierno.objects.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Airline {
    private String name;
    private Flight[] flights;

    public void showFlights () {
        for (Flight flight: flights) {
            flight.showInfo();
        }
    }

    public void showFlightsFromOrigin (String origin) {
        for (Flight flight: flights) {
            if (flight.getOrigin().equals(origin)) {
                flight.showInfo();
            }
        }
    }

    public Flight findFlight (int number) {
        for (Flight flight: flights) {
            if (flight.getNumber() == (number)) {
                return flight;
            }
        }
        return null;
    }

    public void showPassengersFlights (String nif) {
        for (Flight flight: flights) {
            for (Passenger passenger: flight.getPassengers()) {
                if (passenger.getNif().equals(nif)) {
                    flight.showInfo();
                    break;
                }
            }
        }
    }

    public Integer getPassengersSeat (int flightNumber, String nif) {
        for (Flight flight: flights) {
            if (flight.getNumber() == flightNumber) {
                for (Passenger passenger: flight.getPassengers()) {
                    if (passenger.getNif().equals(nif)) {
                        return passenger.getSeat();
                    }
                }
                break;
            }
        }
        return null;
    }

    public void updateSeatNumber (int flightNumber, String nif, int seatNumber) {
        for (Flight flight: flights) {
            if (flight.getNumber() == flightNumber) {
                for (Passenger passenger: flight.getPassengers()) {
                    if (passenger.getNif().equals(nif)) {
                        passenger.setSeat(seatNumber);
                    }
                }
                break;
            }
        }
        System.out.println("\nPasajero no encontrado." +
                " El número del vuelo o el NIF del pasajero pueden no ser correctos.\n");
    }
}
