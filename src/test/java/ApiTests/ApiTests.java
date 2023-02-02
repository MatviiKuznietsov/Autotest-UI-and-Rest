package ApiTests;

import Api.Controllers.AuthController;
import Api.Controllers.CommentController;
import Api.Controllers.JobController;
import Api.Controllers.UserController;
import entities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTests {
    public String token;

    @Test(priority = 1)
    public void signUP() throws IOException {
        AuthSignup authSignup = new AuthSignup();
        authSignup.setUsername("user3");
        authSignup.setPassword("Pass12345");
        authSignup.setConfirmPassword("Pass12345");
        AuthController authController = new AuthController();
        authController.signUp(authSignup);

    }

    @Test(priority = 2)
    public void signIn() throws IOException {
        AuthSignIn authSignIN = new AuthSignIn();
        authSignIN.setUsername("user3");
        authSignIN.setPassword("Pass12345");
        AuthController authController = new AuthController();
        token = authController.signIn(authSignIN);

    }

    //- CommentControllers----------------------------------------------------------------------------------------------
    @Test(priority = 10)
    public void addComment() throws IOException {
        CommentCreate commentCreate = new CommentCreate();
        commentCreate.setId(1);
        commentCreate.setUsername("User3");
        commentCreate.setCommentDate("22-02-2022");
        commentCreate.setMessage("New message");
        CommentController commentController = new CommentController();
        CommentCreate commentCreateCheckResult = commentController.createComment(commentCreate, token, 29);
        Assert.assertEquals(commentCreateCheckResult.getMessage(), commentCreate.getMessage());
    }

    @Test(priority = 11)
    public void showComment() throws IOException {
        CommentController commentController = new CommentController();
        String message = commentController.getComment(token, 1);
        System.out.println(message);
    }

    //- JobController----------------------------------------------------------------------------------------------
    @Test(priority = 12)
    public void removeWork() throws IOException, RuntimeException {
        JobDelete jobDelete = new JobDelete();
        JobController jobController = new JobController();
        String message = jobController.deleteJobId(jobDelete, token, 578);
        System.out.println(message);
    }

    @Test(priority = 6)
    public void addWork() throws IOException, IllegalStateException {
        JobCreate jobCreate = new JobCreate();
        jobCreate.setId(1);
        jobCreate.setUser("user3");
        jobCreate.setTitle("NewJob");
        jobCreate.setPrice(50);
        jobCreate.setDescription("This is my new work");
        JobController jobController = new JobController();
        JobCreate jobCreateCheckResult = jobController.createJob(jobCreate, token);
        Assert.assertEquals(jobCreateCheckResult.getTitle(), jobCreate.getTitle());
    }

    @Test(priority = 7)
    public void getWorkById() throws IOException {
        JobController jobController = new JobController();
        String title = jobController.getJobId(token, 1);
        System.out.println(title);
    }

    @Test(priority = 8)
    public void getUserWork() throws IOException {
        JobController jobController = new JobController();
        String title = jobController.getJobs(token);
        System.out.println(title);
    }

    @Test(priority = 9)
    public void getAllWork() throws IOException {
        JobController jobController = new JobController();
        String title = jobController.getAllJobs(token);
        System.out.println(title);
    }

    //- UserController ----------------------------------------------------------------------------------------------
    @Test(priority = 3)
    public void updateUserInfo() throws IOException {
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setId(28);
        userUpdate.setUsername("MyNewName");
        userUpdate.setLastname("MyNewLastName");
        userUpdate.setName("NewName");
        UserController userController = new UserController();
        UserUpdate userUpdateCheckResult = userController.updateUser(userUpdate, token);
        Assert.assertEquals(userUpdateCheckResult.getName(), userUpdate.getName());
    }

    @Test(priority = 4)
    public void finedUserById() throws IOException {
        UserController userController = new UserController();
        String username = userController.finedUserId(25, token);
        System.out.println(username);
    }

    @Test(priority = 5)
    public void getUserInfo() throws IOException {
        UserController userController = new UserController();
        String username = userController.UserInfo(token);
        System.out.println(username);
    }
}
