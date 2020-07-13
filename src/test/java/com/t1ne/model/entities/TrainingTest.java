package com.t1ne.model.entities;

import com.t1ne.model.users.Client;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    @Test
    void getSetAssignedClient() {
        Training training = new Training(Calendar.getInstance().getTime());
        Client client = new Client("Test");
        training.assignClient(client);
        assertEquals(client, training.getAssignedClient());
    }
}