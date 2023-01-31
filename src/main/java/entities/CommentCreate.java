package entities;

import lombok.Data;

@Data
public class CommentCreate {
    private int id;
    private String message;
    private String username;
    private String commentDate;
}
