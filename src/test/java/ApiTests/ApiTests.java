package ApiTests;

import ApiTests.Controllers.AuthController;
import ApiTests.Controllers.CommentController;
import ApiTests.Controllers.JobController;
import ApiTests.Controllers.UserController;
import ApiTests.entities.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTests {
    private final String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyOSIsIm5hbWUiOm51bGwsImlkIjoiMjkiLCJ1c2VybmFtZSI6InVzZXIzIiwibGFzdG5hbWUiOm51bGwsImlhdCI6MTY3NTE1NTI5NiwiZXhwIjoxNjc1MTU4ODk2fQ.qFYBphf3BjTx2RbEJyraSU3jMr70GrTYv5ZKcVeq5b7RMnjcChivzqNtxFi3awHXV-ipRtqnzPpLaPrNiuqRyg";

    @Test (priority = 1)
    public void signUP() throws IOException {
        AuthSignup authSignup = new AuthSignup();
        authSignup.setUsername("user3");
        authSignup.setPassword("Pass12345");
        authSignup.setConfirmPassword("Pass12345");
        AuthController authController = new AuthController();
        authController.signUp(authSignup);
    }

    @Test (priority = 2)
    public void signIn() throws IOException {
        AuthSignIn authSignIN = new AuthSignIn();
        authSignIN.setUsername("user3");
        authSignIN.setPassword("Pass12345");
        AuthController authController = new AuthController();
        authController.signIn(authSignIN);
    }

    //- CommentControllers----------------------------------------------------------------------------------------------
    @Test (priority = 10)
    public void addComment() throws IOException {
        CommentCreate commentCreate = new CommentCreate();
        commentCreate.setId(1);
        commentCreate.setUsername("User3");
        commentCreate.setCommentDate("22-02-2022");
        commentCreate.setMessage("New message");
        CommentController commentController = new CommentController();
        commentController.createComment(commentCreate, token, 29);
    }

    @Test (priority = 11)
    public void showComment() throws IOException {
        CommentController commentController = new CommentController();
        commentController.getComment(token, 1);
    }

    //- JobController----------------------------------------------------------------------------------------------
    @Test (priority = 12)
    public void removeWork() throws IOException {
        JobDelete jobDelete = new JobDelete();
        JobController jobController = new JobController();
        jobController.deleteJobId(jobDelete,token,118);
    }

    @Test (priority = 6)
    public void addWork() throws IOException {
        JobCreate jobCreate = new JobCreate();
        jobCreate.setId(1);
        jobCreate.setUser("user3");
        jobCreate.setTitle("NewJob");
        jobCreate.setPrice(50);
        jobCreate.setDescription("This is my new work");
        JobController jobController = new JobController();
        jobController.createJob(jobCreate, token);
    }

    @Test (priority = 7)
    public void getWorkById() throws IOException {
        JobController jobController = new JobController();
        jobController.getJobId(token, 1);
    }

    @Test (priority = 8)
    public void getUserWork() throws IOException {
        JobController jobController = new JobController();
        jobController.getJobs(token);
    }

    @Test (priority = 9)
    public void getAllWork() throws IOException {
        JobController jobController = new JobController();
        jobController.getAllJobs(token);
    }

    //- UserController ----------------------------------------------------------------------------------------------
    @Test (priority = 3)
    public void updateUserInfo() throws IOException {
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setId(28);
        userUpdate.setUsername("MyNewName");
        userUpdate.setLastname("MyNewLastName");
        userUpdate.setName("NewName");
        UserController userController = new UserController();
        userController.updateUser(userUpdate, token);
    }

    @Test (priority = 4)
    public void finedUserById() throws IOException {
        UserController userController = new UserController();
        userController.finedUserId(29, token);
    }

    @Test (priority = 5)
    public void getUserInfo() throws IOException {
        UserController userController = new UserController();
        userController.UserInfo(token);
    }
}
