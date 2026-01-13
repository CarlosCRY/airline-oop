package org.ies.tierno.objects.aerolinea.reader.scanner;

import org.ies.tierno.objects.aerolinea.model.Airline;
import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.reader.AirlineReader;
import org.ies.tierno.objects.aerolinea.reader.FlightReader;


import java.util.Scanner;


public class AirlineScannerer implements AirlineReader {

    private final Scanner scanner;
    private final FlightReader flightReader;

    public AirlineScannerer (Scanner scanner, FlightReader flightReader) {
        this.scanner = scanner;
        this.flightReader = flightReader;
    }
    @Override
    public Airline read() {
        System.out.println("\nIntroduzca los datos de la aerolínea:");

        System.out.println("Nombre\n");
        String name = scanner.nextLine();

        int n;
        System.out.println("\nIntroduzca una cantidad de vuelos.\n");
        do {
            n = scanner.nextInt();
            scanner.nextLine();
            if (n <= 0) {
                System.out.println("\nNo es una cantidad válida\n");
            }
        } while (n <= 0);

        Flight[] flights = new Flight[n];

        for (int i = 0; i < n; i++) {
            flights[i] = flightReader.read();
            System.out.println("\nVuelo " + (i + 1) + " Definido.");
        }
        return new Airline(name, flights);
    }
}
