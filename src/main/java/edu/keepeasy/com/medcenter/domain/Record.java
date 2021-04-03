package edu.keepeasy.com.medcenter.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Patient patient;
    private LocalDate created_at;
    @ManyToOne
    private Department department;
    private String content;

    public Record() {
    }

    public Record(Patient patient, LocalDate created_at, Department department, String content) {
        this.patient = patient;
        this.created_at = created_at;
        this.department = department;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
