package kr.hs.dgsw.web_01_402.Service;


import kr.hs.dgsw.web_01_402.Domain.Comment;
import kr.hs.dgsw.web_01_402.Protocol.CommentUsernameProtocol;

import java.util.List;

public interface CommentService {
    List<CommentUsernameProtocol> listAllComments();
    CommentUsernameProtocol addComment(Comment comment);
    CommentUsernameProtocol updateComment(Long id, Comment comment);
    boolean deleteComment(Long id);
}
