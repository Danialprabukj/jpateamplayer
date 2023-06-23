package com.kgisl.jpateamplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamPlayerService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public TeamPlayerService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Transactional
    public void createTeamsAndPlayers() {
        Player player1 = new Player("John Doe");
        Player player2 = new Player("Jane Smith");
        Player player3 = new Player("Mike Johnson");

        Team team1 = new Team("Team A");
        Team team2 = new Team("Team B");

        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team2.addPlayer(player2);
        team2.addPlayer(player3);

        teamRepository.save(team1);
        teamRepository.save(team2);
    }
}
