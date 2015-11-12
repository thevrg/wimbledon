/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wimbledon.entity.team;

import wimbledon.entity.Gender;
import wimbledon.entity.player.Player;

/**
 *
 * @author vrg
 */
public class MixedDoublesTeam extends Team {

    @Override
    public Team create(Player player1, Player player2) throws IllegalArgumentException {
        MixedDoublesTeam team = new MixedDoublesTeam();
        if (player1.getGender() != Gender.FEMALE) {
            throw new IllegalArgumentException("Player1 is not a female");
        }
        if (player2.getGender() != Gender.MALE) {
            throw new IllegalArgumentException("Player2 is not a male");
        }
        this.player1 = player1;
        this.player2 = player2;
        return team;
    }

}
