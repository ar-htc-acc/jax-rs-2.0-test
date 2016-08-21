package com.ar;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
public class ShoppingApplication extends Application {

	private Set<Class<?>> empty = new HashSet<>();	
	private Set<Object> singletons = new HashSet<>();
	
	public ShoppingApplication() {
		singletons.add(new CustomerResource());
		empty.add(CustomerResolver.class);
		empty.add(EntityNotFoundMapper.class);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
