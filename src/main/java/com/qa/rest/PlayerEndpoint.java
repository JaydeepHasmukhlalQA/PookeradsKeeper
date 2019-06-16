package com.qa.rest;

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

import com.qa.model.Player;
import com.qa.repository.PlayerRepository;

@Path("/")
public class PlayerEndpoint {

	@Inject
	private PlayerRepository playerRepository;
	
	@POST
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/player")
	public Response addPlayer(Player player, @Context UriInfo uriInfo) {
		player = playerRepository.addPlayer(player);
		URI createdUri = uriInfo.getBaseUriBuilder().path("" + player.getUsername()).build();
		return Response.ok(createdUri.toString()).status(Status.CREATED).build();
	}
	
	@GET
	@Path("/player/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayerById(@PathParam("id") int id) {
		Player player = playerRepository.getPlayerByID(id);
		if (player.equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(player).build();
	}
	
	@GET
	@Path("/player/user/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayerByName(@PathParam("username") String username) {
		if (playerRepository.getPlayerByName(username).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Player player = playerRepository.getPlayerByName(username);
		return Response.ok(player).build();
	}
	
	@GET
	@Path("/player")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPlayers() {
		List<Player> listOfPlayers = playerRepository.getAllPlayers();
		if (listOfPlayers.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok(listOfPlayers).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({"application/json"})
	@Path("/player/{id}")
	public Response updatePlayer(Player player, @PathParam("id") int id) {
		if (playerRepository.getPlayerByID(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Player retrievedPlayer = playerRepository.updatePlayer(id, player);
		return Response.ok(retrievedPlayer).build();
	}
	
	@DELETE
	@Path("/player/{id}")
	public Response deletePlayer(@PathParam("id") int id) {
		if (playerRepository.getPlayerByID(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		playerRepository.deletePlayer(id);
		return Response.noContent().build();
	}	
}

