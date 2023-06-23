package com.kgisl.jpateamplayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    // @Query("SELECT p FROM Team t JOIN t.players p WHERE t.teamName = :teamName")
    // List<Player> findPlayersByTeamName(@Param("teamName") String teamName);

    Team findByTeamName(String teamName);

    List<Team> findAllByTeamName(String teamName);
}
