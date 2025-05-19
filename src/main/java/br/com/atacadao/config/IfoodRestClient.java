package br.com.atacadao.config;

import br.com.atacadao.dto.Ifood.ProductIfoodDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "ifood-api")
@Path("/item/v1.0/ingestion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IfoodRestClient {

    @POST
    @Path("/{merchantId}")
    void enviarProdutos(
            @HeaderParam("Authorization") String token,
            @HeaderParam("accept") String accept,
            @PathParam("merchantId") String merchantId,
            @QueryParam("reset") boolean reset,
            List<ProductIfoodDTO> produtos
    );
}
