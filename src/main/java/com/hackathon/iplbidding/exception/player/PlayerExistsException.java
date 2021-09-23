package com.hackathon.iplbidding.exception.player;

import com.hackathon.iplbidding.exception.GeneralException;

public class PlayerExistsException extends GeneralException {
    public PlayerExistsException(final String playerId) {
        super("Player with name: " + playerId + " already exists");
    }
}
