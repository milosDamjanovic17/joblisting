package com.moose.joblisting.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "JobPost")
public class Post {

    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}
