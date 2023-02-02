package Api.Controllers;

import entities.UserUpdate;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class UserController {
    public Response updateUser(UserUpdate userUpdate, String token) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(userUpdate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/user/update")
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

    public Response  finedUserId(Integer id, String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/"+id)
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

    public Response UserInfo(String token) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Authorization", token)
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/")
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
