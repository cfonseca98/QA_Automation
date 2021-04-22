package com.shoptest.exceptions;

public class AssertionsReservation extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String NOFOUNDELEMENT = "El elemento a verificar no es visible";

    public AssertionsReservation(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsReservation(String message) {
        super(message);
    }


}
