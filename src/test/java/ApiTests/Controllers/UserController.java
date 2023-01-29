package ApiTests.Controllers;

import ApiTests.entities.AuthSignup;
import ApiTests.entities.UserUpdate;
import com.google.gson.Gson;
import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserController {
    @Test
    public void updateUser(UserUpdate userUpdate) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(userUpdate), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        // AuthSignup authSignup = gson.fromJson(response.body().string(), OrdersNew.class);
        System.out.println(response.code());
        System.out.println(response.body());
        System.out.println(response);
    }

    @Test
    public void finedUserId() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/29")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    @Test
    public void UserInfo() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
