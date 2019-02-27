package com.metacube.restful.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.facade.AdvertisementFacade;
import com.metacube.restful.model.Advertisement;
import com.metacube.restful.model.CategoryAdvertsiement;
import com.metacube.restful.model.Response;



/**
 * AdvertisementResources class used for all the URI starting with " /webapi/advertisement/* "
 * It uses the object of AdvertisementFacade to performs the operations
 * @author admin
 *
 */
@Path("/advertisement")
public class AdvertisementResources {
	
	AdvertisementFacade advertisementFacade = new AdvertisementFacade();
	
	/**
	 * returns the list of advertisement available in the database
	 * @param authorizationString for authorizing with "get-2018"
	 * @return the list of advertisement in JSON form
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllAdvertisement(@HeaderParam("Authorization") String authorizationString)
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return gson.toJson(response);
		}
		List<Advertisement> advertisementList = advertisementFacade.getAllAdvertisements();
		return gson.toJson(advertisementList);
	}
	
	/**
	 * inserts the advertisement in the database
	 * @param authorizationString for authorizing with "get-2018"
	 * @param json which contains the JSON data to insert into advertisement
	 * @return the message with status
	 */
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertAdvertisement(@HeaderParam("Authorization") String authorizationString, String json)
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return response;
		}
		
		response = new Response();
		Advertisement advertisement = gson.fromJson(json, Advertisement.class);
		//checks if input is null
		if(advertisement.getName()==null)
		{
			response.setCode(500);
			response.setStatus(false);
			response.setMessage("Invalid Value");
			return response;
		}
		try 
		{
			//inserts into database
			advertisementFacade.insertAdvertisement(advertisement);
			response.setCode(0);
			response.setMessage("Inserted");
			response.setStatus(true);
			return response;
		} 
		catch (SQLException e) 
		{
			response.setCode(404);
			response.setMessage("Category Id Not found Or Advertisement Id Already Exists");
			response.setStatus(false);
			return response;
		}
	}

	/**
	 * updates the advertisement with the given name of given id
	 * @param authorizationString for authorizing with "get-2018"
	 * @param json which contains the json data to update the advertisement 
	 * @return the response which performed
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdvertisement(@HeaderParam("Authorization") String authorizationString, String json)
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return response;
		}
		response = new Response();
		Advertisement advertisement = gson.fromJson(json, Advertisement.class);
		//checks if input is null
		if(advertisement.getName()==null)
		{
			response.setCode(500);
			response.setStatus(false);
			response.setMessage("Invalid Value");
			return response;
		}
		
		advertisementFacade.updateAdvertsement(advertisement.getId(), advertisement.getName());
		response.setCode(0);
		response.setMessage("Inserted");
		response.setStatus(true);
		return response;
		
	}
	
	
	/**
	 * deletes the advertisement of given id 
	 * @param authorizationString for authorizing with "get-2018"
	 * @param json which contains the id of the advertisement 
	 * @return the message 
	 */
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisement(@HeaderParam("Authorization") String authorizationString, String json)
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return response;
		}
		response = new Response();
		Advertisement advertisement = gson.fromJson(json, Advertisement.class); 
		if(advertisementFacade.deleteAdvertisement(advertisement.getId())==StatusEnums.DELETED)
		{
			response.setCode(0);
			response.setMessage("Deleted");
			response.setStatus(true);
			return response;
		}
		
		response.setCode(404);
		response.setMessage("Advertisement Id Not Found");
		response.setStatus(false);
		return response;
	}
	
	/**
	 * finds the list of advertisement with reference to given category id
	 * @param authorizationString for authorizing with "get-2018"
	 * @param id of category which to be list of advertisement to be returned
	 * @return the list of the advertisement
	 */
	@GET
	@Path("/category/{id}/advertisement")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAdvertisementByCategoryID(@HeaderParam("Authorization") String authorizationString, @PathParam("id") int id)
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return gson.toJson(response);
		}
		CategoryAdvertsiement categoryAdvertsiement = advertisementFacade.getAdvertisementByCategoryID(id);
		return gson.toJson(categoryAdvertsiement);
	}
	
	/*
	 * authorization method to authorize the key
	 */
	private Response authorization(String authorizationString)
	{
		Response response = new Response();
		if (!"get-2018".equals(authorizationString)) 
		{
			response.setCode(405);
			response.setStatus(false);
			response.setMessage("Authorization failed");
			return response;
		}
		return null;
	}
	
	
	
}
