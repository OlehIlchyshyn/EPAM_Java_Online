package com.t1ne.model.entities;

import com.t1ne.model.enums.ABONEMENT_TYPE;
import org.junit.jupiter.api.Test;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class ClientCardTest {

    @Test
    void getSetAbonement() {
        ClientCard clientCard = new ClientCard();
        clientCard.setAbonement(ABONEMENT_TYPE.MONTHLY);
        Calendar currentDayPlusOneMonth = Calendar.getInstance();
        currentDayPlusOneMonth.add(Calendar.MONTH, 1);
        Calendar actualDueDate = Calendar.getInstance();
        actualDueDate.setTime(clientCard.getDueDate());
        assertEquals(currentDayPlusOneMonth.get(Calendar.YEAR), actualDueDate.get(Calendar.YEAR));
        assertEquals(currentDayPlusOneMonth.get(Calendar.DAY_OF_YEAR), actualDueDate.get(Calendar.DAY_OF_YEAR));

        clientCard.setAbonement(ABONEMENT_TYPE.HALF_YEAR);
        Calendar currentDayPlusHalfYear = Calendar.getInstance();
        currentDayPlusHalfYear.add(Calendar.MONTH, 6);
        actualDueDate.setTime(clientCard.getDueDate());
        assertEquals(currentDayPlusHalfYear.get(Calendar.YEAR), actualDueDate.get(Calendar.YEAR));
        assertEquals(currentDayPlusHalfYear.get(Calendar.DAY_OF_YEAR), actualDueDate.get(Calendar.DAY_OF_YEAR));

        clientCard.setAbonement(ABONEMENT_TYPE.YEARLY);
        Calendar currentDayPlusOneYear = Calendar.getInstance();
        currentDayPlusOneYear.add(Calendar.YEAR, 1);
        actualDueDate.setTime(clientCard.getDueDate());
        assertEquals(currentDayPlusOneYear.get(Calendar.YEAR), actualDueDate.get(Calendar.YEAR));
        assertEquals(currentDayPlusOneYear.get(Calendar.DAY_OF_YEAR), actualDueDate.get(Calendar.DAY_OF_YEAR));
    }
}