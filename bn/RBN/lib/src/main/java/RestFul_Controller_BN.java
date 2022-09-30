import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

//import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

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
	// Account arraylist

	// curl command: curl -i "http://localhost:8080/rest-BN/api/accounts"
	private BNManager bnm = new BNManager();
	
	//following takes care of the getting all accounts method and the query method
	@Path("/accounts")
	@GET
	public Response searchAccount(	@DefaultValue ("") @QueryParam("key") String key,
									@DefaultValue ("01-01-1900") @QueryParam("start_date") String start_date,
									@DefaultValue ("01-01-3000") @QueryParam("end_date") String end_date) {
		//
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			//to make key case insensitive
			String key_insensitive = key.toLowerCase();
			String s = gson.toJson(bnm.searchAccountQuery(key_insensitive, start_date,end_date));
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e){
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}")
	@GET
	public Response getAccountQuery(@PathParam (value = "uid") String uid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String s = gson.toJson(bnm.searchAndReturn(uid));
		return Response.status(Response.Status.OK).entity(s).build();
	}

	@Path("/accounts")
	@POST
	public Response createAccount(@Context UriInfo uriInfo, String json)
			throws JsonParseException, JsonMappingException, IOException {
		// make a gson instance
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper mapper = new ObjectMapper();
			Account a = mapper.readValue(json, Account.class);
			Account na = bnm.addNewAccount(a);
			String s = gson.toJson(na);
			// The response includes header and body data
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.OK).build();
//			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
//		return Response.status(Response.Status.OK).build();
	}
	
	@Path("/accounts/{uid}/activate")
	@GET
	public Response activateAccount(@PathParam (value = "uid") String uid) throws Exception {
		
		try {
			bnm.activateAccount(uid);
			return Response.ok().build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/deactivate")
	@PUT
	public Response deactivateAccount(@PathParam (value = "uid") String uid) {
		
		try {
			bnm.deactivateAccount(uid);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String s = gson.toJson(bnm.searchAndReturn(uid));
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{id}")
    @DELETE
    public Response deleteAccount(@PathParam("id") String uid) {
        // call the "Delete Lamp" use case
    	try {
    		bnm.deleteAccountFromManagement(uid);
    		// return a 204
    	    return Response.status(Response.Status.NO_CONTENT).build();
    	} catch (Exception e) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + uid).build();
        } 
    }
	
	@Path("/accounts/{uid}")
	@PUT
    public Response updateAccount(@PathParam ("uid") String uid, @Context UriInfo uriInfo, String json) {
		try {
			bnm.updateAccountFromManagement(uid, json);			
			// The response includes header and body data
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		} 
    }
	
	//Asks
	
	@Path("/accounts/{uid}/asks")
	@POST
	public Response createAsk(@PathParam ("uid") String uid, String json) throws NotFoundException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Ask a = mapper.readValue(json, Ask.class);
			a.setUID(uid);
			this.bnm.searchAndReturn(uid).addAsk(a);
			this.bnm.addNewAsk(a);
			URI askLocation = new URI("/rest-BN/api/accounts/" + uid + "/asks/" + a.getId());
			return Response.status(Response.Status.OK).location(askLocation).build();
//			return Response.status(Response.Status.OK).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/asks/{aid}")
	@GET
	public Response retrieveAsk(@PathParam ("uid") String uid, @PathParam ("aid") String aid) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Account temp = bnm.searchAndReturn(uid);
			Ask returnedAsk = (Ask) temp.searchAndReturn(new Ask(), aid);
			String s = gson.toJson(returnedAsk);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
	}
//	
	@Path("/accounts/{uid}/asks/{aid}/deactivate")
	@GET
	public Response deactivateAsk(@PathParam ("uid") String uid, @PathParam ("aid") String aid) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Account temp = bnm.searchAndReturn(uid);
			Ask returnedAsk = (Ask) temp.searchAndDeactivate(new Ask(), aid);
			//deactivate ask in bn manager
			bnm.searchAndDeactivate(new Ask(), aid);
			String s = gson.toJson(returnedAsk);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/asks/{aid}")
	@PUT
	public Response updateAsk(@PathParam ("uid") String uid, @PathParam ("aid") String aid, String json) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper mapper = new ObjectMapper();
			Ask a = mapper.readValue(json, Ask.class);
			Account temp = bnm.searchAndReturn(uid);
			Ask returnedAsk = (Ask) temp.searchAndUpdate(aid, new Ask(), a);
			//update the ask in the bn manager
			bnm.searchAndUpdate(aid, a);
			String s = gson.toJson(returnedAsk);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/asks/{aid}")
	@DELETE
	public Response deleteAsk(@PathParam ("uid") String uid, @PathParam ("aid") String aid) {
		try {
			Account temp = bnm.searchAndReturn(uid);
			temp.searchAndDelete(new Ask(), aid);
			//delete from bn manager
			bnm.searchAndDeleteAsk(aid);
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/asks")
	@GET
	public Response getAllMyAsks(@PathParam ("uid") String uid, 
			@DefaultValue ("true") @QueryParam("is_active") String is_active) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Account temp = bnm.searchAndReturn(uid);
		ArrayList <Ask> returnedAsks= temp.getAsks(is_active);
		String s = gson.toJson(returnedAsks);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/asks")
	@GET
	public Response getAllAsks(
			@DefaultValue ("true") @QueryParam("is_active") String is_active,
			@DefaultValue ("") @QueryParam("key") String key,
			@DefaultValue ("01-01-1900") @QueryParam("start_date") String start_date,
			@DefaultValue ("01-01-3000") @QueryParam("end_date") String end_date
	) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			//key case insensitivity
			String key_insensitive = key.toLowerCase();
			ArrayList <Ask> returnedAsks = (ArrayList<Ask>) bnm.searchAskQuery(is_active, key_insensitive, start_date, end_date);
			ArrayList <Ask> returned_from_accounts = (ArrayList <Ask>) bnm.searchAccountQueryReturnAsks(key_insensitive, start_date, end_date);
			for (int i = 0; i < returned_from_accounts.size(); i++) {
				if (!returnedAsks.contains(returned_from_accounts.get(i))) {
					returnedAsks.add(returned_from_accounts.get(i));
				}
			}
			String s = gson.toJson(returnedAsks);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/asks/{aid}")
	@GET
	public Response viewAsk(@PathParam ("aid") String aid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Ask returnedAsk = (Ask) bnm.getEI(new Ask(), aid);
		String s = gson.toJson(returnedAsk);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
//	@Path("/accounts/{uid}/asks")
//	@GET
//	public Response getAllMyAsks(@PathParam ("uid") String uid, @DefaultValue ("null") @QueryParam ("is_active") Boolean active) {
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		Account temp = bnm.searchAndReturn(uid);
//		ArrayList <Ask> returnedAsks = new ArrayList <Ask>();
//		if (active == null) {
//			returnedAsks= temp.getAsks();
//		}
//		else {
//			returnedAsks= temp.getAsks(active);
//		}
//		String s = gson.toJson(returnedAsks);
//		return Response.status(Response.Status.OK).entity(s).build();
//	}
	
	//Gives
	@Path("/accounts/{uid}/gives")
	@POST
	public Response createGive(@PathParam ("uid") String uid, String json) throws NotFoundException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Give g = mapper.readValue(json, Give.class);
			g.setUID(uid);
			this.bnm.searchAndReturn(uid).addGive(g);
			this.bnm.addNewGive(g);
			URI askLocation = new URI("/rest-BN/api/accounts/" + uid + "/gives/" + g.getId());
			return Response.status(Response.Status.OK).location(askLocation).build();
//			return Response.status(Response.Status.OK).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/gives/{gid}/deactivate")
	@GET
	public Response deactivateGive(@PathParam ("uid") String uid, @PathParam ("gid") String gid) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Account temp = bnm.searchAndReturn(uid);
			Give returnedGive = (Give) temp.searchAndDeactivate(new Give(), gid);
			//deactivate ask in bn manager
			bnm.searchAndDeactivate(new Give(), gid);
			String s = gson.toJson(returnedGive);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/gives/{gid}")
	@PUT
	public Response updateGive(@PathParam ("uid") String uid, @PathParam ("gid") String gid, String json) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper mapper = new ObjectMapper();
			Give g = mapper.readValue(json, Give.class);
			Account temp = bnm.searchAndReturn(uid);
			Give returnedAsk = (Give) temp.searchAndUpdate(gid, new Give(), g);
			//update the give in the bn manager
			bnm.searchAndUpdate(gid, g);
			String s = gson.toJson(returnedAsk);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/gives/{gid}")
	@DELETE
	public Response deleteGive(@PathParam ("uid") String uid, @PathParam ("gid") String gid) {
		try {
			Account temp = bnm.searchAndReturn(uid);
			temp.searchAndDelete(new Give(), gid);
			//delete from bn manager
			bnm.searchAndDeleteGive(gid);
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/gives/{gid}")
	@GET
	public Response retrieveGive(@PathParam ("uid") String uid, @PathParam ("gid") String gid) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Account temp = bnm.searchAndReturn(uid);
			Give returnedGive = (Give) temp.searchAndReturn(new Give(), gid);
			String s = gson.toJson(returnedGive);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
	}
	
	@Path("/gives/{gid}")
	@GET
	public Response viewGive(@PathParam ("aid") String gid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Give returnedAsk = (Give) bnm.getEI(new Give(), gid);
		String s = gson.toJson(returnedAsk);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/accounts/{uid}/gives")
	@GET
	public Response getAllMyGives(@PathParam ("uid") String uid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Account temp = bnm.searchAndReturn(uid);
		ArrayList <Give> returnedGives= temp.getGives();
		String s = gson.toJson(returnedGives);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/gives")
	@GET
	public Response getAllGives(
			@DefaultValue ("") @QueryParam("key") String key,
			@DefaultValue ("01-01-1900") @QueryParam("start_date") String start_date,
			@DefaultValue ("01-01-3000") @QueryParam("end_date") String end_date
	) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String key_insensitive = key.toLowerCase();
			ArrayList <Give> returnedGives = (ArrayList<Give>) bnm.searchGiveQuery(key_insensitive, start_date, end_date);
			ArrayList <Give> returned_from_accounts = (ArrayList <Give>) bnm.searchAccountQueryReturnGives(key_insensitive, start_date, end_date);
			for (int i = 0; i < returned_from_accounts.size(); i++) {
				if (!returnedGives.contains(returned_from_accounts.get(i))) {
					returnedGives.add(returned_from_accounts.get(i));
				}
			}
			String s = gson.toJson(returnedGives);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e){
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
		
	}
	//Thank
	
	@Path("/accounts/{uid}/thanks")
	@POST
	public Response createThank(@PathParam ("uid") String uid, String json) throws NotFoundException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Thank t = mapper.readValue(json, Thank.class);
			t.setUID(uid);
			if (t.getId() == "") {
				t.setTid(UUID.randomUUID().toString());
			}
			this.bnm.searchAndReturn(uid).addThank(t);
			//the following method will work when there is an active
			//account to send to
//			this.bnm.searchAndReturn(t.getThankTo()).addThankFrom(t);
			this.bnm.addNewThank(t);
			URI askLocation = new URI("/rest-BN/api/accounts/" + uid + "/thanks/" + t.getId());
			return Response.status(Response.Status.OK).location(askLocation).build();
//			return Response.status(Response.Status.OK).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/thanks/{aid}")
	@PUT
	public Response updateThank(@PathParam ("uid") String uid, @PathParam ("aid") String id, String json) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper mapper = new ObjectMapper();
			Thank t = mapper.readValue(json, Thank.class);
			Account temp = bnm.searchAndReturn(uid);
			Thank pulledThank = (Thank) temp.searchAndReturn(new Thank(), id);
			Thank returnedThank = (Thank) temp.searchAndUpdate(id, new Thank(), t);
			if(pulledThank.getThankTo() != returnedThank.getThankTo()) {
				this.bnm.searchAndReturn(returnedThank.getThankTo()).addThankFrom(returnedThank);
			}
			//update the ask in the bn manager
			bnm.searchAndUpdate(id, t);
			String s = gson.toJson(returnedThank);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/thanks/{tid}")
	@GET
	public Response viewThank(@PathParam ("tid") String tid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Thank returnedThank = (Thank) bnm.getEI(new Ask(), tid);
		String s = gson.toJson(returnedThank);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/accounts/{uid}/thanks/{tid}")
	@GET
	public Response retrieveThank(@PathParam ("uid") String uid, @PathParam ("tid") String tid) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Account temp = bnm.searchAndReturn(uid);
			Thank returnedThank = (Thank) temp.searchAndReturn(new Thank(), tid);
			String s = gson.toJson(returnedThank);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
	}
	
	@Path("/accounts/{uid}/thanks")
	@GET
	public Response getAllMyThanks(@PathParam ("uid") String uid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Account temp = bnm.searchAndReturn(uid);
		ArrayList <Thank> returnedThanks= temp.getThanks();
		String s = gson.toJson(returnedThanks);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/thanks")
	@GET
	public Response getAllThanks(
			@DefaultValue ("") @QueryParam("key") String key,
			@DefaultValue ("01-01-1900") @QueryParam("start_date") String start_date,
			@DefaultValue ("01-01-3000") @QueryParam("end_date") String end_date
			) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String key_insensitive = key.toLowerCase();
			ArrayList <Thank> returnedThanks = (ArrayList<Thank>) bnm.searchThankQuery(key_insensitive, start_date, end_date);
			ArrayList <Thank> returned_from_accounts = (ArrayList <Thank>) bnm.searchAccountQueryReturnThanks(key_insensitive, start_date, end_date);
			for (int i = 0; i < returned_from_accounts.size(); i++) {
				if (!returnedThanks.contains(returned_from_accounts.get(i))) {
					returnedThanks.add(returned_from_accounts.get(i));
				}
			}
			String s = gson.toJson(returnedThanks);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e){
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/thanks/received/{uid}")
	@GET
	public Response getAllToThanks(@PathParam ("uid") String uid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Account temp = bnm.searchAndReturn(uid);
		ArrayList <Thank> returnedThanks= temp.getThanksFrom();
		String s = gson.toJson(returnedThanks);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	//Notes
	
	@Path("/notes") 
	@POST
	public Response createNote(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Note n = mapper.readValue(json, Note.class);
			this.bnm.searchAndReturn(n.getUID()).addNote(n);
			this.bnm.addNewNote(n);
			URI askLocation = new URI("/rest-BN/api/notes/" + n.getId());
			return Response.status(Response.Status.OK).location(askLocation).build();
	//		return Response.status(Response.Status.OK).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/notes")
	@GET
	public Response getAllNotes(
			@DefaultValue ("") @QueryParam("c_by") String c_by,
			@DefaultValue ("") @QueryParam("v_by") String v_by,
			@DefaultValue ("") @QueryParam("type") String type,
			@DefaultValue ("") @QueryParam("agid") String agid,
			@DefaultValue ("") @QueryParam("key") String key,
			@DefaultValue ("01-01-1900") @QueryParam("start_date") String start_date,
			@DefaultValue ("01-01-3000") @QueryParam("end_date") String end_date
			) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String key_insensitive = key.toLowerCase();
			ArrayList <Note> returnedNotes = (ArrayList<Note>) bnm.searchNoteQuery(c_by, v_by, type, agid, key_insensitive, start_date, end_date);
			String s = gson.toJson(returnedNotes);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/notes/{nid}")
	@GET
	public Response viewNote(@PathParam ("nid") String nid) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Note returnedThank = (Note) bnm.getEI(new Note(), nid);
		String s = gson.toJson(returnedThank);
		return Response.status(Response.Status.OK).entity(s).build();
	}
	
	@Path("/notes/{nid}")
	@DELETE
	public Response deleteNote(@PathParam ("nid") String nid) {
		try {
			bnm.searchAndDeleteNote(nid);
			//delete from bn manager
			return Response.status(Response.Status.NO_CONTENT).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@Path("/notes/{nid}")
	@PUT
	public Response updateNote(@PathParam ("nid") String nid, String json) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper mapper = new ObjectMapper();
			Note n = mapper.readValue(json, Note.class);
			//update the give in the bn manager
			bnm.searchAndUpdate(nid, n);
			String s = gson.toJson(n);
			return Response.status(Response.Status.OK).entity(s).build();
		}
		catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
}
		
