package edu.keepeasy.com.medcenter.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long id) {
        super("Couldn't find patient with id" + id);
    }
}
