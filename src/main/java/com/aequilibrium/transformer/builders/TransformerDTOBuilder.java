/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.builders;

import com.aequilibrium.transformer.domain.enumeration.TransformerType;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import com.aequilibrium.transformer.util.AbstractBuilder;

public final class TransformerDTOBuilder extends AbstractBuilder<TransformerDTO> {

    private TransformerDTO transformerDTO;

    private TransformerDTOBuilder(){
        transformerDTO = new TransformerDTO();
    }

    public static TransformerDTOBuilder builder() {
        return new TransformerDTOBuilder();
    }

    public TransformerDTOBuilder withId(final Long id) {
        transformerDTO.setId(id);
        return this;
    }

    public TransformerDTOBuilder withStrength(final int strength) {
        transformerDTO.setStrength(strength);
        return this;
    }

    public TransformerDTOBuilder withIntelligence(final int intelligence) {
        transformerDTO.setIntelligence(intelligence);
        return this;
    }

    public TransformerDTOBuilder withSpeed(final int speed) {
        transformerDTO.setSpeed(speed);
        return this;
    }

    public TransformerDTOBuilder withEndurance(final int endurance) {
        transformerDTO.setEndurance(endurance);
        return this;
    }

    public TransformerDTOBuilder withRank(final int rank) {
        transformerDTO.setRank(rank);
        return this;
    }

    public TransformerDTOBuilder withCourage(final int courage) {
        transformerDTO.setCourage(courage);
        return this;
    }

    public TransformerDTOBuilder withFirePower(final int firePower) {
        transformerDTO.setFirepower(firePower);
        return this;
    }

    public TransformerDTOBuilder withType(final TransformerType type) {
        transformerDTO.setType(type);
        return this;
    }

    public TransformerDTOBuilder withName(final String name) {
        transformerDTO.setName(name);
        return this;
    }

    public TransformerDTOBuilder withSkill(final int skill) {
        transformerDTO.setSkill(skill);
        return this;
    }


    @Override
    public TransformerDTO build() {
        return transformerDTO;
    }
}