/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.service.mapper;

public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
}