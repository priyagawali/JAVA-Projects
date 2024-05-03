package com.iastech.services;

import com.iastech.payloads.CommentDto;

public interface CommentService {
CommentDto createComment(CommentDto commentDto,Integer postId);
void deleteComment(Integer commentId);

}
