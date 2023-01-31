package ApiTests.Controllers;

import ApiTests.entities.CommentCreate;
import ApiTests.entities.UserUpdate;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommentController {
    @Test
    public void createComment(CommentCreate commentCreate, String  token, Integer id) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(commentCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/comment/"+id+"/create")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    @Test
    public void getComment(String token, Integer id) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/comment/"+id+"/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
