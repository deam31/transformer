/**
 * Deam
 * 03/2021
 */

package com.aequilibrium.transformer.service.dto;

import java.io.Serializable;
import java.util.Objects;

public abstract class IdDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdDTO idDTO = (IdDTO) o;
        return Objects.equals(id, idDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "IdDTO{" +
                "id=" + id +
                '}';
    }
}
