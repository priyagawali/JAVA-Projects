package com.iastech.payloads;

import java.util.HashSet;
import java.util.Set;

import com.iastech.entities.Category;
import com.iastech.entities.Comment;
import com.iastech.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	private Integer postId;
	private String title;

	private String content;
	
	private String imageName;
	
	private String addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
}
