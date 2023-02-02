package Api.Controllers;

import entities.AuthSignIn;
import entities.AuthSignup;
import com.google.gson.*;
import okhttp3.*;


import java.io.IOException;

public class AuthController {
    public void signUp(AuthSignup authSignup) throws IOException {
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
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
    }

    public String signIn(AuthSignIn authSignIn) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(authSignIn), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        AuthSignIn newUser = gson.fromJson(response.body().string(), AuthSignIn.class);
        System.out.println(response.code());
        System.out.println(newUser);
        String token = newUser.getToken();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Code is not succes " + response.code());
        }
        return token;
    }
}
