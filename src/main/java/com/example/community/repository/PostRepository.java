package com.example.community.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.community.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    public Post getPostByTitle(String title);
}
