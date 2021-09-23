package com.hackathon.iplbidding.service.player;

import com.hackathon.iplbidding.domain.Player;
import com.hackathon.iplbidding.exception.player.PlayerDoesNotExistException;
import com.hackathon.iplbidding.exception.player.PlayerExistsException;
import com.hackathon.iplbidding.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PlayerService implements IPlayerService{
    private final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    private final PlayerRepository playerRepository;

    @Override
    public Player addPlayer(Player player) throws PlayerExistsException {
        Optional<Player> playerOptional = getPlayer(player.getId());
        if(playerOptional.isPresent()) {
            throw new PlayerExistsException(player.getId());
        }
        Player addedPlayer = playerRepository.insert(player);
        logger.info("Player with id {} has been added", player.getId());
        return addedPlayer;
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> playersList = new ArrayList<>(playerRepository
                .findAll());
        logger.info("All Players are being collected and sent");
        return new ArrayList<>(playersList);
    }

    @Override
    public Player updatePlayer(Player player) throws PlayerDoesNotExistException {
        Optional<Player> playerOptional = getPlayer(player.getId());
        if(playerOptional.isEmpty()) {
            throw new PlayerDoesNotExistException(player.getId());
        }
        player.setId(playerOptional.get().getId());
        Player updatedPlayer = playerRepository.save(player);
        logger.info("Player with id {} has been updated", player.getId());
        return updatedPlayer;
    }

    @Override
    public void deletePlayer(String id) throws PlayerDoesNotExistException {
        Optional<Player> playerOptional = getPlayer(id);
        if(playerOptional.isEmpty()) {
            throw new PlayerDoesNotExistException(id);
        }
        playerRepository.deleteById(id);
        logger.info("Player with id {} has been deleted", id);
    }
}
