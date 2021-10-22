package com.gridnine.testing.defaultValues;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {

    private Long id;

    private List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    public Flight() {
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
