/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.util;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aequilibrium.transformer.builders.TransformerDTOBuilder;
import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.service.dto.BattleResultDTO;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class TransformerBattleUtilTest {

    @Test
    void testFaceOffBattleShouldWinByCourageStrength(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Skywarp")
                .withCourage(5)
                .withStrength(4)
                .build();
        expected.setWinners(Lists.newArrayList(winner));

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Cliffjumper")
                .withCourage(1)
                .withStrength(1)
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void testFaceOffBattleShouldWinByCourageStrengthOpposite(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Skywarp")
                .withCourage(5)
                .withStrength(4)
                .build();
        expected.setWinners(Lists.newArrayList(winner));

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Cliffjumper")
                .withCourage(1)
                .withStrength(1)
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(loser, winner, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void testFaceOffBattleShouldWinBySkill(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Wheeljack")
                .withSkill(10)
                .build();
        expected.setWinners(Lists.newArrayList(winner));

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Cliffjumper")
                .withSkill(8)
                .withCourage(2)
                .withStrength(2)
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void testFaceOffBattleShouldWinByOverallRating(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Starscream")
                .withStrength(8)
                .withIntelligence(8)
                .withSpeed(8)
                .withEndurance(8)
                .withFirePower(8)
                .build();
        expected.setWinners(Lists.newArrayList(winner));

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Prowl")
                .withStrength(7)
                .withIntelligence(7)
                .withSpeed(7)
                .withEndurance(7)
                .withFirePower(7)
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void testFaceOffBattleShouldHaveNoWinnerIfTie(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Thundercracker")
                .build();

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Jazz")
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void performFaceOffBattleShouldWinAutobotsByName() {
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Optimus Prime")
                .build();
        ArrayList<TransformerDTO> winners = Lists.newArrayList(winner);
        expected.setWinners(winners);

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Shockwave")
                .withRank(10)
                .withSkill(10)
                .withCourage(10)
                .withStrength(10)
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }

    @Test
    void testFaceOffBattleShouldEndIfLeadersMatch(){
        BattleResultDTO expected = new BattleResultDTO();
        TransformerDTO winner = TransformerDTOBuilder.builder()
                .withType(TransformerType.DECEPTICON)
                .withName("Predaking")
                .build();
        expected.setAllDestroyed(true);

        TransformerDTO loser = TransformerDTOBuilder.builder()
                .withType(TransformerType.AUTOBOT)
                .withName("Optimus Prime")
                .build();

        BattleResultDTO actual = TransformerBattleUtil.performFaceOffBattle(winner, loser, new BattleResultDTO());

        assertIterableEquals(expected.getWinners(), actual.getWinners());
        assertEquals(expected.isAllDestroyed(), actual.isAllDestroyed());
    }
}