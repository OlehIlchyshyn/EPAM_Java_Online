package com.t1ne.model.entities;

import com.t1ne.model.users.Client;

import java.util.Date;

public class Training {
    private static int counter = 0;
    private int trainingId;
    private Date date;
    private Client assignedClient;

    public Training(Date date) {
        this.trainingId = counter++;
        this.date = date;
    }

    public Date getTrainingDate() {
        return date;
    }

    public void assignClient(Client client) {
        this.assignedClient = client;
    }

    public Client getAssignedClient() {
        return this.assignedClient;
    }
}

