package com.gridnine.testing.defaultValues;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Bean that represents a flight segment.
 */
public class Segment {

    private LocalDateTime departureDate;

    private LocalDateTime arrivalDate;

    private Long id;

    private Flight flight;

    public Segment(LocalDateTime dep, LocalDateTime arr) {
        this.departureDate = Objects.requireNonNull(dep);
        this.arrivalDate = Objects.requireNonNull(arr);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
