/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.util;

import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.service.dto.BattleResultDTO;
import com.aequilibrium.transformer.service.dto.TransformerDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransformerBattleUtil {

    private static final short COURAGE_DELIMITER = 4;
    private static final short SKILL_DELIMITER = 3;
    private static final short STRENGTH_DELIMITER = 3;
    private static final List<String> LEADER_NAMES = Arrays.asList("Optimus Prime", "Predaking");

    public static BattleResultDTO performFaceOffBattle(final TransformerDTO t1, final TransformerDTO t2, BattleResultDTO result) {
        final boolean isBattleFinished = determineWinnerByName(t1, t2, result) ||
                determineWinnerByCourageStrength(t1, t2, result) ||
                determineWinnerBySkill(t1, t2, result);

        if (!isBattleFinished) {
            determineWinnerByRating(t1, t2, result);
        }
        return result;
    }


    public static Map.Entry<TransformerType, List<TransformerDTO>> determineWinnerTeam(final Map<TransformerType,
            List<TransformerDTO>> contenders) {
        return contenders.entrySet().stream()
                .max((team1, team2) -> team1.getValue().size() > team2.getValue().size() ? 1 : -1)
                .get();
    }


    private static boolean determineWinnerByCourageStrength(final TransformerDTO t1, final TransformerDTO t2, final BattleResultDTO result) {
        final int courageDownBy = Math.subtractExact(t1.getCourage(), t2.getCourage());
        final int strengthDownBy = Math.subtractExact(t1.getStrength(), t2.getStrength());
        boolean isBattleFinished = false;
        if (courageDownBy >= COURAGE_DELIMITER && strengthDownBy >= STRENGTH_DELIMITER) {
            isBattleFinished = result.getWinners().add(t1);
            result.getLoserSurvivorsRanAway().add(t2);
        } else if (courageDownBy <= -COURAGE_DELIMITER && strengthDownBy <= -STRENGTH_DELIMITER) {
            isBattleFinished = result.getWinners().add(t2);
            result.getLoserSurvivorsRanAway().add(t1);
        }
        return isBattleFinished;
    }

    private static boolean determineWinnerBySkill(final TransformerDTO t1, final TransformerDTO t2, final BattleResultDTO result) {
        final int contenderSkill = t1.getSkill();
        final int opponentSkill = t2.getSkill();
        boolean isBattleFinished = false;
        if (Math.subtractExact(contenderSkill, opponentSkill) >= SKILL_DELIMITER) {
            isBattleFinished = result.getWinners().add(t1);
        } else if (Math.subtractExact(opponentSkill, contenderSkill) >= SKILL_DELIMITER) {
            isBattleFinished = result.getWinners().add(t2);
        }
        return isBattleFinished;
    }

    private static boolean determineWinnerByName(final TransformerDTO t1, final TransformerDTO t2, final BattleResultDTO result) {
        final boolean t1IsLeader = LEADER_NAMES.contains(t1.getName());
        final boolean t2IsLeader = LEADER_NAMES.contains(t2.getName());
        boolean isBattleFinished = false;

        if (t1IsLeader && t2IsLeader) {
            result.setAllDestroyed(true);
            isBattleFinished = true;
        } else if (t1IsLeader) {
            isBattleFinished = result.getWinners().add(t1);
        } else if (t2IsLeader) {
            isBattleFinished = result.getWinners().add(t2);
        }
        return isBattleFinished;
    }

    private static void determineWinnerByRating(final TransformerDTO t1, final TransformerDTO t2, final BattleResultDTO result) {
        if (t1.getOverallRating() > t2.getOverallRating()) {
            result.getWinners().add(t1);
        } else if (t2.getOverallRating() > t1.getOverallRating()) {
            result.getWinners().add(t1);
        }
    }
}