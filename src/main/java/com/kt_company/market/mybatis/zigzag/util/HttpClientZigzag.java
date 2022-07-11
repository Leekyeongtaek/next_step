package com.kt_company.market.mybatis.zigzag.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HttpClientZigzag {

    @Value("${zigzag.api.url}")
    private String zigzagApiUrl;

    private Gson gson = new Gson();

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Post 전송 메서드.
     */
    public Map post(String accessKey, String secretKey, String graphQlQuery, JSONObject jsonObject) throws Exception {
        String jsonBody = jsonObject.toString();
        String authorization = this.createAuthorization(accessKey, secretKey, graphQlQuery);
//        log.debug("인증 헤더 데이터 = {}", authorization);
        log.debug("쿼리 제이슨 바디 데이터 = {}", jsonBody);
        try {
            OkHttpClient client = new OkHttpClient.Builder().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, jsonBody);
            Request request = new Request.Builder()
                .url("https://openapi.alpha.zigzag.kr/1/graphql")
                .post(body)
                .addHeader("Authorization", authorization)
                .addHeader("Content-Type", "application/json")
                .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            log.info("ZIGZAG API POST RESPONSE = {}", responseBody);
            return gson.fromJson(responseBody, Map.class);
        } catch (Exception e) {
            throw new Exception("API 호출 오류" + e.getMessage());
        }
    }

    /**
     * 지그재그 Authorization 생성 메서드.
     */
    public String createAuthorization(String accessKey, String secretKey, String graphQlQuery) throws Exception {
        try {
            long signedDate = System.currentTimeMillis();

            graphQlQuery = graphQlQuery.replaceAll("\\s+", " ");
            String message = signedDate + "." + graphQlQuery;

            Mac hasher = Mac.getInstance("HmacSHA1");
            hasher.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA1"));
            byte[] hash = hasher.doFinal(message.getBytes());
            String signature = toHexString(hash);

            return "CEA algorithm=HmacSHA256, access-key=" + accessKey + ", signed-date=" + signedDate + ", signature=" + signature;
        } catch (NoSuchAlgorithmException e) {
            log.info("NoSuchAlgorithmException Error...");
            return "";
        } catch (InvalidKeyException e) {
            log.info("InvalidKeyException Error...");
            return "";
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

//    public static void main(String[] args) throws Exception {
//        String accessKey = "69a35e30-e2f4-4aa0-88df-6f6dae10eb7e";
//        String secretKey = "8034d4ad0118d92daa8cdb80cc0265654db2db8e";
//        String query = "mutation ($input: CreateProductInput!) {\n"
//            + "    createProduct(input: $input)\n"
//            + "}";
//
//        String authorization = createAuthorization(accessKey, secretKey, query);
//        log.debug("authorization = {}", authorization);
//    }

}
