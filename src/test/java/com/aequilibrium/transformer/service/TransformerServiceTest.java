/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.aequilibrium.transformer.domain.Transformer;
import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.repository.TransformerRepository;
import com.aequilibrium.transformer.service.mapper.TransformerMapper;
import com.aequilibrium.transformer.service.mapper.TransformerMapperImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;


class TransformerServiceTest {

    private TransformerService classUnderTest;

    @Mock
    private TransformerRepository mockedTransformerRepository;

    private TransformerMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapper = new TransformerMapperImpl();
        classUnderTest = new TransformerService(mockedTransformerRepository, mapper);
    }

    @Test
    void battleByCourageStrength(){
        when(mockedTransformerRepository.findAllById(any())).thenReturn(getTransformersCourageScenario());

        List<Long> ids = Arrays.asList(new Long(1), new Long(2));
        String actual = classUnderTest.battle(ids);

        assertEquals("1 battle(s). Winning team (AUTOBOT) Kup\n" +
                "Survivors from the losing team (DECEPTICON) Reflector", actual);
    }

    @Test
    void battleShouldInformCanNotBattle(){
        when(mockedTransformerRepository.findAllById(any())).thenReturn(Lists.emptyList());

        String actual = classUnderTest.battle(any());

        assertEquals("Can't battle. More than one team is required to battle.", actual);
    }

    @Test
    void battleShouldInformAllDestroyed(){
        when(mockedTransformerRepository.findAllById(any())).thenReturn(getTransformersLeaders());

        List<Long> ids = Arrays.asList(new Long(1), new Long(2));
        String actual = classUnderTest.battle(ids);

        assertEquals("All transformers are destroyed", actual);
    }

    private List<Transformer> getTransformersLeaders() {
        Transformer t1 = new Transformer();
        t1.setType(TransformerType.AUTOBOT);
        t1.setName("Optimus Prime");
        t1.setCourage(5);
        t1.setStrength(4);

        Transformer t2 = new Transformer();
        t2.setType(TransformerType.DECEPTICON);
        t2.setName("Predaking");
        t2.setCourage(1);
        t2.setStrength(1);
        return Arrays.asList(t1, t2);
    }


    private List<Transformer> getTransformersCourageScenario() {
        Transformer t1 = new Transformer();
        t1.setType(TransformerType.AUTOBOT);
        t1.setName("Kup");
        t1.setCourage(5);
        t1.setStrength(4);

        Transformer t2 = new Transformer();
        t2.setType(TransformerType.DECEPTICON);
        t2.setName("Reflector");
        t2.setCourage(1);
        t2.setStrength(1);
        return Arrays.asList(t1, t2);
    }
}