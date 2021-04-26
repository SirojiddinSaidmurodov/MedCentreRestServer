package edu.keepeasy.com.medcenter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Medicament implements Serializable {

    private Long id;
    private String name;
    private String composition;
    @ManyToOne
    private PhTG ph_group;
    private String indications;
    private String contraindications; // противопоказания
    private String dosage;
    private String side_effects;
    private String overdose;
    private int count;

    public Medicament() {
    }

    public Medicament(String name, String composition, PhTG ph_group, String indications, String contraindications, String dosage, String side_effects, String overdose,int count) {
        this.name = name;
        this.composition = composition;
        this.ph_group = ph_group;
        this.indications = indications;
        this.contraindications = contraindications;
        this.dosage = dosage;
        this.side_effects = side_effects;
        this.overdose = overdose;
        this.count =count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public PhTG getPh_group() {
        return ph_group;
    }

    public void setPh_group(PhTG group) {
        this.ph_group = group;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(String side_effects) {
        this.side_effects = side_effects;
    }

    public String getOverdose() {
        return overdose;
    }

    public void setOverdose(String overdose) {
        this.overdose = overdose;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void copy(Medicament medicament) {
        this.id = medicament.id;
        this.name = medicament.name;
        this.composition = medicament.composition;
        this.ph_group = medicament.ph_group;
        this.indications = medicament.indications;
        this.contraindications = medicament.contraindications;
        this.dosage = medicament.dosage;
        this.side_effects = medicament.side_effects;
        this.overdose = medicament.overdose;
        this.count = medicament.count;
    }
}
