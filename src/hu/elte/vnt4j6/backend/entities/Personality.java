/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.entities;

/**
 *
 * @author lcsoka
 */
public class Personality {
    private long personalityId;
    private String personalityName;

    public long getPersonalityId() {
        return personalityId;
    }

    public void setPersonalityId(long personalityId) {
        this.personalityId = personalityId;
    }
    
    public String getPersonalityName() {
        return personalityName;
    }

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName;
    }
    
    public Object[] toArray() {
        String[] array = {personalityId+"", personalityName};
        return array;
    }
}
