package Api.Controllers;

import entities.JobCreate;
import entities.JobDelete;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
public class JobController {

    public Response deleteJobId(JobDelete jobDelete, String token, Integer id) throws IOException, RuntimeException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobDelete), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + id)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return  response;
    }


    public Response createJob(JobCreate jobCreate, String token) throws IOException {
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
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return  response;
    }


    public Response getJobId(String token, Integer id) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return  response;
    }

    public Response getJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return  response;
    }

    public Response getAllJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return  response;
    }
}
