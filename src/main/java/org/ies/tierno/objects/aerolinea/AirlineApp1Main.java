package org.ies.tierno.objects.aerolinea;

import org.ies.tierno.objects.aerolinea.reader.random.AirlineRandomer;
import org.ies.tierno.objects.aerolinea.reader.random.FlightRandomer;
import org.ies.tierno.objects.aerolinea.reader.random.PassengerRandomer;
import org.ies.tierno.objects.aerolinea.app.AirlineApp1;

import java.util.Random;
import java.util.Scanner;

public class AirlineApp1Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner (System.in);
        PassengerRandomer passengerReader = new PassengerRandomer(random);
        FlightRandomer flightReader = new FlightRandomer(random, passengerReader);
        AirlineRandomer airlineReader = new AirlineRandomer(random, flightReader);
        AirlineApp1 airlineApp = new AirlineApp1 (scanner, airlineReader);

        airlineApp.run();
    }
}
