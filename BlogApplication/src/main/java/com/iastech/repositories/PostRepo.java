package com.iastech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iastech.entities.Category;
import com.iastech.entities.Post;
import com.iastech.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);
}
