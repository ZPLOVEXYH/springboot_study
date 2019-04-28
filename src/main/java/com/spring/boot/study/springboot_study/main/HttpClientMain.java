package com.spring.boot.study.springboot_study.main;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 两种类型的http连接
 * 1. HttpURLConnection http =（HttpURLConnection）url.openConnection();
 * 2. HttpClient客户端= HttpClientBuilder.create().build();
 *
 * 总结：HttpURLConnection是旧java.net包的低级连接，而HttpClient是更高级别的API。
 * 不同之处主要在于使用方便 - 对于大多数事情，您都希望使用客户端，而不是低级连接。
 * 现在 - Java 9计划用新的Http客户端实现解决这个问题 - 但在此之前，Apache客户端是你最好的选择。
 */
@Slf4j
public class HttpClientMain {

    /**
     * 使用httpclient4来获取地址的响应状态
     * @param args
     */
    public static void main(String[] args) throws IOException {
        test1();
        test2();
    }

    public static void test1() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse httpResponse = httpClient.execute(new HttpGet("https://www.baidu.com"));
        StatusLine statusLine = httpResponse.getStatusLine();
        log.info("获取的地址响应状态为：{}", statusLine.getStatusCode());
        log.info("获取的地址响应内容为：{}", httpResponse.getEntity().getContent());
    }

    public static void test2() throws IOException {
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        log.info("获取的地址响应状态为：{}", httpURLConnection.getResponseCode());
        log.info("获取的地址响应内容为：{}", httpURLConnection.getResponseMessage());
    }
}
