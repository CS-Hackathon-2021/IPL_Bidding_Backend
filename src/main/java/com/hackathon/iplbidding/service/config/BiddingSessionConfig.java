package com.hackathon.iplbidding.service.config;

import com.hackathon.iplbidding.repository.BiddingSessionRepository;
import com.hackathon.iplbidding.service.biddingSession.BiddingSessionService;
import com.hackathon.iplbidding.service.biddingSession.IBiddingSessionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BiddingSessionConfig {
    @Bean
    public IBiddingSessionService biddingSessionService(final BiddingSessionRepository biddingSessionRepository) {
        return new BiddingSessionService(biddingSessionRepository);
    }
}
