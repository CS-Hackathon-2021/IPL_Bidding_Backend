package com.hackathon.iplbidding.service.player;

import com.hackathon.iplbidding.domain.Player;
import com.hackathon.iplbidding.exception.player.PlayerDoesNotExistException;
import com.hackathon.iplbidding.exception.player.PlayerExistsException;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {
    Player addPlayer(Player player) throws PlayerExistsException;
    Optional<Player> getPlayer(String id);
    List<Player> getAllPlayers();
    Player updatePlayer(Player player) throws PlayerDoesNotExistException;
    void deletePlayer(String id) throws PlayerDoesNotExistException;
}
