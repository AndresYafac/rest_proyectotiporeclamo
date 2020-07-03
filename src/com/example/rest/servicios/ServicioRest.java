package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.TipoDeReclamo;
import com.example.rest.dao.TipoDeReclamoModel;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);

	private TipoDeReclamoModel daoTipo = new TipoDeReclamoModel();


	// Crud de tipoReclamo
	@GET
	@Path("/tiporeclamo")
	public Response listartipoReclamoTodos() {
		log.info("listars tiporeclamo rest ");
		return Response.ok(daoTipo.listartipoReclamoTodos()).build();
	}

	@POST
	@Path("/tiporeclamo")
	public Response registratipoReclamo(TipoDeReclamo obj) {
		log.info("Registra rol " + obj.getIdTipo());
		if (daoTipo.insertatipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/tiporeclamo")
	public Response atualizatipoReclamo(TipoDeReclamo obj) {
		log.info("Actualiza rol " + obj.getIdTipo());
		if (daoTipo.actualizatipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/tiporeclamo/{idTipo}")
	public Response eliminatipoReclamo(@PathParam("idTipo") int id) {
		log.info("Elimina tiporeclamo " + id);
		if (daoTipo.eliminatipoReclamo(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}