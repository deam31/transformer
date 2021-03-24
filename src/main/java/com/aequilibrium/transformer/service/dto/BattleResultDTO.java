/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BattleResultDTO implements Serializable {

    private int battles;
    private List<TransformerDTO> winners = new ArrayList<>();
    private List<TransformerDTO> loserSurvivorsRanAway = new ArrayList<>();
    private boolean allDestroyed = false;

    public int getBattles() {
        return battles;
    }

    public void setBattles(int battles) {
        this.battles = battles;
    }

    public List<TransformerDTO> getWinners() {
        return winners;
    }

    public void setWinners(List<TransformerDTO> winners) {
        this.winners = winners;
    }

    public boolean isAllDestroyed() {
        return allDestroyed;
    }

    public void setAllDestroyed(boolean allDestroyed) {
        this.allDestroyed = allDestroyed;
    }

    public List<TransformerDTO> getLoserSurvivorsRanAway() {
        return loserSurvivorsRanAway;
    }

    public void setLoserSurvivorsRanAway(List<TransformerDTO> loserSurvivorsRanAway) {
        this.loserSurvivorsRanAway = loserSurvivorsRanAway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BattleResultDTO that = (BattleResultDTO) o;
        return battles == that.battles && allDestroyed == that.allDestroyed &&
                Objects.equals(winners, that.winners) &&
                Objects.equals(loserSurvivorsRanAway, that.loserSurvivorsRanAway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(battles, winners, loserSurvivorsRanAway, allDestroyed);
    }

    @Override
    public String toString() {
        return "BattleResultDTO{" +
                "battles=" + battles +
                ", winners=" + winners +
                ", loserSurvivorsRanAway=" + loserSurvivorsRanAway +
                ", allDestroyed=" + allDestroyed +
                '}';
    }
}