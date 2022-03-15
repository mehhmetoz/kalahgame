package com.bol.kalah.model;

import junit.framework.TestCase;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameEngineTest extends TestCase {

    private final Game game = new Game();

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testPlay() {
        assertThat(game).isNotNull();
    }

    @Test
    public void testGetHouses() {
        assertThat(game.getHouses().length).isEqualTo(14);
    }
}