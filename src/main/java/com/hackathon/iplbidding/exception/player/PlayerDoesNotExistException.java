package com.hackathon.iplbidding.exception.player;

import com.hackathon.iplbidding.exception.GeneralException;

public class PlayerDoesNotExistException extends GeneralException {
    public PlayerDoesNotExistException(String playerId) {
        super("Player with id: " + playerId + " does not exist");
    }
}
