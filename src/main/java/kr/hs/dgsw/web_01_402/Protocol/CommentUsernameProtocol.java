package kr.hs.dgsw.web_01_402.Protocol;

import kr.hs.dgsw.web_01_402.Domain.Comment;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
public class CommentUsernameProtocol extends Comment {
    private String username;

    public CommentUsernameProtocol(Comment c, String username){
        super(c);
        this.username = username;
    }
}
