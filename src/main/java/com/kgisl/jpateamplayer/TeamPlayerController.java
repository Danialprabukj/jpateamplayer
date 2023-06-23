package com.kgisl.jpateamplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamPlayerController {
    private final TeamPlayerService teamPlayerService;
    private final TeamRepository teamRepository;

    @Autowired
    public TeamPlayerController(TeamPlayerService teamPlayerService, TeamRepository teamRepository) {
        this.teamPlayerService = teamPlayerService;
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public void createTeamsAndPlayers() {
        teamPlayerService.createTeamsAndPlayers();
    }

   @GetMapping("/{teamName}/players")
public ResponseEntity<List<Player>> getPlayersByTeamName(@PathVariable("teamName") String teamName) {
    List<Team> teams = teamRepository.findAllByTeamName(teamName);
    if (!teams.isEmpty()) {
        List<Player> players = teams.get(0).getPlayers();
        return ResponseEntity.ok(players);
    } else {
        // Handle team not found
        return ResponseEntity.notFound().build();
    }
}

}
