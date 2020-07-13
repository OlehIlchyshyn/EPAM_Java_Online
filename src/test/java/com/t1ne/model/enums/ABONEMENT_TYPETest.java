package com.t1ne.model.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ABONEMENT_TYPETest {
    @Test
    void typeToString() {
        assertEquals("Monthly", ABONEMENT_TYPE.MONTHLY.toString());
        assertEquals("Half-year", ABONEMENT_TYPE.HALF_YEAR.toString());
        assertEquals("Yearly", ABONEMENT_TYPE.YEARLY.toString());
    }

}