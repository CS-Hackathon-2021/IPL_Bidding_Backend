package com.hackathon.iplbidding.domain;

import com.hackathon.iplbidding.model.Category;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Player {
    @Id
    private String id;
    private String name;
    private int age;
    private long basePrice;
    private String country;
    private Category category;
    private int noOfMatches;
    private int noOfWickets;
    private int runsScored;
    private boolean isSold;
}
