package com.hackathon.iplbidding.exception.biddingSession;

import com.hackathon.iplbidding.exception.GeneralException;

public class BiddingSessionExistsException extends GeneralException {
    public BiddingSessionExistsException(final String id) {
        super("Bidding Session with id: " + id + " already exists");
    }
}
