package com.hackathon.iplbidding.service.config;

import com.hackathon.iplbidding.repository.PlayerRepository;
import com.hackathon.iplbidding.service.player.IPlayerService;
import com.hackathon.iplbidding.service.player.PlayerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerServiceConfig {
    @Bean
    public IPlayerService articleService(final PlayerRepository playerRepository) {
        return new PlayerService(playerRepository);
    }
}

