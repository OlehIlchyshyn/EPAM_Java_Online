package com.t1ne.model.users;

import com.t1ne.model.entities.ClientCard;

public class Client {
    private static int counter = 0;
    private int clientId;
    private String name;
    private ClientCard clientCard;

    public Client(String name) {
        this.clientId = counter++;
        this.name = name;
    }

    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public ClientCard getClientCard() {
        return clientCard;
    }

    public void setClientCard(ClientCard clientCard) {
        this.clientCard = clientCard;
    }
}
