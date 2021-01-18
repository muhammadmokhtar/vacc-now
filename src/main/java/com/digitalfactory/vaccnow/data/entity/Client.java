package com.digitalfactory.vaccnow.data.entity;

import javax.persistence.*;

@Entity(name = "CLIENT")
public class Client {

    @Id
    @Column(name="CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;
    @Column
    private String name;
    @Column
    private String email;

    public Client() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
