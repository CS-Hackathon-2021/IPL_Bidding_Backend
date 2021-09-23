package com.hackathon.iplbidding.controller;

import com.hackathon.iplbidding.domain.BiddingSession;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionDoesNotExistException;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionExistsException;
import com.hackathon.iplbidding.service.biddingSession.IBiddingSessionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/biddingSession")
public class BiddingSessionController {
    @Autowired
    private final IBiddingSessionService biddingSessionService;

    @PostMapping
    public BiddingSession addBiddingSession(@RequestBody final BiddingSession biddingSession) {
        try {
            return biddingSessionService.addBiddingSession(biddingSession);
        } catch (BiddingSessionExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/all")
    public List<BiddingSession> getAllBiddingSessions() {
        return biddingSessionService.getAllBiddingSessions();
    }

    @GetMapping
    public Optional<BiddingSession> getBiddingSession(@RequestParam("id") final String biddingSessionId) throws BiddingSessionDoesNotExistException {
        Optional<BiddingSession> optionalBiddingSession = biddingSessionService.getBiddingSession(biddingSessionId);
        if(optionalBiddingSession.isEmpty())
            throw new BiddingSessionDoesNotExistException(biddingSessionId);
        return optionalBiddingSession;
    }

    @PutMapping
    public BiddingSession updateBiddingSession(@RequestBody final BiddingSession biddingSession) {
        try {
            return biddingSessionService.updateBiddingSession(biddingSession);
        } catch (BiddingSessionDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping
    public void deleteBiddingSession(@RequestParam("id") final String biddingSessionId) {
        try {
            biddingSessionService.deleteBiddingSession(biddingSessionId);
        } catch (BiddingSessionDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }
}
