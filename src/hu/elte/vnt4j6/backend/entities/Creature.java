/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.entities;

import java.util.Date;

/**
 *
 * @author lcsoka
 */
public class Creature {
    private Date firstMetDate;
    private String name;
    private String personality;

    public Date getFirstMetDate() {
        return firstMetDate;
    }

    public void setFirstMetDate(Date firstMetDate) {
        this.firstMetDate = firstMetDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }
    
}
