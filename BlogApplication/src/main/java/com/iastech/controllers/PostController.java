package com.iastech.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iastech.config.AppConstants;
import com.iastech.payloads.ApiResponse;
import com.iastech.payloads.PostDto;
import com.iastech.payloads.PostResponse;
import com.iastech.services.FileService;
import com.iastech.services.PostService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> creatPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto postDto2 = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(postDto2, HttpStatus.CREATED);
	}

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> postDtos = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> postDtos = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		PostResponse postDtos = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<PostResponse>(postDtos, HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postDto = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post deleted successfully...!!!", true);
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto postDto2 = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(postDto2, HttpStatus.OK);
	}

	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable("keywords") String keywords) {
		List<PostDto> postDtos = this.postService.searchPost(keywords);
		return new ResponseEntity<List<PostDto>>(postDtos, HttpStatus.OK);
	}

	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadImage(@RequestParam("image") MultipartFile image, @PathVariable Integer postId)
			throws IOException {
		String fileName = this.fileService.uploadImage(path, image);
		PostDto postDto = this.postService.getPostById(postId);
		postDto.setImageName(fileName);
		PostDto postDto2 = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(postDto2, HttpStatus.OK);
	}

	@GetMapping(value = "post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
			throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
