package com.gridnine.testing;


import com.gridnine.testing.defaultValues.FlightBuilder;
import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.filterInterfaceImpl.FlightFilterImpl;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Filter f;

        while (true) {
            try {
                String filterParam = input.next();
                if (filterParam.equals("exit")) {
                    exit(0);
                    return;
                } else {
                    f = Filter.valueOf(filterParam);
                    FlightFilterImpl impl = new FlightFilterImpl(f);
                    System.out.println(FlightBuilder.createFlights());
                    System.out.println("\n\n");
                    System.out.println(impl.flightsFilter());
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
