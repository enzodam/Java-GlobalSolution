package br.com.fiap.resource;

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/RecargaMaps/carro")
public class CarroResource {
    private CarroBO carroBO = new CarroBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {

        ArrayList<CarroTO> resultado = carroBO.findAll();

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

        CarroTO resultado = carroBO.findByCodigo(codigo);

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
    public Response save(@Valid CarroTO carro) {

        CarroTO resultado = carroBO.save(carro);

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

        if (carroBO.delete(codigo)) {

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
    public Response update(@Valid CarroTO carro, @PathParam("codigo") Long codigo) {

        carro.setCodigo(codigo);

        CarroTO resultado = carroBO.update(carro);

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
