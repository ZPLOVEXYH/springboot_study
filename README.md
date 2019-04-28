##java当中两种类型的http连接获取响应码
###方法一：1. HttpURLConnection http =（HttpURLConnection）url.openConnection();
```java
URL url = new URL("https://www.baidu.com");
HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
log.info("获取的地址响应状态为：{}", httpURLConnection.getResponseCode());
```

###方法二：HttpClient httpClient = HttpClientBuilder.create().build();
```java
HttpClient httpClient = HttpClientBuilder.create().build();
HttpResponse httpResponse = httpClient.execute(new HttpGet("https://www.baidu.com"));
StatusLine statusLine = httpResponse.getStatusLine();
log.info("获取的地址响应状态为：{}", statusLine.getStatusCode());
```