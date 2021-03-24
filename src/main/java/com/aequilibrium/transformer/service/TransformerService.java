/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service;

import com.aequilibrium.transformer.domain.Transformer;
import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.repository.TransformerRepository;
import com.aequilibrium.transformer.service.dto.BattleResultDTO;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import com.aequilibrium.transformer.service.mapper.TransformerMapper;
import com.aequilibrium.transformer.util.TransformerBattleUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class TransformerService {

    private final TransformerRepository transformerRepository;
    private final TransformerMapper transformerMapper;

    public TransformerService(TransformerRepository transformerRepository, TransformerMapper transformerMapper) {
        this.transformerRepository = transformerRepository;
        this.transformerMapper = transformerMapper;
    }

    public void createOrUpdate(TransformerDTO transformerDTO){
        Transformer transformer = transformerMapper.toEntity(transformerDTO);
        transformerRepository.save(transformer);
    }

    @Transactional(readOnly = true)
    public List<TransformerDTO> findAll() {
        return transformerRepository.findAll()
                .stream()
                .map(transformerMapper::toDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public void saveAll(List<TransformerDTO> transformersDTO) {
        List<Transformer> transformers = transformersDTO
                .stream()
                .map(transformerMapper::toEntity)
                .collect(toList());
        transformerRepository.saveAll(transformers);
        transformerRepository.flush();
    }

    public void deleteById(final long id) {
        transformerRepository.deleteById(id);
    }

    public String battle(List<Long> ids) {
        List<TransformerDTO> transformers = transformerRepository.findAllById(ids)
                .stream()
                .map(transformerMapper::toDto)
                .collect(toList());

        Map<TransformerType, List<TransformerDTO>> teams = transformers
                .stream()
                .sorted(Comparator.comparingInt(TransformerDTO::getRank).reversed())
                .collect(Collectors.groupingBy(TransformerDTO::getType));

        if (teams.size() > 1) {
            return initializeBattle(teams.get(TransformerType.AUTOBOT), teams.get(TransformerType.DECEPTICON));
        }
        return "Can't battle. More than one team is required to battle.";
    }


    private String initializeBattle(final List<TransformerDTO> autobots, final List<TransformerDTO> decepticons) {
        BattleResultDTO result = new BattleResultDTO();
        int battles = Math.min(autobots.size(), decepticons.size());
        int battlesCount = 0;
        do {
             TransformerBattleUtil.performFaceOffBattle(autobots.get(battlesCount), decepticons.get(battlesCount), result);
             battlesCount++;
        } while (!result.isAllDestroyed() && battlesCount < battles);

        return evaluateBattleResult(result, battles);
    }


    private String evaluateBattleResult(final BattleResultDTO result, final int battles) {
        result.setBattles(battles);

        // Transformers who won a battle 
        Map<TransformerType, List<TransformerDTO>> contenders = result.getWinners().stream()
                .collect(Collectors.groupingBy(TransformerDTO::getType));

        if (!contenders.isEmpty()) {
            // Determine winner team
            Map.Entry<TransformerType, List<TransformerDTO>> winnerTeam = TransformerBattleUtil.determineWinnerTeam(contenders);

            // Extract winner names
            String winnerNames = winnerTeam.getValue().stream()
                    .map(TransformerDTO::getName)
                    .collect(Collectors.joining(", "));


            // Determine surviving members of the loosing team
            TransformerType loserType = winnerTeam.getKey().opposite();
            Optional<List<TransformerDTO>> losersByBattleCombat = Optional.ofNullable(contenders.get(loserType));
            if (losersByBattleCombat.isPresent()) {
                result.getLoserSurvivorsRanAway().addAll(losersByBattleCombat.get());
            }
            String loserNames = result.getLoserSurvivorsRanAway().stream()
                    .map(TransformerDTO::getName)
                    .collect(Collectors.joining(", "));

            return getBattleResultAsHumanReadableText(battles, winnerTeam.getKey(), winnerNames, loserType, loserNames);
        }

        return "All transformers are destroyed";
    }


    private String getBattleResultAsHumanReadableText(final int battles, final TransformerType winner,
                                                     final String winnerNames, final TransformerType looser,
                                                     final String loserNames) {
        StringBuffer readableResult = new StringBuffer();
        readableResult.append(battles);
        readableResult.append(" battle(s). Winning team (");
        readableResult.append(winner.toString());
        readableResult.append(") ");
        readableResult.append(winnerNames);
        readableResult.append("\nSurvivors from the losing team (");
        readableResult.append(looser.toString());
        readableResult.append(") ");
        readableResult.append(loserNames);

        return readableResult.toString();
    }
}