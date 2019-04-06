package kr.hs.dgsw.web_01_402.Service;

import kr.hs.dgsw.web_01_402.Domain.Comment;
import kr.hs.dgsw.web_01_402.Domain.User;
import kr.hs.dgsw.web_01_402.Protocol.CommentUsernameProtocol;
import kr.hs.dgsw.web_01_402.Repository.UserRepository;
import kr.hs.dgsw.web_01_402.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentUsernameProtocol> listAllComments() {
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentUsernameProtocol> cupList = new ArrayList<>();
        commentList.forEach(comment -> {
            cupList.add(changeCommentToProtocol(comment));
        });
        return cupList;
    }

    @Override
    public CommentUsernameProtocol addComment(Comment comment) {
        comment = this.commentRepository.save(comment);

        return changeCommentToProtocol(comment);
    }

    @Override
    public CommentUsernameProtocol updateComment(Long id, Comment comment) {
        return this.commentRepository
                .findById(id)
                .map(found -> {
                    found.setUserID(Optional.ofNullable(comment.getUserID()).orElse(found.getUserID()));
                    found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
                    return changeCommentToProtocol(this.commentRepository.save(found));
                })
                .orElse(null);
    }

    @Override
    public boolean deleteComment(Long id) {
        return this.commentRepository.findById(id).map(found -> {
            this.commentRepository.delete(found);
            return true;
        }).orElse(false);
    }

    private CommentUsernameProtocol changeCommentToProtocol(Comment comment){
        Optional<User> found = this.userRepository.findById(comment.getUserID());

        String username = (found.isPresent()) ? found.get().getUserName() : null;

        return new CommentUsernameProtocol(comment, username);
    }

}
