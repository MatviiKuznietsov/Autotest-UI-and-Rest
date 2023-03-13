package Api.сontrollers;

import entities.Comment;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class CommentController {

    public Comment createComment(Comment commentCreate, String token, Integer id) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(commentCreate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/create")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Comment commentCreate1 = gson.fromJson(response.body().string(), Comment.class);
        System.out.println(response.code());
        System.out.println(commentCreate1);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return commentCreate1;
    }

    public String getComment(String token, Integer id) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/all")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject = new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("message").toString();
    }
}
