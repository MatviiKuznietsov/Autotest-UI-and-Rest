package ApiTests.Controllers;

import ApiTests.entities.CommentCreate;
import ApiTests.entities.UserUpdate;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommentController {
    @Test
    public void createComment(CommentCreate commentCreate) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(commentCreate), MediaType.parse("application/json"));
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
    public void getComment() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/comment/29/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
