package com.hackathon.iplbidding.service.biddingSession;

import com.hackathon.iplbidding.domain.BiddingSession;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionDoesNotExistException;
import com.hackathon.iplbidding.exception.biddingSession.BiddingSessionExistsException;
import com.hackathon.iplbidding.repository.BiddingSessionRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BiddingSessionService implements IBiddingSessionService {
    private final Logger logger = LoggerFactory.getLogger(BiddingSessionService.class);

    @Autowired
    private final BiddingSessionRepository biddingSessionRepository;

    @Override
    public BiddingSession addBiddingSession(BiddingSession biddingSession) throws BiddingSessionExistsException {
        Optional<BiddingSession> biddingSessionOptional = getBiddingSession(biddingSession.getId());
        if(biddingSessionOptional.isPresent()) {
            throw new BiddingSessionExistsException(biddingSession.getId());
        }
        BiddingSession addedBiddingSession = biddingSessionRepository.insert(biddingSession);
        logger.info("BiddingSession with id {} has been added", biddingSession.getId());
        return addedBiddingSession;
    }

    @Override
    public Optional<BiddingSession> getBiddingSession(String id) {
        return biddingSessionRepository.findById(id);
    }

    @Override
    public List<BiddingSession> getAllBiddingSessions() {
        List<BiddingSession> biddingSessionsList = new ArrayList<>(biddingSessionRepository
                .findAll());
        logger.info("All BiddingSessions are being collected and sent");
        return new ArrayList<>(biddingSessionsList);
    }

    @Override
    public BiddingSession updateBiddingSession(BiddingSession biddingSession) throws BiddingSessionDoesNotExistException {
        Optional<BiddingSession> biddingSessionOptional = getBiddingSession(biddingSession.getId());
        if(biddingSessionOptional.isEmpty()) {
            throw new BiddingSessionDoesNotExistException(biddingSession.getId());
        }
        biddingSession.setId(biddingSessionOptional.get().getId());
        BiddingSession updatedBiddingSession = biddingSessionRepository.save(biddingSession);
        logger.info("BiddingSession with id {} has been updated", biddingSession.getId());
        return updatedBiddingSession;
    }

    @Override
    public void deleteBiddingSession(String id) throws BiddingSessionDoesNotExistException {
        Optional<BiddingSession> biddingSessionOptional = getBiddingSession(id);
        if(biddingSessionOptional.isEmpty()) {
            throw new BiddingSessionDoesNotExistException(id);
        }
        biddingSessionRepository.deleteById(id);
        logger.info("BiddingSession with id {} has been deleted", id);
    }
}
