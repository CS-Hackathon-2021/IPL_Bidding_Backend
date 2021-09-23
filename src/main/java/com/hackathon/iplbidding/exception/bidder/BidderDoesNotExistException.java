package com.hackathon.iplbidding.exception.bidder;

import com.hackathon.iplbidding.exception.GeneralException;

public class BidderDoesNotExistException extends GeneralException {
    public BidderDoesNotExistException(String id) {
        super("Bidder with id: " + id + " does not exist");
    }
}
