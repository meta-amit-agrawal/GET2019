package com.metacube.restful.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.facade.CategoryFacade;
import com.metacube.restful.model.Category;
import com.metacube.restful.model.Response;


/**
 * CategoryResources class used for all the URI starting with " /webapi/category/* "
 * It uses the object of CategoryFacade to performs the operations
 * @author admin
 *
 */
@Path("/category")
public class CategoryResources {
	
	CategoryFacade categoryFacade = new CategoryFacade();

	/**
	 * returns the list of category available in the database
	 * @param authorizationString for authorizing with "get-2018"
	 * @return the list of category in JSON form
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllcategory(@HeaderParam("Authorization") String authorizationString)
	{
		Gson gson = new Gson();
		Response response;
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return gson.toJson(response);
		}
		List<Category> categoryList = categoryFacade.getAllCategory();
		
		return gson.toJson(categoryList);
	}
	
	
	/**
	 * inserts the category in the database
	 * @param authorizationString for authorizing with "get-2018"
	 * @param category which contains the JSON data to insert into category
	 * @return the message 
	 */
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCategory(@HeaderParam("Authorization") String authorizationString, String category)
	{
		Gson gson = new Gson();
		Response response;
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return response;
		}
		response = new Response();
		Category category2 = gson.fromJson(category, Category.class);
		//checks if input is null
		if(category2.getName()==null)
		{
			response.setCode(500);
			response.setStatus(false);
			response.setMessage("Invalid Value");
			return response;
		}
		if(categoryFacade.addcategory(category2)==StatusEnums.INSERTED)
		{
			response.setCode(200);
			response.setMessage("Inserted");
			response.setStatus(true);
			return response;
		}
		response.setCode(404);
		response.setMessage("Category Id Already Exists");
		response.setStatus(false);
		return response;	
	}
	
	/**
	 * 
	 * @param authorizationString for authorizing with "get-2018"
	 * @param category which contains the JSON data to update into category
	 * @return the response with message
	 */
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(@HeaderParam("Authorization") String authorizationString, String category) 
	{
		Response response;
		Gson gson = new Gson();
		//checks the authorization
		if((response=authorization(authorizationString))!=null)
		{
			return response;
		}
		response = new Response();
		Category category2 = gson.fromJson(category, Category.class);
		//checks if input is null
		if(category2.getName()==null)
		{
			response.setCode(500);
			response.setStatus(false);
			response.setMessage("Invalid Value");
			return response;
		}
		if(categoryFacade.updateName(category2.getId() , category2.getName())==StatusEnums.UPDATED)
		{
			response.setCode(200);
			response.setMessage("Inserted");
			response.setStatus(true);
			return response;
		}
		response.setCode(404);
		response.setMessage("Category Id Not found");
		response.setStatus(false);
		return response;
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
