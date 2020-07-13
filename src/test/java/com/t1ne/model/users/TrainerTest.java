package com.t1ne.model.users;

import com.t1ne.exceptions.NoTrainingAtGivenDateException;
import com.t1ne.exceptions.TrainingAlreadyExists;
import com.t1ne.model.entities.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    Trainer trainer;
    SimpleDateFormat formatter;

    @BeforeEach
    void setUp() {
        this.trainer = new Trainer("Oleh");
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Test
    void getName() {
        assertEquals("Oleh", trainer.getName());
    }

    @Test
    void addNewTrainingAtDesiredDate() throws ParseException, TrainingAlreadyExists {
        String dateStr = "12/12/2012";
        Date date = formatter.parse(dateStr);
        trainer.addNewTrainingAtDesiredDate(date, new Training(date));
        assertTrue(trainer.getSchedule().containsKey(date));
    }

    @Test
    void removeTrainingAtGivenDate() throws ParseException, TrainingAlreadyExists, NoTrainingAtGivenDateException {
        String dateStr = "12/12/1984";
        Date date = formatter.parse(dateStr);
        trainer.addNewTrainingAtDesiredDate(date, new Training(date));
        date = formatter.parse(dateStr);
        trainer.removeTrainingAtGivenDate(date);
        assertFalse(trainer.getSchedule().containsKey(date));
    }

    @Test
    void getSchedule() throws ParseException, TrainingAlreadyExists {
        String dateStr = "12/12/1984";
        Date date = formatter.parse(dateStr);
        trainer.addNewTrainingAtDesiredDate(date, new Training(date));
        assertNotNull(trainer.getSchedule().entrySet());
    }
}