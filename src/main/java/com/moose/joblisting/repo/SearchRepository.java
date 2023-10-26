package com.moose.joblisting.repo;

import com.moose.joblisting.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepository {

    List<Post> findByText(String text);
}
