/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimbledon.entity;

/**
 *
 * @author vrg
 */
public class Court {
    private String name;

    public Court() {
    }

    
    public Court(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Court{" + "name=" + name + '}';
    }
    
    
}
