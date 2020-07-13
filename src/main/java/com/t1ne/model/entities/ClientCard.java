package com.t1ne.model.entities;

import com.t1ne.model.enums.ABONEMENT_TYPE;

import java.util.Calendar;
import java.util.Date;

public class ClientCard {
    private static int counter = 0;
    private int cardId;
    private ABONEMENT_TYPE abonementType;
    private Date dueDate;

    public ClientCard() {
        this.cardId = counter++;
    }

    public void setAbonement(ABONEMENT_TYPE abonementType) {
        Calendar cal = Calendar.getInstance();
        switch (abonementType) {
            case MONTHLY:
                cal.add(Calendar.MONTH, 1);
                break;
            case HALF_YEAR:
                cal.add(Calendar.MONTH, 6);
                break;
            case YEARLY:
                cal.add(Calendar.YEAR, 1);
                break;
        }
        dueDate = cal.getTime();
    }

    public Date getDueDate() {
        return dueDate;
    }
}
