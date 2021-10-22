package com.gridnine.testing.filterInterfaceImpl;

import com.gridnine.testing.defaultValues.Flight;
import com.gridnine.testing.defaultValues.FlightBuilder;
import com.gridnine.testing.filterInterface.FlightFilter;
import com.gridnine.testing.filter.Filter;

import java.util.List;

public class FlightFilterImpl implements FlightFilter {

    private List<Flight> flights = FlightBuilder.createFlights();
    private final Filter filter;


    public FlightFilterImpl(Filter filter) {
        this.filter = filter;
    }

    @Override
    public List<Flight> flightsFilter() {
        this.flights = flights;
        return filter.flightFilter(flights);
    }
}
