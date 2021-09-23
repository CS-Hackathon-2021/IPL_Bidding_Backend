package com.hackathon.iplbidding.service.biddingSession;

import com.hackathon.iplbidding.domain.BiddingSession;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionDoesNotExistException;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionExistsException;

import java.util.List;
import java.util.Optional;

public interface IBiddingSessionService {
    BiddingSession addBiddingSession(BiddingSession biddingSession) throws BiddingSessionExistsException;
    Optional<BiddingSession> getBiddingSession(String id);
    List<BiddingSession> getAllBiddingSessions();
    BiddingSession updateBiddingSession(BiddingSession biddingSession) throws BiddingSessionDoesNotExistException;
    void deleteBiddingSession(String id) throws BiddingSessionDoesNotExistException;
}
