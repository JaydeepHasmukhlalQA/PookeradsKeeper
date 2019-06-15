package com.jay.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.jay.model.Match;
import com.jay.repository.MatchRepository;

@Path("/")
public class MatchEndpoint {
	
	@Inject
	private MatchRepository matchRepository;
	
	@POST
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/match")
	public Response addMatch(Match match, @Context UriInfo uriInfo) {
		match = matchRepository.addMatch(match);
		URI createdUri = uriInfo.getBaseUriBuilder().path("" + match.getMatchName()).build();
		return Response.ok(createdUri.toString()).status(Status.CREATED).build();
	}
	
	@GET
	@Path("/player/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatchById(@PathParam("id") int id) {
		Match match = matchRepository.getMatchById(id);
		if (match.equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(match).build();
	}
	
	@GET
	@Path("/match/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayerByName(@PathParam("name") String name) {
		if (matchRepository.getMatchByName(name).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Match match = matchRepository.getMatchByName(name);
		return Response.ok(match).build();
	}
	
	@GET
	@Path("/match")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMatches() {
		List<Match> listOfMatches = matchRepository.getAllMatches();
		if (listOfMatches.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(listOfMatches).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({"application/json"})
	@Path("/name/{id}")
	public Response updateMatch(Match match, @PathParam("id") int id) {
		if (matchRepository.getMatchById(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Match retrievedMatch = matchRepository.updateMatch(id, match);
		return Response.ok(retrievedMatch).build();
	}
	
	@DELETE
	@Path("/match/{id}")
	public Response deleteMatch(@PathParam("id") int id) {
		if (matchRepository.getMatchById(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		matchRepository.deleteMatch(id);
		return Response.noContent().build();
	}
	
	
	
}
