package com.example.jparegionkommune23v2.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KommuneTest {

        @Test
        public void testOkHttp() throws IOException {
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
            okhttp3.Request request = new okhttp3.Request.Builder().url("http://localhost:8080/regioner").build();
            okhttp3.Response response = client.newCall(request).execute();
            Protocol prot = response.protocol();
            System.out.println(response.body());
            assertEquals("http/1.1", prot.toString());
        }

        @Test
        public void testPostObject() throws IOException {
            Region region = new Region();
            region.setNavn("Post Region");
            region.setHref("www.post.dk");
            region.setKode("1234");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(region);
            System.out.println(json);

            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

            RequestBody body = okhttp3.RequestBody.create(
                    MediaType.parse("application/json"), json);

            Request request = new Request.Builder()
                    .url("http://localhost:8080/region")
                    .post(body)
                    .build();

            Call call = client.newCall(request);
            Response response = call.execute();
            assertEquals(201, response.code());


        }
}



