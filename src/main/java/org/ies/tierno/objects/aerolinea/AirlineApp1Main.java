package org.ies.tierno.objects.aerolinea;

import org.ies.tierno.objects.aerolinea.reader.scanner.AirlineScannerer;
import org.ies.tierno.objects.aerolinea.reader.scanner.FlightScannerer;
import org.ies.tierno.objects.aerolinea.reader.scanner.PassengerScannerer;
import org.ies.tierno.objects.aerolinea.app.AirlineApp1;

import java.util.Scanner;

public class AirlineApp1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerScannerer passengerReader = new PassengerScannerer(scanner);
        FlightScannerer flightReader = new FlightScannerer(scanner, passengerReader);
        AirlineScannerer airlineReader = new AirlineScannerer(scanner, flightReader);
        AirlineApp1 airlineApp = new AirlineApp1 (scanner, airlineReader);

        airlineApp.run();
    }
}
