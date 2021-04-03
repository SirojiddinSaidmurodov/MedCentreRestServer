package edu.keepeasy.com.medcenter.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String patient_name;
    private String surname;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String passportNumber;
    private String workPlace;
    private int insuranceNumber;
    private String insuranceType;

    public Patient() {
    }

    public Patient(String patient_name, String surname, String patronymic, LocalDate dateOfBirth, String passportNumber, String workPlace, int insuranceNumber, String insuranceType) {
        this.patient_name = patient_name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.passportNumber = passportNumber;
        this.workPlace = workPlace;
        this.insuranceNumber = insuranceNumber;
        this.insuranceType = insuranceType;
    }

    public Patient copy(Patient newPatient) {
        this.patient_name = newPatient.patient_name;
        this.surname = newPatient.surname;
        this.patronymic = newPatient.patronymic;
        this.dateOfBirth = newPatient.dateOfBirth;
        this.passportNumber = newPatient.passportNumber;
        this.workPlace = newPatient.workPlace;
        this.insuranceNumber = newPatient.insuranceNumber;
        this.insuranceType = newPatient.insuranceType;
        return this;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
