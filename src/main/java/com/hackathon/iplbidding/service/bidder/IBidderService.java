package com.hackathon.iplbidding.service.bidder;

import com.hackathon.iplbidding.domain.Bidder;
import com.hackathon.iplbidding.exception.bidder.BidderDoesNotExistException;
import com.hackathon.iplbidding.exception.bidder.BidderExistsException;

import java.util.List;
import java.util.Optional;

public interface IBidderService {
    Bidder addBidder(Bidder bidder) throws BidderExistsException;
    Optional<Bidder> getBidder(String id);
    List<Bidder> getAllBidders();
    Bidder updateBidder(Bidder bidder) throws BidderDoesNotExistException;
    void deleteBidder(String id) throws BidderDoesNotExistException;
}
