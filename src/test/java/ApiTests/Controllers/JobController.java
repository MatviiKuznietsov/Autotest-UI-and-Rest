package ApiTests.Controllers;

import ApiTests.entities.CommentCreate;
import ApiTests.entities.JobCreate;
import ApiTests.entities.JobDelete;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobController {

    public void deleteJobId(JobDelete jobDelete, String token, Integer id) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobDelete), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }


    public void createJob(JobCreate jobCreate, String token) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }


    public void getJobId(String token, Integer id) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void getJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void getAllJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
