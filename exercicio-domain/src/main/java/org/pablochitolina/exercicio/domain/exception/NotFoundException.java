package org.pablochitolina.exercicio.domain.exception;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super(MessageFormat.format("Entity with ID: {0} not found!", id));
    }
}
