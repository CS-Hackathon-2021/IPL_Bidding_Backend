package com.hackathon.iplbidding.exception.bidder;

import com.hackathon.iplbidding.exception.GeneralException;

public class BidderExistsException extends GeneralException {
    public BidderExistsException(final String id) {
        super("Bidder with id: " + id + " already exists");
    }
}
