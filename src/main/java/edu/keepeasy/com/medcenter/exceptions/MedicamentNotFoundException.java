package edu.keepeasy.com.medcenter.exceptions;

public class MedicamentNotFoundException extends RuntimeException {
    public MedicamentNotFoundException(Long id) {
        super("Couldn't find medicament with id" + id);
    }
}