package com.intuit.player.controller;

import com.intuit.player.util.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PlayerControllerApiIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PlayerController playerController;

    @Test
    void getPlayerById() throws Exception {
        String playerId = "aardsda01";
        String expectedJsonResp = Utils.readFileToString("classpath:jsons/players/getPlayerById.json");

        RequestBuilder request = get("/api/players/" + playerId);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonResp));
    }

    @Test
    void getPlayerByIdWithNoExistId() throws Exception {
        String playerId = "xxxxxxx";
        String expectedJsonResp = Utils.readFileToString("classpath:jsons/players/getPlayerById_Invalid_Id.json");

        RequestBuilder request = get("/api/players/" + playerId);
        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expectedJsonResp));
    }

    @Test
    void getAllPlayers() throws Exception {
        String page1Resp = Utils.readFileToString("classpath:jsons/players/getAllPlayers_Page1.json");
        RequestBuilder requestPage1 = get("/api/players")
                .param("page", "0")
                .param("limit", "3")
                .param("sortCols", "birthYear")
                .param("desc", "true");
        mvc.perform(requestPage1)
                .andExpect(status().isOk())
                .andExpect(content().json(page1Resp));

        String page2Resp = Utils.readFileToString("classpath:jsons/players/getAllPlayers_Page2.json");
        RequestBuilder requestPage2 = get("/api/players")
                .param("page", "1")
                .param("limit", "3")
                .param("sortCols", "birthYear")
                .param("desc", "true");
        mvc.perform(requestPage2)
                .andExpect(status().isOk())
                .andExpect(content().json(page2Resp));
    }


}