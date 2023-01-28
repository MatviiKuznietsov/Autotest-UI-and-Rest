package ApiTests.Controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserController {
    @Test
    public void updateUser() {

    }

    @Test
    public void finedUserId() {

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
