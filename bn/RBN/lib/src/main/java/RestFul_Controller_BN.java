import java.util.ArrayList;
import java.util.UUID;


//import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.validation.constraints.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

//questions:
//	How can I test my program?
//	How can I check if a @QueryParam is not present? (look at getMyAsk) methods
//	How can I create a 'Location header that points to the resource?


@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestFul_Controller_BN {
	//Account arraylist
	
	
	//curl command: curl -i "http://localhost:8080/rest-BN/api/accounts"
	private BNManager bnm = new BNManager();
	
	@Path("/accounts")
	@GET
	public Response getAllAccounts() {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(bnm.getAllAccounts());
        return Response.status(Response.Status.OK).entity(s).build();
		//Needs 1 response
		//200 (ok)
	}
	
//	curl command: curl --location --request POST 'http://localhost:8080/rest-BN/accounts' \
//	--header 'Content-Type: application/json' \
//	--data-raw '{
//	    "id": "",
//	    "ison": true
//	}'
	
	@Path("/accounts")
	@POST
	public Response createAccount(@Context UriInfo uriInfo, String json) {
		//make a gson instance
			Gson g = new Gson();
			Account a = g.fromJson(json, Account.class);
			Account na = bnm.addNewAccount(a);
			
			try {
//			JSONObject jo = new JSONObject(json);
//				//going to need two responses
//				//1st being a success (201) and
//				
//				//pulling data from address to get zip and street data
//				a.setZip(String.valueOf(jo.getJSONObject("address").get("zip")));
//				a.setStreet(String.valueOf(jo.getJSONObject("address").get("street")));
			}
			catch (Exception e){
				return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
			}
			//returning account to json
			UUID id = na.getId();
			Gson gson = new Gson();
			String s = gson.toJson(na);
			
			// Build the URI for the "Location:" header
	        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	        builder.path(id.toString());
	    // The response includes header and body data
	        return Response.created(builder.build()).entity(s).build();
		
		
        //2nd being a bad request (400) (if data is missing)
        //will activate when the account object builder notices error entry
        
	}
	
//	@Path("/gives?v_by=viewed_by_id&is_active=[true|false]")
//	@GET
//	public Response getAllGives(@PathParam("viewed_by_id") UUID uid, @PathParam("is_active") @DefaultValue("true") boolean tf) {
//		//Needs implementation
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String s = gson.toJson(bnm.getAllGives());
//        return Response.status(Response.Status.OK).entity(s).build();
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/accounts/[uid]/give")
//	@POST
//	public Response createGive(@PathParam("uid") UUID uid, String json) {
//		//needs implementation
//		
//		Account a = bnm.searchAM(uid);
//		
//		if (a.isNil()) {
//			//return 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			Gson g = new Gson();
//			Give gs = g.fromJson(json, Give.class);
//			gs.setUID(a.getId());
//			Give ng = bnm.addNewGive(gs);
//			bnm.searchAM(ng.getUID()).addGive(ng);
//			
//			//1st being a success (201) and
//			//returning account to json
//			Gson gson = new Gson();
//			String s = gson.toJson(ng);
//			return Response.status(Response.Status.OK).entity(s).build();
//		}
//	}
}
