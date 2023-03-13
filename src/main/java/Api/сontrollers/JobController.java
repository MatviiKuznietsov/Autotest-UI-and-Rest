package Api.сontrollers;

import entities.Job;
import entities.JobD;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class JobController {

    public String deleteJobId(JobD jobDelete, String token, Integer id) throws IOException, RuntimeException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobDelete), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + id)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject =new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("message").toString();
    }


    public Job createJob(Job jobCreate, String token) throws IOException, IllegalStateException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(jobCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Job jobCreate1 = gson.fromJson(response.body().string(), Job.class);
        System.out.println(response.code());
        System.out.println(jobCreate1);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jobCreate1;
    }


    public String getJobId(String token, Integer id) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("title").toString();
    }

    public String getJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("title").toString();
    }

    public String getAllJobs(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/job/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("title").toString();
    }
}
