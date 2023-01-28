package ApiTests.entities;

import lombok.Data;

@Data
public class JobCreate {
    private int id;
    private String title;
    private String description;
    private int price;
    private String user;
    private int noOfComments;

}
