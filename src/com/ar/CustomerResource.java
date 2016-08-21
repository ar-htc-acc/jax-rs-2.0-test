package com.ar;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {

	@GET
	@Path("/test")
	public void test() {
		System.out.println("At least the system works.");
	}
	
	@GET
	@Path("/age/{age}")
	@Produces({"application/xml", "application/json"})
	public Customer getCustomerXml(@PathParam("age") int age) {
		return new Customer(age);
	}
	
	@GET
	@Path("/age/{age}")
	@Produces("text/plain")
	public Customer getCustomerText(@PathParam("age") int age) {
		return new Customer(age);
	}

	@GET
	@Path("mediaAndLanguages")
	public void ml(@Context HttpHeaders headers) {
		List<MediaType> mediaTypes = headers.getAcceptableMediaTypes();
		List<Locale> locales = headers.getAcceptableLanguages();
		
		for (MediaType mt: mediaTypes) {
			System.out.println("media type: " + mt);
		}
		
		for (Locale l: locales) {
			System.out.println("locale: " + l);
		}
	}
	
}
