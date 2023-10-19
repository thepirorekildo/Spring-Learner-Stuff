package com.neymar.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("example")
public class Example {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getExample() {
		return "Hi there how are you";
	}
	
}
