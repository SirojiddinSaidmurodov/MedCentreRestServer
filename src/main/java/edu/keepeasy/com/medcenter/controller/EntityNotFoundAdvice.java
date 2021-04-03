package edu.keepeasy.com.medcenter.controller;

import edu.keepeasy.com.medcenter.exceptions.DepartmentNotFoundException;
import edu.keepeasy.com.medcenter.exceptions.DoctorNotFoundException;
import edu.keepeasy.com.medcenter.exceptions.PatientNotFoundException;
import edu.keepeasy.com.medcenter.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EntityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String patientNotFoundHandler(PatientNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departmentNotFoundHandler(DepartmentNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DoctorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String doctorNotFoundHandler(DoctorNotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String recordNotFoundHandler(RecordNotFoundException e) {
        return e.getMessage();
    }
}
