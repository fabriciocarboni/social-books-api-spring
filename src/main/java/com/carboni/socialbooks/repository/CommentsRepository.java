package com.carboni.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carboni.socialbooks.domain.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
