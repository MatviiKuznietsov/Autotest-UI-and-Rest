package Api.Controllers;

import entities.UserUpdate;
import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class UserController {
    public UserUpdate updateUser(UserUpdate userUpdate, String token) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(userUpdate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        UserUpdate userUpdate1 = gson.fromJson(response.body().string(), UserUpdate.class);
        System.out.println(response.code());
        System.out.println(userUpdate1);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return userUpdate1;
    }

    public String finedUserId(Integer id, String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/" + id)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject =new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("username").toString();
    }

    public String UserInfo(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        JSONObject jsonObject =new JSONObject(response.body().string().replace("[", "").replace("]", ""));
        System.out.println(jsonObject);
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return jsonObject.get("username").toString();
    }
}
