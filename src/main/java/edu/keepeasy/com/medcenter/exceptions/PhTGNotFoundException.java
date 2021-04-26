package edu.keepeasy.com.medcenter.exceptions;

public class PhTGNotFoundException extends RuntimeException {
    public PhTGNotFoundException(Long id) {
        super("Couldn't find PhTG with id" + id);
    }}