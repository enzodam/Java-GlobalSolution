package br.com.fiap.resource;

import br.com.fiap.bo.ManutencaoBO;
import br.com.fiap.to.ManutencaoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/RecargaMaps/manutencao")
public class ManutencaoResource {
    private ManutencaoBO manutencaoBO = new ManutencaoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        ArrayList<ManutencaoTO> resultado = manutencaoBO.findAll();

        Response.ResponseBuilder response = null;

        if (resultado != null) {

            response = Response.ok();

        } else {

            // 404 (NOT FOUND)
            response = Response.status(404);

        }

        response.entity(resultado);

        return response.build();

    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {

        ManutencaoTO resultado = manutencaoBO.findByCodigo(codigo);

        Response.ResponseBuilder response = null;

        if (resultado != null) {

            // 200 (OK)
            response = Response.ok();

        } else {

            // 404 (NOT FOUND)
            response = Response.status(404);

        }

        response.entity(resultado);

        return response.build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ManutencaoTO manutencao) {

        ManutencaoTO resultado = manutencaoBO.save(manutencao);

        Response.ResponseBuilder response = null;

        if (resultado != null) {

            // 201 (CREATED)
            response = Response.created(null);

        } else {

            // 400 (BAD REQUEST)
            response = Response.status(400);

        }

        response.entity(resultado);

        return response.build();

    }

    @DELETE
    @Path("/{codigo}")
    public Response delete(@PathParam("codigo") Long codigo) {

        Response.ResponseBuilder response = null;

        if (manutencaoBO.delete(codigo)) {

            // 204 (NO CONTENT)
            response = Response.status(204);

        } else {

            // 404 (NOT FOUND)
            response = Response.status(404);

        }

        return response.build();

    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ManutencaoTO manutencao, @PathParam("codigo") Long codigo) {

        manutencao.setCodigo(codigo);

        ManutencaoTO resultado = manutencaoBO.update(manutencao);

        Response.ResponseBuilder response = null;

        if (resultado != null) {

            // 201 (CREATED)
            response = Response.created(null);

        } else {

            // 400 (BAD REQUEST)
            response = Response.status(400);

        }

        response.entity(resultado);

        return response.build();

    }

}

