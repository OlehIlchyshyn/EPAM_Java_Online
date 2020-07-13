package com.t1ne.model.users;

import com.t1ne.exceptions.NoTrainingAtGivenDateException;
import com.t1ne.exceptions.TrainingAlreadyExists;
import com.t1ne.model.entities.Training;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Trainer {
    private static int counter = 0;
    private int trainerId;
    private String name;
    private Map<Date, Training> trainingsSchedule;

    public Trainer(String name) {
        this.trainerId = counter++;
        this.name = name;
        trainingsSchedule = new HashMap<>();
    }

    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public void addNewTrainingAtDesiredDate(Date date, Training training) throws TrainingAlreadyExists{
        if (trainingsSchedule.containsKey(date)) {
            throw new TrainingAlreadyExists();
        }
        trainingsSchedule.put(date, training);
    }

    public void removeTrainingAtGivenDate(Date date) throws NoTrainingAtGivenDateException{
        if (trainingsSchedule.containsKey(date)) {
            trainingsSchedule.remove(date);
        } else {
            throw new NoTrainingAtGivenDateException();
        }
    }

    public Map<Date, Training> getSchedule() {
        return trainingsSchedule;
    }
}
