/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimbledon.entity.player;

import wimbledon.entity.Gender;

/**
 *
 * @author vrg
 */
public class Player {
    private String name;
    private Gender gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", gender=" + gender + '}';
    }
    
    

}
