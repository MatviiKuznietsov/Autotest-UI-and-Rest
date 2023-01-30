package ApiTests.Controllers;

import ApiTests.entities.CommentCreate;
import ApiTests.entities.JobCreate;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobController {
    @Test
    public void deleteJobId(JobCreate jobCreate) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/delete/1")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        // AuthSignup authSignup = gson.fromJson(response.body().string(), OrdersNew.class);
        System.out.println(response.code());
        System.out.println(response.body());
        System.out.println(response);
    }

    @Test
    public void createJob(JobCreate jobCreate) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/comment/29/create")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        // AuthSignup authSignup = gson.fromJson(response.body().string(), OrdersNew.class);
        System.out.println(response.code());
        System.out.println(response.body());
        System.out.println(response);
    }

    @Test
    public void getJobId() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/1")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    @Test //
    public void getJobs() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    @Test
    public void getAllJobs() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
