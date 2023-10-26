package com.moose.joblisting.repo;

import com.moose.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostsRepository extends MongoRepository<Post, String> {
}
