package edu.keepeasy.com.medcenter.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id) {
        super("Couldn't find record with id" + id);
    }
}
