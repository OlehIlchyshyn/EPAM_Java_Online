package com.t1ne.model.users;

import com.t1ne.model.entities.ClientCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTest {
    Client client;

    @BeforeEach
    public void createClient() {
        client = new Client("Oleh");
    }

    @Test
    public void getName() {
        assertEquals("Oleh", client.getName());
    }

    @Test
    public void getClientCard() {
        ClientCard clientCard = new ClientCard();
        client.setClientCard(clientCard);
        assertEquals(clientCard, client.getClientCard());
    }

    @Test
    public void setClientCard() {
        ClientCard clientCard = new ClientCard();
        client.setClientCard(clientCard);
        assertEquals(clientCard, client.getClientCard());
    }
}