/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service.mapper;

import com.aequilibrium.transformer.domain.Transformer;
import com.aequilibrium.transformer.service.dto.TransformerDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface TransformerMapper extends EntityMapper<TransformerDTO, Transformer> {
}
