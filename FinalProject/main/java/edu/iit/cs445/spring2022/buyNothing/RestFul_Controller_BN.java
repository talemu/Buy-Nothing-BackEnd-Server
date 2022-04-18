package edu.iit.cs445.spring2022.buyNothing;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.*;

// Pingable at http://localhost:8080/rest-lamp/api/demo/lamps
//   rest-lamp:		the basename of the WAR file, see the gradle.build file
//   api:			see the @ApplicationPath annotation in LampDemo.java
//   demo:			see the @Path annotation *above* the REST_controller declaration in this file
//   lamps:			see the @Path declaration above the first @GET in this file

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class RestFul_Controller_BN {
	
	//Account Methods
	@Path("/accounts/[uid]")
	@POST
	public Response createAccount(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//going to need two responses
		//1st being a success (201) and 2nd being a bad request (400) (if data is missing)
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/activate")
	@GET
	public Response activateAccount(@PathParam("uid") UUID uid) {
		//needs implementation
		
		//Needs 3 responses
		//Good response (200), Bad Request(400) (if data is missing)
		//Not Found, if the the UID doesn't exist
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/")
	@PUT
	public Response updateAccount(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//Needs 3 responses
	    //204 (No content) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) the account identified by [uid] doesn't exist.
		
		return Response.status(0).build();
	}
	
	@Path("/accounts/uid")
	@DELETE
	public Response deleteAccount(@PathParam("uid") UUID uid) {
		//Needs implementation
		
		//Needs 2 responses
		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if the account identified by [uid] doesn't exist.
		return Response.status(0).build();
	}
	
	@Path("/accounts")
	@GET
	public Response getAllAccounts() {
		//Needs implementation
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]")
	@GET
	public Response viewAccount(@PathParam("uid") UUID uid) {
		//Needs implementation
		
		//Needs 2 responses
		//200 (OK).
	    //404 (Not Found) if the account identified by [uid] doesn't exist.
		
		return Response.status(0).build();
	}
	
	@Path("/accounts?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
	@GET
	public Response searchAccount() {
		//need to implement variables that can handle path parameters
		
		return Response.status(0).build();
	}
	
	//ASK methods
	//ASK methods
	//ASK methods
	//ASK methods
	//ASK methods
	//ASK methods
	
	
	@Path("/accounts/[uid]/asks")
	@POST
	public Response createAsk(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//going to need three responses:
		//201 (Created) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) if 'uid' doesn't exist.

		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/asks/[aid]/deactivate")
	@GET
	public Response deactivateAccount(@PathParam("uid") UUID uid, @PathParam("aid") AAID aid) {
		//needs implementation
		
		//Needs 3 responses
		//Good response (200), Bad Request(400) (if data is missing)
		//Not Found (404), if the the UID or AID doesn't exist
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/asks/[aid]")
	@PUT
	public Response updateAsk(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//Needs 3 responses
	    //204 (No content) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) the account identified by [uid] doesn't exist.
		
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/asks/[aid]")
	@DELETE
	public Response deleteAsk(@PathParam("uid") UUID uid, @PathParam("aid") AAID aid) {
		//Needs implementation
		
		//Needs 2 responses
		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if the account identified by [uid] doesn't exist.
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/asks{?is_active=[true|false]}")
	@GET
	public Response getMyAsks(@PathParam("uid") UUID uid) {
		
		//returns asks of specified uid, is active parameter is optional
		//Needs implmentation
		
	    //200 (OK).
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) if 'uid' doesn't exist.
		
		return Response.status(0).build();
	}
	
	@Path("/asks?v_by=viewed_by_id&is_active=[true|false]")
	@GET
	public Response getAllAsks() {
		//Needs implementation
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/asks/[aid]")
	@GET
	public Response viewAsk(@PathParam("aid") AAID aid) {
		
		//Needs implementation
		
		//Needs 2 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/asks?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
	@GET
	public Response searchAsk() {
		//need to implement variables that can handle path parameters
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
	
	
	//give methods
	//give methods
	//give methods
	//give methods
	//give methods
	
	@Path("/accounts/[uid]/give")
	@POST
	public Response createGive(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//going to need three responses:
		//201 (Created) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) if 'uid' doesn't exist.

		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/gives/[gid]/deactivate")
	@GET
	public Response deactivateGive(@PathParam("uid") UUID uid, @PathParam("aid") GGID gid) {
		//needs implementation
		
		//Needs 3 responses
		//Good response (200), Bad Request(400) (if data is missing)
		//Not Found (404), if the the UID or GID doesn't exist
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/asks/[aid]")
	@DELETE
	public Response deleteAsk(@PathParam("uid") UUID uid, @PathParam("aid") GGID gid) {
		//Needs implementation
		
		//Needs 2 responses
		//204 (No content) if the account has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if the account identified by [uid] doesn't exist.
		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/gives{?is_active=[true|false]}")
	@GET
	public Response getMyGives(@PathParam("uid") UUID uid) {
		
		//returns asks of specified uid, is active parameter is optional
		//Needs implementation
		
	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if the account identified by [uid], or the give identified by [gid] doesn't exist.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.

		
		return Response.status(0).build();
	}
	
	@Path("/gives?v_by=viewed_by_id&is_active=[true|false]")
	@GET
	public Response getAllGives() {
		//Needs implementation
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/give/[gid]")
	@GET
	public Response viewGive(@PathParam("aid") GGID gid) {
		
		//Needs implementation
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/give?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
	@GET
	public Response searchGive() {
		//need to implement variables that can handle path parameters
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
	
	//thank methods
	//thank methods
	//thank methods
	//thank methods
	//thank methods
	
	@Path("/accounts/[uid]/thanks")
	@POST
	public Response createThank(@PathParam("uid") UUID uid, String json) {
		//needs implementation
		
		//going to need three responses:
		//201 (Created) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) if 'uid' doesn't exist.

		return Response.status(0).build();
	}
	
	@Path("/accounts/[uid]/gives/[tid]")
	@PUT
	public Response updateThank(@PathParam("uid") UUID uid, @PathParam("tid") TTID tid, String json) {
		//needs implementation
		
		//Needs 3 responses
	    //204 (No content) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) the account identified by [uid] doesn't exist.
		
		return Response.status(0).build();
	}
	
	
	@Path("/accounts/[uid]/thanks")
	@GET
	public Response getMyThanks(@PathParam("uid") UUID uid) {
		
		//returns asks of specified uid, is active parameter is optional
		//Needs implementation
		
	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if the account identified by [uid], or the give identified by [gid] doesn't exist.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.

		
		return Response.status(0).build();
	}
	
	@Path("/thanks")
	@GET
	public Response getAllThanks() {
		//Needs implementation
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/thanks/[tid]")
	@GET
	public Response viewThank(@PathParam("aid") TTID tid) {
		
		//Needs implementation
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/thanks/received/[uid]")
	@GET
	public Response viewThanksForUser(@PathParam("uid") UUID uid) {
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
	
	@Path("/thanks?key=keyword{&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY}")
	@GET
	public Response searchThanks() {
		//need to implement variables that can handle path parameters
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
	
	//note methods
	//note methods
	//note methods
	//note methods
	//note methods
	
	@Path("/notes")
	@POST
	public Response createNote(String json) {
		//needs implementation
		
		//going to need three responses:
		//201 (Created) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.

		return Response.status(0).build();
	}
	
	@Path("/notes/[nid]")
	@PUT
	public Response updateNote(@PathParam("nid") NNID nid, String json) {
		//needs implementation
		
		//Needs 3 responses
	    //204 (No content) if everything is ok.
	    //400 (Bad Request) if any of the required data is missing or is invalid. In this case the body of the response should contain JSON that explains what went wrong.
	    //404 (Not found) the note identified by [nid] doesn't exist.
		
		return Response.status(0).build();
	}
	
	
	@Path("/notes/[nid]")
	@DELETE
	public Response deleteNote(@PathParam("nid") NNID nid) {
		
		//returns asks of specified uid, is active parameter is optional
		//Needs implementation
		
	    //204 (No content) if the give has been removed and there is no additional information in the body of the response.
	    //404 (Not found) if nid does not exist
		
		return Response.status(0).build();
	}
	
	@Path("/notes{?c_by=created_by_id&v_by=viewed_by_id&type=[ask|give]&agid=ask_or_give_id}")
	@GET
	public Response viewNotes() {
		
		//Needs implementation with optional parameters in PathParams
		
		//Needs 1 responses
		//200 (OK).
		
		return Response.status(0).build();
	}
	
	@Path("/thanks/received/[nid]")
	@GET
	public Response viewNote(@PathParam("nid") NNID nid) {
		
		//Needs 1 response
		//200 (ok)
		//404 (Not found) if [nid] doesn't exist. 
		
		return Response.status(0).build();
	}
	
	//report method
	//report method
	//report method
	
	@Path("/reports/[rid]?c_by=created_by_id&v_by=viewed_by_id&start_date=DD-MMM-YYYY&end_date=DD-MMM-YYYY")
	@GET
	public Response searchNotes() {
		//need to implement variables that can handle path parameters
		
		//Needs 1 response
		//200 (ok)
		
		return Response.status(0).build();
	}
}
