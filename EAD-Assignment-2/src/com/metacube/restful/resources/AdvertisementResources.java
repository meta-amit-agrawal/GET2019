package com.metacube.restful.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.restful.facade.AdvertisementFacade;
import com.metacube.restful.model.Advertisement;




@Path("/adver")
public class AdvertisementResources {
	
	AdvertisementFacade advertisementFacade = new AdvertisementFacade();
	
	@GET
	@Path("/alladvertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisement()
	{
		List<Advertisement> advertisementList = advertisementFacade.getAllAdvertisements();
		Gson gson=new Gson();
		return gson.toJson(advertisementList);
	}
	
	@POST
	@Path("/insertadvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertAdvertisement(Advertisement advertisement)
	{
		System.out.println("Inserted Method");
		
		return new Gson().toJson(new String("Inserted"));
		
	}
	
}
