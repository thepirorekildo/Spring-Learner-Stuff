package com.neymar.demorest;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;



@Path("aliens")
public class AlienResource {
	
	AlienRepositary repo = new AlienRepositary();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAliens() throws SQLException {
		
		System.out.println("Aliens are flying . .  . .. .");
		
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("id") int id) throws SQLException {
		
	
		return repo.getAlien(id);
	}
	
	//putting the data into database
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien createAlien(Alien a1) throws SQLException {
			
		System.out.println("GET INSERTED USING POST");	
		repo.create(a1);
		return a1;
	}
	
	
	//Updating the data into data in the database
		@PUT
		@Path("alien")
		@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Alien updateAlien(Alien a1) throws SQLException {
				
			System.out.println("Getting updated here");	
			if(repo.getAlien(a1.getId()).getId()==0) {
				repo.create(a1);
			}else {
				repo.update(a1);
			}
			repo.update(a1);
			return a1;
		}
		
		@DELETE
		@Path("alien/{id}")
		public Alien killAlien(@PathParam("id") int id) throws SQLException {
			
			Alien a = repo.getAlien(id);
				
			if(a.getId() != 0) {
				repo.delete(id);
			}
			
			return a;
		}
}
