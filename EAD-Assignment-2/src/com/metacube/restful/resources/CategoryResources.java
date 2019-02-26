package com.metacube.restful.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response.Status;







import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.facade.CategoryFacade;
import com.metacube.restful.model.Category;

@Path("/category")
public class CategoryResources {
	
	CategoryFacade categoryFacade = new CategoryFacade();

	@GET
	@Path("/allcategory")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllcategory(@HeaderParam("Authorization") String authorizationString)
	{
		if(!"get-2018".equals(authorizationString))
		{
			return ""+StatusEnums.ERROR;
		}
		List<Category> categoryList = categoryFacade.getAllCategory();
		Gson gson = new Gson();
		return gson.toJson(categoryList);
	}
	
	@POST
	@Path("/insertcategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StatusEnums insertCategory(@HeaderParam("Authorization") String authorizationString, Category category)
	{
		if(!"get-2018".equals(authorizationString))
		{
			return StatusEnums.ERROR;
		}
		System.out.println("Inserted Method");
//		Gson gson = new Gson();
//		Category category = gson.fromJson(object, Category.class);
		return categoryFacade.addcategory(category);
		
	}
	
	
	@PUT
	@Path("/updatecategory/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StatusEnums updateCategory(@HeaderParam("Authorization") String authorizationString,
			@PathParam("name") String name, @PathParam("id") int id) {
		if (!"get-2018".equals(authorizationString)) {
			return StatusEnums.ERROR;
		}
		StatusEnums status = categoryFacade.updateName(id, name);
		return status;
	}
	
}
