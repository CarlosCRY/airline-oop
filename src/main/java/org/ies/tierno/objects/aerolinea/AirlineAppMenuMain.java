package org.ies.tierno.objects.aerolinea;

import org.ies.tierno.objects.aerolinea.app.AirlineAppMenu;
import org.ies.tierno.objects.aerolinea.reader.scanner.AirlineScannerer;
import org.ies.tierno.objects.aerolinea.reader.scanner.FlightScannerer;
import org.ies.tierno.objects.aerolinea.reader.scanner.PassengerScannerer;

import java.util.Scanner;

public class AirlineAppMenuMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerScannerer passengerScannerer = new PassengerScannerer(scanner);
        FlightScannerer flightReader = new FlightScannerer(scanner, passengerScannerer);
        AirlineScannerer airlineReader = new AirlineScannerer(scanner, flightReader);
        AirlineAppMenu airlineApp = new AirlineAppMenu (scanner, airlineReader);

        airlineApp.run();
    }
}
