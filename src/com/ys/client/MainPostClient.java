package com.ys.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPostClient {

    public static void main(String[] args) throws IOException {
        //1.创建HttpClient的实例
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //2.创建某种连接方法的实例
        HttpPost httpPost = new HttpPost("http://192.168.1.2:9999/CustomerService/crm/customer");

        //传递参数
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("id","0202"));
        list.add(new BasicNameValuePair("name","李四"));
        list.add(new BasicNameValuePair("age","44"));

        HttpEntity entity = new UrlEncodedFormEntity(list,"utf-8");
        httpPost.setEntity(entity);

        //3.调用第一步中创建好的实例的execute方法来执行第二步中创建好的链接类实例
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //4.读response获取HttpEntity
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = response.getEntity();

            //5.对得到的内容进行处理
            String result = EntityUtils.toString(httpEntity,"utf-8");
            System.out.println(result);
            EntityUtils.consume(httpEntity);
        }else {
            System.err.println(response.getStatusLine());
        }

        //6.释放连接。无论执行方法是否成功，都必须释放连接

        httpClient.close();
    }
}
