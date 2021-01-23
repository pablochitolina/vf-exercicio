package org.pablochitolina.exercicio.domain.exception;

public class BusRouteNotFoundException extends RuntimeException {

    public BusRouteNotFoundException(Long id) {
        super("Bus Route not found!");
    }
}
