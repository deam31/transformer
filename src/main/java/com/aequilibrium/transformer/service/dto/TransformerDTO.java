/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service.dto;

import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import java.io.Serializable;
import java.util.Objects;

public class TransformerDTO extends IdDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int strength;

    private int intelligence;

    private int speed;

    private int endurance;

    private int rank;

    private int courage;

    private int firepower;

    private TransformerType type;

    private int skill;

    private boolean isWinner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSkill() {
        return this.skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getOverallRating() {
        return strength + intelligence + speed + endurance + firepower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TransformerDTO that = (TransformerDTO) o;
        return strength == that.strength && intelligence == that.intelligence && speed == that.speed &&
                endurance == that.endurance && rank == that.rank && courage == that.courage &&
                firepower == that.firepower && skill == that.skill && isWinner == that.isWinner
                && Objects.equals(name, that.name) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, strength, intelligence, speed, endurance, rank, courage, firepower, type, skill, isWinner);
    }

    @Override
    public String toString() {
        return "TransformerDTO{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                ", endurance=" + endurance +
                ", rank=" + rank +
                ", courage=" + courage +
                ", firepower=" + firepower +
                ", type=" + type +
                ", skill=" + skill +
                ", isWinner=" + isWinner +
                '}';
    }
}