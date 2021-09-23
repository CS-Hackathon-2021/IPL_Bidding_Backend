package com.hackathon.iplbidding.repository;

import com.hackathon.iplbidding.domain.BiddingSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingSessionRepository extends MongoRepository<BiddingSession, String> {
}
