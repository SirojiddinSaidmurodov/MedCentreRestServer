package edu.keepeasy.com.medcenter.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String specialization;
    @ManyToOne
    private Department department;

    public Doctor() {
    }

    public Doctor(String name, String surname, String patronymic, String specialization, Department department) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.specialization = specialization;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String doctor_name) {
        this.name = doctor_name;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void copy(Doctor newDoctor) {
        this.name = newDoctor.getName();
        this.surname = newDoctor.getSurname();
        this.patronymic = newDoctor.getPatronymic();
        this.specialization = newDoctor.getSpecialization();
        this.department = newDoctor.getDepartment();
    }
}
