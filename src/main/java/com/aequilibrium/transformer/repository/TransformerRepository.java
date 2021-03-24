/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.repository;

import com.aequilibrium.transformer.domain.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends JpaRepository<Transformer, Long>, JpaSpecificationExecutor<Transformer> {
}
