package com.hackathon.iplbidding.controller;

import com.hackathon.iplbidding.domain.Bidder;
import com.hackathon.iplbidding.exception.bidder.BidderDoesNotExistException;
import com.hackathon.iplbidding.exception.bidder.BidderExistsException;
import com.hackathon.iplbidding.service.bidder.IBidderService;
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
@RequestMapping("/bidder")
public class BidderController {
    @Autowired
    private final IBidderService bidderService;

    @PostMapping
    public Bidder addBidder(@RequestBody final Bidder bidder) {
        try {
            return bidderService.addBidder(bidder);
        } catch (BidderExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/all")
    public List<Bidder> getAllBidders() {
        return bidderService.getAllBidders();
    }

    @GetMapping
    public Optional<Bidder> getBidder(@RequestParam("id") final String bidderId) throws BidderDoesNotExistException {
        Optional<Bidder> optionalBidder = bidderService.getBidder(bidderId);
        if(optionalBidder.isEmpty())
            throw new BidderDoesNotExistException(bidderId);
        return optionalBidder;
    }

    @PutMapping
    public Bidder updateBidder(@RequestBody final Bidder bidder) {
        try {
            return bidderService.updateBidder(bidder);
        } catch (BidderDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @DeleteMapping
    public void deleteBidder(@RequestParam("id") final String bidderId) {
        try {
            bidderService.deleteBidder(bidderId);
        } catch (BidderDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }
}
