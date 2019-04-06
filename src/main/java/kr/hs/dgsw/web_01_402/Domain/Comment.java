package kr.hs.dgsw.web_01_402.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private Long userID;
    private String content;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modifined;

    public Comment(Long userID, String content) {
        this.userID = userID;
        this.content = content;
    }

    public Comment(Comment comment){
        this.id = comment.getId();
        this.userID = comment.getUserID();
        this.content = comment.getContent();
        this.created = comment.getCreated();
        this.modifined= comment.getModifined();
    }
}
