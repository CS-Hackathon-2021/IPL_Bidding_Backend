package com.hackathon.iplbidding.service.config;

import com.hackathon.iplbidding.repository.BidderRepository;
import com.hackathon.iplbidding.service.bidder.BidderService;
import com.hackathon.iplbidding.service.bidder.IBidderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BidderServiceConfig {
    @Bean
    public IBidderService bidderService(final BidderRepository bidderRepository) {
        return new BidderService(bidderRepository);
    }
}
