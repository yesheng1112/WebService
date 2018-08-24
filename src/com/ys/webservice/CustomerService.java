package com.ys.webservice;

import com.ys.entity.Customer;

import javax.ws.rs.*;

@Path("/crm")
public class CustomerService {

    @Path("/customer/{id}")
    @GET
    @Produces("application/json")
    public Customer getCustomerById(@PathParam("id") String id){
        return new Customer(id,"zhang3",33);
    }

    @Path("/customer")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String addCustomer(@BeanParam Customer customer){
        System.out.println(customer);
        return "success:"+customer.toString();
    }
}
