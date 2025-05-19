package com.example.hotel.Models;

public class Reclamation {
    private String mail, message, objet;

    public Reclamation(String mail, String message, String objetA) {
        this.mail = mail;
        this.message = message;
        this.objet = objet;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }
}