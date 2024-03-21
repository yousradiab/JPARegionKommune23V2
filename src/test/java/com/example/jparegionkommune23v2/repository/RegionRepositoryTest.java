package com.example.jparegionkommune23v2.repository;

import okhttp3.Protocol;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

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
    }


}