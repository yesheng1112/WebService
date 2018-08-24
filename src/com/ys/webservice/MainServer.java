package com.ys.webservice;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class MainServer {

    public static void main(String[] args) {
        JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();
        jaxrsServerFactoryBean.setAddress("http://192.168.1.2:9999/CustomerService");
        jaxrsServerFactoryBean.setResourceClasses(CustomerService.class);
        jaxrsServerFactoryBean.create().start();
        System.out.println("再次开张！！");
    }
}
