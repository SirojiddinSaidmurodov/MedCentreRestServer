package edu.keepeasy.com.medcenter.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Couldn't find department with id" + id);
    }
}
