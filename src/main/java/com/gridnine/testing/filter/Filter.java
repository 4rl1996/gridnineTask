package com.gridnine.testing.filter;

import com.gridnine.testing.defaultValues.Flight;
import com.gridnine.testing.defaultValues.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public enum Filter {
    departBeforeCurrentTime {
        public List<Flight> flightFilter(List<Flight> flightList) {
            List<Flight> listForConsolePrint = new ArrayList<>();
            flightList.forEach(flight -> flight.getSegments().
                    stream()
                    .limit(1)
                    .filter(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
                    .limit(1)
                    .forEach(segment -> listForConsolePrint.add(flight)));
            return listForConsolePrint;
        }
    }, arriveBeforeDepart {
        public List<Flight> flightFilter(List<Flight> flightList) {
            List<Flight> listForConsolePrint = new ArrayList<>();
            flightList.forEach(flight -> flight.getSegments()
                    .stream()
                    .limit(1)
                    .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()))
                    .forEach(segment -> listForConsolePrint.add(flight)));
            return listForConsolePrint;
        }
    }, moreThanTwoHoursGround {
        public List<Flight> flightFilter(List<Flight> flightList) {
            List<Flight> listForConsolePrint = new ArrayList<>();
            List<Segment> segmentList = new ArrayList<>();
            LocalDateTime arrivalTime;
            LocalDateTime departureTime;
            Long groundTime = 0L;
            for (Flight flight : flightList) {
                segmentList.addAll(flight.getSegments());
                if (segmentList.size() > 1) {
                    for (int i = 0; i < segmentList.size() - 1; i++) {
                       arrivalTime = segmentList.get(i).getArrivalDate();
                       departureTime = segmentList.get(i + 1).getDepartureDate();
                       groundTime += ChronoUnit.HOURS.between(arrivalTime, departureTime);
                       }
                    if (groundTime < 2L) {
                        listForConsolePrint.add(flight);
                    }
                } else
                {
                    listForConsolePrint.add(flight);
                }
                segmentList.clear();
                groundTime = 0L;
            }
            return listForConsolePrint;
        }
    };
    public abstract List<Flight> flightFilter(List<Flight> flightList);
}

