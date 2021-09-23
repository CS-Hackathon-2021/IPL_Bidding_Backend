package com.hackathon.iplbidding.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class Bidder {
    @Id
    private String id;
    private String teamName;
    private List<Player> playerList;
    private long moneyLeft;
}
