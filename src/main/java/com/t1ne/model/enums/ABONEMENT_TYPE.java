package com.t1ne.model.enums;

public enum ABONEMENT_TYPE {
    MONTHLY("Monthly"), HALF_YEAR("Half-year"), YEARLY("Yearly");

    private final String abonementName;

    ABONEMENT_TYPE(String abonementName) {
        this.abonementName = abonementName;
    }

    @Override
    public String toString() {
        return this.abonementName;
    }
}
