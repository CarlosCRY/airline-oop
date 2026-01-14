package org.ies.tierno.objects.aerolinea.app;

import org.ies.tierno.objects.aerolinea.model.Airline;
import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.model.Passenger;
import org.ies.tierno.objects.aerolinea.reader.AirlineReader;
import org.ies.tierno.objects.aerolinea.reader.scanner.AirlineScannerer;

import java.util.Scanner;

public class AirlineApp1 implements App {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp1 (Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run () {
        Airline airline = airlineReader.read();

        System.out.println("\nIntroduzca un número de vuelo:\n");

        Flight x = airline.findFlight(scanner.nextInt());
        scanner.nextLine();

        if (x == null) {
            System.out.println("\nNúmero de vuelo no encontrado\n");
        } else {
            System.out.println("\nVuelo " + x.getNumber() + " encontrado.");
            System.out.println("Introduzca el NIF del pasajero:");
            Passenger y = x.findPassenger(scanner.nextLine());
            if (y == null) {
                System.out.println("\nNIF de pasajero no encontrado\n");
            } else {
                y.showInfo();
                System.out.println("\nIntroduzca el número del nuevo asiento para el pasajero:\n");
                airline.updateSeatNumber(x.getNumber(), y.getNif(), scanner.nextInt());
            }
        }
    }

}
