package com.hackathon.iplbidding.exception.biddingSession;

import com.hackathon.iplbidding.exception.GeneralException;

public class BiddingSessionDoesNotExistException extends GeneralException {
    public BiddingSessionDoesNotExistException(String id) {
        super("Bidding Session with id: " + id + " does not exist");
    }
}
