package com.intuit.player.controller;

import com.intuit.player.util.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureHttpGraphQlTester
@ActiveProfiles("test")
class PlayerGraphQLControllerIT {
    @Autowired
    private HttpGraphQlTester httpGraphQlTester;

    @Test
    public void testPlayerById() {
        String expectedJson = Utils.readFileToString("classpath:jsons/players/gql_playerById.json");

        httpGraphQlTester.document("""
                query findPlayerById{
                  playerById(playerId: "aardsda01") {
                    nameLast
                    nameFirst
                    nameGiven
                    finalGame
                    bats:batsHand
                  }
                }
                """).execute()
                .errors()
                .verify()
                .path("playerById")
                .matchesJson(expectedJson);
    }

    @Test
    public void testPlayersNoArgs() {
        String expectedJson = Utils.readFileToString("classpath:jsons/players/gql_players_no_args.json");
        httpGraphQlTester.document("""
                query findPlayers{
                  players {
                    players{
                        nameLast
                        nameFirst
                        nameGiven
                        finalGame
                    }
                    totalPages
                    currentPage
                    currentPageSize
                    totalElements
                  }
                }
                """).execute()
                .errors()
                .verify()
                .path("players")
                .matchesJson(expectedJson);
    }

    @Test
    public void testPlayersArgs() {
        String expectedJson = Utils.readFileToString("classpath:jsons/players/gql_players_args.json");
        httpGraphQlTester.document("""
                query findPlayers{
                  players(limit:3, page:1, sortCols:["birthYear"], desc:true) {
                    players{
                        nameLast
                        nameFirst
                        nameGiven
                        finalGame
                    }
                    totalPages
                    currentPage
                    currentPageSize
                    totalElements
                  }
                }
                """).execute()
                .errors()
                .verify()
                .path("players")
                .matchesJson(expectedJson);
    }
}