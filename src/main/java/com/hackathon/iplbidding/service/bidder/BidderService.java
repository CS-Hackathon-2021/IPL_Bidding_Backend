package com.hackathon.iplbidding.service.bidder;

import com.hackathon.iplbidding.domain.Bidder;
import com.hackathon.iplbidding.exception.bidder.BidderDoesNotExistException;
import com.hackathon.iplbidding.exception.bidder.BidderExistsException;
import com.hackathon.iplbidding.repository.BidderRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BidderService implements IBidderService{
    private final Logger logger = LoggerFactory.getLogger(BidderService.class);

    @Autowired
    private final BidderRepository bidderRepository;


    @Override
    public Bidder addBidder(Bidder bidder) throws BidderExistsException {
        Optional<Bidder> bidderOptional = getBidder(bidder.getId());
        if(bidderOptional.isPresent()) {
            throw new BidderExistsException(bidder.getId());
        }
        Bidder addedBidder = bidderRepository.insert(bidder);
        logger.info("Bidder with id {} has been added", bidder.getId());
        return addedBidder;
    }

    @Override
    public Optional<Bidder> getBidder(String id) {
        return bidderRepository.findById(id);
    }

    @Override
    public List<Bidder> getAllBidders() {
        List<Bidder> biddersList = new ArrayList<>(bidderRepository
                .findAll());
        logger.info("All Bidders are being collected and sent");
        return new ArrayList<>(biddersList);
    }

    @Override
    public Bidder updateBidder(Bidder bidder) throws BidderDoesNotExistException {
        Optional<Bidder> bidderOptional = getBidder(bidder.getId());
        if(bidderOptional.isEmpty()) {
            throw new BidderDoesNotExistException(bidder.getId());
        }
        bidder.setId(bidderOptional.get().getId());
        Bidder updatedBidder = bidderRepository.save(bidder);
        logger.info("Bidder with id {} has been updated", bidder.getId());
        return updatedBidder;
    }

    @Override
    public void deleteBidder(String id) throws BidderDoesNotExistException {
        Optional<Bidder> bidderOptional = getBidder(id);
        if(bidderOptional.isEmpty()) {
            throw new BidderDoesNotExistException(id);
        }
        bidderRepository.deleteById(id);
        logger.info("Bidder with id {} has been deleted", id);
    }
}
