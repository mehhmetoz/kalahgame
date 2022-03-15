package com.bol.kalah.service;

import com.bol.kalah.dto.GamePlayResponse;
import com.bol.kalah.dto.GameResponse;
import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameServiceTest extends TestCase {

    private final GameService gameService = new GameService();

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testCreateGame() {
        GameResponse gameResponse = gameService.createGame();
        assertThat(gameResponse).isNotNull();

    }

    @Test
    public void testPlay() {
        GameResponse gameResponse = gameService.createGame();
        GamePlayResponse gamePlayResponse = gameService.play(gameResponse.getId(), 5);
        assertThat(gamePlayResponse.getStatus().get(5)).isEqualTo("0");
    }
}