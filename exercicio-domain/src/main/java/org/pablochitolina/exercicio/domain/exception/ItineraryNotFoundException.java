package org.pablochitolina.exercicio.domain.exception;

public class ItineraryNotFoundException extends RuntimeException {

    public ItineraryNotFoundException(Long id) {
        super("Itinerary not found!");
    }
}
