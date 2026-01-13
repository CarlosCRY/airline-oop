package org.ies.tierno.objects.aerolinea.reader.scanner;

import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.model.Passenger;
import org.ies.tierno.objects.aerolinea.reader.FlightReader;
import org.ies.tierno.objects.aerolinea.reader.PassengerReader;

import java.util.Scanner;

public class FlightScannerer implements FlightReader {

    private final Scanner scanner;
    private final PassengerReader passengerReader;

    public FlightScannerer(Scanner scanner, PassengerReader passengerReader) {
        this.scanner = scanner;
        this.passengerReader = passengerReader;
    }

    @Override
    public Flight read() {
        System.out.println("\nIntroduzca los datos del vuelo:");

        System.out.println("Número\n");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nOrigen\n");
        String origin = scanner.nextLine();

        System.out.println("\nDestino\n");
        String destination = scanner.nextLine();

        System.out.println("\nPuerta de embarque\n");
        String depGate = scanner.nextLine();

        int n;
        System.out.println("\nIntroduzca la cantidad de pasajeros.\n");
        do {
            n = scanner.nextInt();
            scanner.nextLine();
            if (n <= 0) {
                System.out.println("\nNo es una cantidad válida\n");
            }
        } while (n <= 0);

        Passenger[] passengers = new Passenger[n];

        for (int i = 0; i < n; i++) {
            passengers[i] = passengerReader.read();
            System.out.println("\nPasajero " + (i + 1) + " Definido.");
        }

        return new Flight(number, origin, destination, depGate, passengers);
    }
}
