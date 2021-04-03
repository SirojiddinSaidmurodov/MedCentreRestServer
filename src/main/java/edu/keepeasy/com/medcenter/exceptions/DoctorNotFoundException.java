package edu.keepeasy.com.medcenter.exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(Long id) {
        super("Couldn't find doctor with id" + id);
    }
}
