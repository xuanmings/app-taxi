package com.songxm.taxi;

import org.junit.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author sxm
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */

public class TestOkHttp {

    @Test
    public void httpGet() throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://eu.httpbin.org/ip")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    @Test
    public void httpPost() throws Exception {
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(JSON, "{'namw':'songxm','age','20'}");
            Request request = new Request.Builder()
                    .url("http://eu.httpbin.org/post")
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
