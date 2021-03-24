package com.aequilibrium.transformer.domain;

import com.aequilibrium.transformer.domain.enumeration.TransformerType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Transformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "strength")
    private int strength;

    @Column(name = "intelligence")
    private int intelligence;

    @Column(name = "speed")
    private int speed;

    @Column(name = "endurance")
    private int endurance;

    @Column(name = "rank")
    private int rank;

    @Column(name = "courage")
    private int courage;

    @Column(name = "firepower")
    private int firepower;

    @Column(name = "type")
    private TransformerType type;

    @Column(name = "name")
    private String name;

    @Column(name = "skill")
    private String skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public TransformerType getType() {
        return type;
    }

    public void setType(TransformerType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transformer that = (Transformer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transformer{" +
                "id=" + id +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                ", endurance=" + endurance +
                ", rank=" + rank +
                ", courage=" + courage +
                ", firepower=" + firepower +
                '}';
    }
}
