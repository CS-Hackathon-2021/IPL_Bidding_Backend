package com.hackathon.iplbidding.controller;

import com.hackathon.iplbidding.domain.Player;
import com.hackathon.iplbidding.exception.player.PlayerDoesNotExistException;
import com.hackathon.iplbidding.exception.player.PlayerExistsException;
import com.hackathon.iplbidding.service.player.IPlayerService;
import com.hackathon.iplbidding.service.player.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private final IPlayerService playerService;

    @PostMapping
    public Player addPlayer(@RequestBody final Player player) {
        try {
            return playerService.addPlayer(player);
        } catch (PlayerExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping
    public Optional<Player> getPlayer(@RequestParam("id") final String playerId) throws PlayerDoesNotExistException {
        Optional<Player> optionalPlayer = playerService.getPlayer(playerId);
        if(optionalPlayer.isEmpty())
            throw new PlayerDoesNotExistException(playerId);
        return optionalPlayer;
    }

    @PutMapping
    public Player updatePlayer(@RequestBody final Player player) {
        try {
            return playerService.updatePlayer(player);
        } catch (PlayerDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping
    public void deletePlayer(@RequestParam("id") final String playerId) {
        try {
            playerService.deletePlayer(playerId);
        } catch (PlayerDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }


}
