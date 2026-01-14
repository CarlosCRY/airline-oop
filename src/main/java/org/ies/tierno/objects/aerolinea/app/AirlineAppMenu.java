package org.ies.tierno.objects.aerolinea.app;

import org.ies.tierno.objects.aerolinea.model.Airline;
import org.ies.tierno.objects.aerolinea.model.Flight;
import org.ies.tierno.objects.aerolinea.reader.AirlineReader;
import org.ies.tierno.objects.aerolinea.reader.scanner.AirlineScannerer;

import java.util.Scanner;

public class AirlineAppMenu implements App {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineAppMenu(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run() {
        Airline airline = airlineReader.read();

        int option;
        do {
            System.out.println("\nComandos disponibles:");
            System.out.println("1. Mostrar vuelos.");
            System.out.println("2. Encontrar vuelos por origen.");
            System.out.println("3. Encontrar vuelos por pasajero.");
            System.out.println("4. Mostrar asiento del pasajero en un vuelo concreto.");
            System.out.println("5. Cambiar el asiento de un pasajero.");
            System.out.println("6. Salir del programa.\n");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    airline.showFlights();
                    break;
                case 2:
                    System.out.println("\nIntroduzca el nombre del origen:\n");
                    airline.showFlightsFromOrigin(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("\nIntroduzca el NIF del pasajero:\n");
                    airline.showPassengersFlights(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("\nIntroduzca el número del vuelo:\n");
                    Flight flight = airline.findFlight(scanner.nextInt());
                    scanner.nextLine();
                    if (flight == null) {
                        System.out.println("\nEl vuelo no existe.\n");
                    } else {
                        System.out.println("\nIntroduzca el NIF del pasajero:\n");
                        Integer seat = airline.getPassengersSeat(flight.getNumber(), scanner.nextLine());
                        if (seat == null) {
                            System.out.println("\nEl pasajero no está registrado en el vuelo.\n");
                        } else {
                            System.out.println("\nEl asiento asignado es " + seat + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\nIntroduzca el número del vuelo:\n");
                    flight = airline.findFlight(scanner.nextInt());
                    scanner.nextLine();
                    if (flight == null) {
                        System.out.println("\nEl vuelo no existe.\n");
                    } else {
                        System.out.println("\nIntroduzca el NIF del pasajero:\n");
                        String nif = scanner.nextLine();
                        System.out.println("\nIntroduzca el número del nuevo asiento:\n");
                        airline.updateSeatNumber(flight.getNumber(), nif, scanner.nextInt());
                        scanner.nextLine();
                    }
                    break;
                case 6:
                    System.out.println("\nFinalizando programa");
                    break;
                default:
                    System.out.println("\nComando no válido\n");
            }
        } while (option != 6);
    }
}
