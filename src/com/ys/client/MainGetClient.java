package com.ys.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MainGetClient {

    public static void main(String[] args) throws IOException {
        //1.创建HttpClient的实例
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //2.创建某种连接方法的实例
        HttpGet httpGet = new HttpGet("http://192.168.1.2:9999/CustomerService/crm/customer/0101");

        //3.调用第一步中创建好的实例的execute方法来执行第二步中创建好的链接类实例
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4.读response获取HttpEntity
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = response.getEntity();

            //5.对得到的内容进行处理
            String result = EntityUtils.toString(httpEntity);
            System.out.println(result);
            EntityUtils.consume(httpEntity);
        }else {
            System.err.println(response.getStatusLine());
        }

        //6.释放连接。无论执行方法是否成功，都必须释放连接

        httpClient.close();
    }
}
