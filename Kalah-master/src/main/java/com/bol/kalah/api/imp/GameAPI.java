package com.bol.kalah.api.imp;

import com.bol.kalah.api.IGameAPI;
import com.bol.kalah.dto.GamePlayResponse;
import com.bol.kalah.dto.GameResponse;
import com.bol.kalah.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@RestController
public class GameAPI implements IGameAPI {

    @Autowired
    GameService service;

    @Override
    public ResponseEntity<GameResponse> createGame() {
        GameResponse gameResponse = service.createGame();
        return ResponseEntity.status(HttpStatus.CREATED).body(gameResponse);
    }


    @Override
    public ResponseEntity<GamePlayResponse> playGame(@PathVariable @Min(1) @Max(999) int gameId,
                                                     @PathVariable @Min(1) @Max(13) int pitId) {
        GamePlayResponse response = service.play(gameId, pitId);
        return ResponseEntity.ok(response);
    }
}
