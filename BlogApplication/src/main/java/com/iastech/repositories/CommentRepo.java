package com.iastech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iastech.entities.Comment;
import com.iastech.payloads.CommentDto;

public interface CommentRepo extends JpaRepository<Comment,Integer > {

	
}
