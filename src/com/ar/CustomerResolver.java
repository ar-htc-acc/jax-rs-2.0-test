package com.ar;

import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Provider
@Produces("application/xml")
public class CustomerResolver implements ContextResolver<JAXBContext> {

	private JAXBContext ctx;
	
	public CustomerResolver() throws JAXBException {
		this.ctx = JAXBContext.newInstance(Customer.class);
	}
	
	@Override
	public JAXBContext getContext(Class<?> type) {
		
		if (type.equals(Customer.class)) {
			return ctx;
		}
		
		return null;
	}

}
