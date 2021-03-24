/**
 * Deam
 * 03/2021
 */
package com.aequilibrium.transformer.domain.enumeration;

public enum TransformerType {
    AUTOBOT, DECEPTICON;

    public TransformerType opposite() {
        switch(this) {
            case AUTOBOT: return TransformerType.DECEPTICON;
            case DECEPTICON: return TransformerType.AUTOBOT;
            default: throw new IllegalStateException(this + " no opposite found.");
        }
    }
}
