package com.example.jparegionkommune23v2.repository;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class RegionRepositoryTest {

    @Test
    public void testOkHttp() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/regioner").build();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response.body());
        System.out.println(response.protocol());
        assertEquals("http/1.1", response.protocol().toString());
    }

    @Test
    public void testGetRegionWithKode() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/region/1081").build();
        okhttp3.Response response = client.newCall(request).execute();
        assertEquals(200, response.code());
    }

    @Test
    public void testGetRegionWithKodeNotFound() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/region/99").build();
        okhttp3.Response response = client.newCall(request).execute();
        assertEquals(404, response.code());
    }

    @Test
    public void whenSendPostRequest_thenCorrect() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("kode", "1092")
                .add("navn", "Region Test")
                .add("href", "https://api.dataforsyningen.dk/region/1092")
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/region")
                .addHeader("Content-type","application/json")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        assertEquals(200, response.code());
    }


    @Test
    public void testPostRegion() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        String json = "{\"kode\":\"1091\",\"navn\":\"Region Test\",\"href\":\"www.test.dk\"}";

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/region")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assertEquals(201, response.code());
    }

    @Test
    public void testPostRegion2() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        String json = "{'kode':'1096','navn':'Region Test','href':'www.test.dk'}"; //dur ikke

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url("http://localhost:8080/region")
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assertEquals(201, response.code());
    }

    @Test
    public void testGetRegioner() throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/regioner").build();
        okhttp3.Response response = client.newCall(request).execute();
        ResponseBody responseBody= response.body();
        InputStream inputStream = responseBody.byteStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> lst = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            lst.add(line);
            System.out.println(line);
            line = bufferedReader.readLine();
        }
        System.out.println("Regioner size= " + lst.size());
        assertTrue(lst.size()>0);
    }


}