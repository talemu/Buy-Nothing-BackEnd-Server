


import java.util.ArrayList;
import java.util.UUID;


//import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response;

//questions:
//	How can I test my program?
//	How can I check if a @QueryParam is not present? (look at getMyAsk) methods
//	How can I create a 'Location header that points to the resource?


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestFul_Controller_BN2 {
//	//Account arraylist
//	private BNManager bnm = new BNManager();
//	
//	//Account Methods
//	@Path("/accounts")
//	@POST
//	public Response createAccount(@Context UriInfo uriInfo, String json) {
//		//make a gson instance
//			Gson g = new Gson();
//			Account a = g.fromJson(json, Account.class);
//			Account na = bnm.addNewAccount(a);
//			
//			try {
////			JSONObject jo = new JSONObject(json);
////				//going to need two responses
////				//1st being a success (201) and
////				
//				
////				//pulling data from address to get zip and street data
////				a.setZip(String.valueOf(jo.getJSONObject("address").get("zip")));
////				a.setStreet(String.valueOf(jo.getJSONObject("address").get("street")));
//			}
//			catch (Exception e){
//				return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//			}
//			//returning account to json
//			UUID id = na.getId();
//			Gson gson = new Gson();
//			String s = gson.toJson(na);
//			
//			// Build the URI for the "Location:" header
//	        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
//	        builder.path(id.toString());
//	    // The response includes header and body data
//	        return Response.created(builder.build()).entity(s).build();
//		
//		
//        //2nd being a bad request (400) (if data is missing)
//        //will activate when the account object builder notices error entry
//        
//	}
//	
//	@Path("/accounts/[uid]/activate")
//	@GET
//	public Response activateAccount(@PathParam("uid") UUID uid) {
//		
//		Account a = bnm.searchAM(uid);
//		if (a.isNil()) {
//			// return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			a.activate_account();
//			//return a 200
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			String s = gson.toJson(a);
//            return Response.ok(s).build();
//		}
//		
//		//needs implementation
//		//Needs 3 responses
//		//Good response (200), Bad Request(400) (if data is missing)
//		//Not Found, if the the UID doesn't exist
//	}
//	
//	@Path("/accounts/{uid}/update")
//	@PUT
//	public Response updateAccount(@PathParam("uid") UUID uid, String json) {
//		//needs implementation
//		
//		// call the "Get Lamp Detail" use caseuid
//		Gson g = new Gson();
//		Account a = g.fromJson(json, Account.class);
//        if (a.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        }
//        else {
//			Account oa = bnm.searchAM(uid);
//			oa = a;
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		//Needs 3 responses
//	    //204 (No content) if everything is ok.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    //404 (Not found) the account identified by [uid] doesn't exist.
//	}
//	
//	@Path("/accounts/{uid}")
//	@DELETE
//	public Response deleteAccount(@PathParam("uid") UUID uid) {
//		
//		Account a = bnm.searchAM(uid);
//        if (a.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        } else {
//        	//deleting the account instance from the account management array
//        	bnm.deleteAccountFromManagement(uid);
//            //no content response (204)
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		//Needs 2 responses
//		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if the account identified by [uid] doesn't exist.
//	}
//	
//	@Path("/accounts")
//	@GET
//	public Response getAllAccounts() {
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String s = gson.toJson(bnm.getAllAccounts());
//        return Response.status(Response.Status.OK).entity(s).build();
//		//Needs 1 response
//		//200 (ok)
//	}
//	
//	@Path("/accounts/[uid]")
//	@GET
//	public Response viewAccount(@PathParam("uid") UUID uid) {
//		
//		Account a = bnm.searchAM(uid);
//		if (a.isNil()) {
//			//404 (Not Found) if the account identified by [uid] doesn't exist.
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			//200 (OK).
//			Gson g = new Gson();
//			String s = g.toJson(a);
//			return Response.ok(s).build();
//		}
//		
//	}
//	
//	@Path("/accounts?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
//	@GET
//	public Response searchAccount(@QueryParam("key") String substring, @QueryParam("start_date") @DefaultValue("none") String date1,@QueryParam("end_date") @DefaultValue("none") String date2) {
//		
//		BNManager temp = new BNManager();
//		
//		//checks for date parameters
//		try {
//			if (date1 != "none" || date2 != "none") {
//				if (date1 != "none") {
//					temp = temp.containsASTA(date1);
//				}
//				if (date2 != "none"){
//					temp = temp.containsAETA(date2);
//				}
//			}
//		}
//		catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//checking for keyword
//		ArrayList<Account> temp2 = temp.containsArray(substring);
//        String s = gson.toJson(temp2);
//        return Response.status(Response.Status.OK).entity(s).build();
//		//need to implement variables that can handle path parameters
//	}
//	
//	//ASK methods
//	//ASK methods
//	//ASK methods
//	//ASK methods
//	//ASK methods
//	//ASK methods
//	
//	
//	@Path("/accounts/[uid]/asks")
//	@POST
//	public Response createAsk(@PathParam("uid") UUID uid, String json) {
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
//			Ask as = g.fromJson(json, Ask.class);
//			as.setUID(a.getId());
//			Ask na = bnm.addNewAsk(as);
//			bnm.searchAM(as.getUID()).addAsk(as);
//			//1st being a success (201) and
//			//returning account to json
//			Gson gson = new Gson();
//			String s = gson.toJson(na);
//			return Response.status(Response.Status.OK).entity(s).build();
//		}
//		
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    
//	}
//	
//	@Path("/accounts/[uid]/asks/[aid]/deactivate")
//	@GET
//	public Response deactivateAsk(@PathParam("uid") UUID uid, @PathParam("aid") UUID aid) {
//		
//		Account a = bnm.searchAM(uid);
//		Ask a2 = a.searchForAsk(aid);
//		
//		if (a.isNil() || a.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			a2.deactivateAsk();
//			//return a 200
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			String s = gson.toJson(a);
//            return Response.ok(s).build();
//		}
//		
//		//Needs 3 responses
//		//Good response (200), Bad Request(400) (if data is missing)
//		//Not Found (404), if the the UID or AID doesn't exist
//	}
//	
//	@Path("/accounts/[uid]/asks/[aid]")
//	@PUT
//	public Response updateAsk(@PathParam("uid") UUID uid, @PathParam("aid") UUID aid, String json) {
//		Gson g = new Gson();
//        Account a = bnm.searchAM(uid);
//        Ask a2 = g.fromJson(json, Ask.class);
//        if (a.isNil() || a2.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        }
//        else {
//			Ask oa = bnm.getAsk(aid);
//			Ask on2 = bnm.searchAM(oa.getUID()).searchForAsk(aid);
//			oa = a2;
//			on2 = a2;
//            return Response.status(Response.Status.NO_CONTENT).build();
//		}
//		
//		//Needs 3 responses
//	    //204 (No content) if everything is ok.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    //404 (Not found) the account identified by [uid] doesn't exist.
//	}
//	
//	@Path("/accounts/[uid]/asks/[aid]")
//	@DELETE
//	public Response deleteAsk(@PathParam("uid") UUID uid, @PathParam("aid") UUID aid) {
//		
//        Account a = bnm.searchAM(uid);
//        Ask a2 = a.searchForAsk(aid);
//        if (a.isNil() || a2.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        }
//        else {
//        	bnm.removeAsk(aid);
//        	a.deleteAsk(aid);
//        	
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		
//		//Needs 2 responses
//		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if the account identified by [uid] doesn't exist.
//	}
//	
//	@Path("/accounts/[uid]/asks{?is_active=[true|false]}")
//	@GET
//	public Response getMyAsks(@PathParam("uid") UUID uid, @QueryParam ("is_active") @DefaultValue("null") String tf) {
//		
//		//returns asks of specified uid, is active parameter is optional
//		//Needs implmentation
//		Account a = bnm.searchAM(uid);
//		if (a.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			if (tf == null) {
//				
//			}
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(a.getAsks());
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}
//	    //200 (OK).
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    //404 (Not found) if 'uid' doesn't exist.
//	}
//	
//	@Path("/asks?v_by=viewed_by_id&is_active=[true|false]")
//	@GET
//	public Response getAllAsks(@PathParam("viewed_by_id") UUID uid, @PathParam("is_active") boolean tf) {
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String s = gson.toJson(bnm.getAllAsks());
//        return Response.status(Response.Status.OK).entity(s).build();
//		//Needs implementation
//		
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/asks/[aid]")
//	@GET
//	public Response viewAsk(@PathParam("aid") UUID aid) {
//		
//		//Needs implementation
//		Ask a = bnm.getAsk(aid);
//		if (a.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + aid).build();
//		}
//		else {
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(a);
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}
//		//Needs 2 responses
//		//200 (OK).
//		
//		
//	}
//	
//	@Path("/asks?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
//	@GET
//	public Response searchAsk(@QueryParam("key") String substring, @QueryParam("start_date") @DefaultValue("none") String date1,@QueryParam("end_date") @DefaultValue("none") String date2) {
//		
//		BNManager temp = bnm;
//		
//		try {
//		//checks for date parameters
//		if (date1 != "none" || date2 != "none") {
//			if (date1 != "none") {
//				temp = temp.containsASTA(date1);
//			}
//			if (date2 != "none"){
//				temp = temp.containsAETA(date2);
//			}
//		}
//		}
//		catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//checking for keyword
//		ArrayList<Ask> temp2 = temp.containsArrayAsk(substring);
//        String s = gson.toJson(temp2);
//        return Response.status(Response.Status.OK).entity(s).build();
//		//need to implement variables that can handle path parameters
//	}
//	
//	
//	//give methods
//	//give methods
//	//give methods
//	//give methods
//	//give methods
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
//	
//	@Path("/accounts/[uid]/gives/[gid]/deactivate")
//	@GET
//	public Response deactivateGive(@PathParam("uid") UUID uid, @PathParam("aid") UUID gid) {
//		//needs implementation
//		
//		Account a = bnm.searchAM(uid);
//		Give g = a.searchForGive(gid);
//		
//		if (a.isNil() || g.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			g.deactivateGive();
//			//return a 200
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//			String s = gson.toJson(a);
//            return Response.ok(s).build();
//		}
//		//Needs 3 responses
//		//Good response (200), Bad Request(400) (if data is missing)
//		//Not Found (404), if the the UID or GID doesn't exist
//	}
//	
//	@Path ("/accounts/[uid]/gives/[gid]")
//	@PUT
//	public Response updateGive(@PathParam("uid") UUID uid, @PathParam("gid") UUID gid, String json) {
//		Gson g = new Gson();
//        Account a = bnm.searchAM(uid);
//        Give gi = g.fromJson(json, Give.class);
//        if (a.isNil() || gi.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid + " " + gid).build();
//        }
//        else {
//			Give og = bnm.getGive(gid);
//			Give on2 = bnm.searchAM(og.getUID()).searchForGive(gid);
//			og = gi;
//			on2 = gi;
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//	}
//	
//	@Path("/accounts/[uid]/asks/[gid]")
//	@DELETE
//	public Response deleteGive(@PathParam("uid") UUID uid, @PathParam("gid") UUID gid) {
//		//Needs implementation
//		Account a = bnm.searchAM(uid);
//        Give gi = a.searchForGive(gid);
//        if (a.isNil() || gi.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        }
//        else {
//        	bnm.removeGive(gid);
//        	a.deleteGive(gid);
//        	
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		
//		//Needs 2 responses
//		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if the account identified by [uid] doesn't exist.
//	}
//	
//	@Path("/accounts/[uid]/gives{?is_active=[true|false]}")
//	@GET
//	public Response getMyGives(@PathParam("uid") UUID uid, @QueryParam("is_active") @DefaultValue("???") boolean tf) {
//		
//		//returns asks of specified uid, is active parameter is optional
//		Account a = bnm.searchAM(uid);
//		if (a.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(a.getGives());
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}
//		
//	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if the account identified by [uid], or the give identified by [gid] doesn't exist.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	}
//	
//	@Path("/gives?v_by=viewed_by_id&is_active=[true|false]")
//	@GET
//	public Response getAllGives(@PathParam("viewed_by_id") UUID uid, @PathParam("is_active") boolean tf) {
//		//Needs implementation
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String s = gson.toJson(bnm.getAllGives());
//        return Response.status(Response.Status.OK).entity(s).build();
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/give/[gid]")
//	@GET
//	public Response viewGive(@PathParam("aid") UUID gid) {
//		
//		//Needs implementation
//		
//		Give g = bnm.getGive(gid);
//		if (g.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + gid).build();
//		}
//		else {
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(g);
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/give?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
//	@GET
//	public Response searchGive(@QueryParam("key") String substring, @QueryParam("start_date") @DefaultValue("none") String date1,@QueryParam("end_date") @DefaultValue("none") String date2){
//		//need to implement variables that can handle path parameters
//		BNManager temp = bnm;
//		
//		try {
//		//checks for date parameters
//		if (date1 != "none" || date2 != "none") {
//			if (date1 != "none") {
//				temp = temp.containsASTG(date1);
//			}
//			if (date2 != "none"){
//				temp = temp.containsAETG(date2);
//			}
//		}
//		}
//		catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//checking for keyword
//		ArrayList<Give> temp2 = temp.containsArrayGive(substring);
//        String s = gson.toJson(temp2);
//        return Response.status(Response.Status.OK).entity(s).build();
//		//need to implement variables that can handle path parameters
//		//Needs 1 response
//		//200 (ok)
//	}
//	
//	//thank methods
//	//thank methods
//	//thank methods
//	//thank methods
//	//thank methods
//	
//	@Path("/accounts/[uid]/thanks")
//	@POST
//	public Response createThank(@PathParam("uid") UUID uid, String json) {
//		
//		Account a = bnm.searchAM(uid);
//		
//		if (a.isNil()) {
//			//return 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			Gson g = new Gson();
//			Thank ts = g.fromJson(json, Thank.class);
//			ts.setUID(a.getId());
//			Thank nt = bnm.addNewThank(ts);
//			bnm.searchAM(nt.getUID()).addThank(nt);
//			
//			//1st being a success (201) and
//			//returning account to json
//			Gson gson = new Gson();
//			String s = gson.toJson(nt);
//			return Response.status(Response.Status.OK).entity(s).build();
//		}
//	}
//	
//	@Path("/accounts/[uid]/gives/[tid]")
//	@PUT
//	public Response updateThank(@PathParam("uid") UUID uid, @PathParam("tid") UUID tid, String json) {
//		//needs implementation
//		Gson g = new Gson();
//        Account a = bnm.searchAM(uid);
//        Thank t = g.fromJson(json, Thank.class);
//        if (a.isNil() || t.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//        }
//        else {
//			Thank ot = bnm.getThank(tid);
//			Thank on2 = bnm.searchAM(ot.getUID()).searchForThank(tid);
//			ot = t;
//			on2 = t;
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		//Needs 3 responses
//	    //204 (No content) if everything is ok.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    //404 (Not found) the account identified by [uid] doesn't exist.
//	
//	}
//	
//	
//	@Path("/accounts/[uid]/thanks")
//	@GET
//	public Response getMyThanks(@PathParam("uid") UUID uid) {
//		
//		//returns asks of specified uid, is active parameter is optional
//		
//		Account a = bnm.searchAM(uid);
//		if (a.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
//		}
//		else {
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(a.getThanks());
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}
//	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if the account identified by [uid], or the give identified by [gid] doesn't exist.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	}
//	
//	@Path("/thanks")
//	@GET
//	public Response getAllThanks() {
//		Gson g = new Gson();
//		String s = g.toJson(bnm.getAllThanks());
//		return Response.status(Response.Status.OK).entity(s).build();
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/thanks/[tid]")
//	@GET
//	public Response viewThank(@PathParam("aid") UUID tid) {
//		
//		Gson g = new Gson();
//		Thank t = bnm.getThank(tid);
//		if (t.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + tid).build();
//		}
//		else {
//			String s = g.toJson(t);
//			return Response.status(Response.Status.OK).entity(s).build();
//		}
//		//Needs implementation
//		
//		//Needs 1 responses
//		//200 (OK).
//	}
//	
//	@Path("/thanks/received/[uid]")
//	@GET
//	public Response viewThanksForUser(@PathParam("uid") UUID uid) {
//		
//		Gson g = new Gson();
//		ArrayList <Thank> temp = bnm.getThankTo(uid);
//		String s = g.toJson(temp);
//		return Response.status(Response.Status.OK).entity(s).build();
//		//Needs 1 response
//		//200 (ok)
//	}
//	
//	@Path("/thanks?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
//	@GET
//	public Response searchThanks(@QueryParam("key") String substring, @QueryParam("start_date") @DefaultValue("none") String date1,@QueryParam("end_date") @DefaultValue("none") String date2) {
//		
//		BNManager temp = bnm;
//		
//		try {
//		//checks for date parameters
//		if (date1 != "none" || date2 != "none") {
//			if (date1 != "none") {
//				temp = temp.containsASTT(date1);
//			}
//			if (date2 != "none"){
//				temp = temp.containsAETT(date2);
//			}
//		}
//		}
//		catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//checking for keyword
//		ArrayList<Thank> temp2 = temp.containsArrayThank(substring);
//        String s = gson.toJson(temp2);
//        return Response.status(Response.Status.OK).entity(s).build();
//		//need to implement variables that can handle path parameters
//	}
//	
//	//note methods
//	//note methods
//	//note methods
//	//note methods
//	//note methods
//	
//	@Path("/notes")
//	@POST
//	public Response createNote(String json) {
//		//needs implementation
//		
//		Gson g = new Gson();
//		Note nn = g.fromJson(json, Note.class);
//		Note nt = bnm.addNewNote(nn);
//		bnm.searchAM(nn.getUID()).addNote(nn);
//		
//		//1st being a success (201) and
//		//returning account to json
//		Gson gson = new Gson();
//		String s = gson.toJson(nt);
//		return Response.status(Response.Status.OK).entity(s).build();
//		//going to need three responses:
//		//201 (Created) if everything is ok.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	}
//	
//	@Path("/notes/[nid]")
//	@PUT
//	public Response updateNote(@PathParam("nid") UUID nid, String json) {
//		
//		Gson g = new Gson();
//		Note n = g.fromJson(json, Note.class);
//		
//		if (n.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + nid).build();
//		}
//		else {
//			Note on = bnm.getNote(nid);
//			Note on2 = bnm.searchAM(on.getUID()).searchForNote(nid);
//			on = n;
//			on2 = n;
//            return Response.status(Response.Status.NO_CONTENT).build();
//		}
//		//needs implementation
//		
//		//Needs 3 responses
//	    //204 (No content) if everything is ok.
//	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
//	    //404 (Not found) the note identified by [nid] doesn't exist.
//	}
//	
//	
//	@Path("/notes/[nid]")
//	@DELETE
//	public Response deleteNote(@PathParam("nid") UUID nid) {
//		
//        Note a2 = bnm.getNote(nid);
//        if (a2.isNil()) {
//            // return a 404
//            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + nid).build();
//        }
//        else {
//        	Account a = bnm.searchAM(bnm.getNote(nid).getUID());
//        	bnm.removeAsk(nid);
//        	a.deleteAsk(nid);
//        	
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//		//returns asks of specified uid, is active parameter is optional
//		//Needs implementation
//		
//	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
//	    //404 (Not found) if nid does not exist
//		}
//	
////	@Path("/notes{?c_by=created_by_id&v_by=viewed_by_id&type=[ask|give]&agid=ask_or_give_id}")
////	@GET
////	public Response viewNotes() {
////		
////		//Needs implementation with optional parameters in PathParams
////		
////		//Needs 1 responses
////		//200 (OK).
////		
////		return Response.status(0).build();
////	}
//	
//	@Path("/thanks/received/[nid]")
//	@GET
//	public Response viewNote(@PathParam("nid") UUID nid) {
//		
//		Note n = bnm.getNote(nid);
//		if (n.isNil()) {
//			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + nid).build();
//		}
//		else {
//			Gson gson = new GsonBuilder().setPrettyPrinting().create();
//	        String s = gson.toJson(n);
//	        return Response.status(Response.Status.OK).entity(s).build();
//		}		
//		//Needs 1 response
//		//200 (ok)
//		//404 (Not found) if [nid] doesn't exist. 
//	}
//	
//	//report method
//	//report method
//	//report method
//	
//	@Path("/reports/[rid]?c_by=created_by_id&v_by=viewed_by_id&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY")
//	@GET
//	public Response searchNote(@QueryParam("key") String substring, @QueryParam("start_date") @DefaultValue("none") String date1,@QueryParam("end_date") @DefaultValue("none") String date2) {
//		
//		BNManager temp = bnm;
//		
//		try {
//		//checks for date parameters
//		if (date1 != "none" || date2 != "none") {
//			if (date1 != "none") {
//				temp = temp.containsASTN(date1);
//			}
//			if (date2 != "none"){
//				temp = temp.containsAETN(date2);
//			}
//		}
//		}
//		catch (Exception e) {
//			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Json input").build();
//		}
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		//checking for keyword
//		ArrayList<Note> temp2 = temp.containsArrayNote(substring);
//        String s = gson.toJson(temp2);
//        return Response.status(Response.Status.OK).entity(s).build();
//		//need to implement variables that can handle path parameters
//	}
}
