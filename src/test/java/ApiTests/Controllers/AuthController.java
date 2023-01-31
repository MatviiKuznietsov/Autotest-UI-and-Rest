package ApiTests.Controllers;

import ApiTests.entities.AuthSignIn;
import ApiTests.entities.AuthSignup;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class AuthController {
    public void signUp (AuthSignup authSignup) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(authSignup), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void signIn (AuthSignIn authSignIn) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(authSignIn), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
