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

import com.jay.model.Player;
import com.jay.repository.PlayerRepository;

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
	@Path("/player/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(@PathParam("username") String username) {
		if (playerRepository.getPlayer(username).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Player player = playerRepository.getPlayer(username);
		return Response.ok(player).build();
	}
	
	@GET
	@Path("/accounts")
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
	@Path("/player/{username}")
	public Response updatePlayer(Player player, @PathParam("username") String username) {
		if (playerRepository.getPlayer(username).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Player retrievedPlayer = playerRepository.updatePlayer(username, player);
		return Response.ok(retrievedPlayer).build();
	}
	
	@DELETE
	@Path("/player/{username}")
	public Response deletePlayer(@PathParam("username") String username) {
		if (playerRepository.getPlayer(username).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		playerRepository.deletePlayer(username);
		return Response.noContent().build();
	}
	
	
}

