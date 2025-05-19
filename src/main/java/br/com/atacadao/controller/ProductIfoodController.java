package br.com.atacadao.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import br.com.atacadao.service.ProductIfoodService;

import java.util.Collections;

@Path("/ifood")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductIfoodController {
    private static final Logger LOG = Logger.getLogger(ProductIfoodController.class);

    @Inject
    ProductIfoodService service;

    @POST
    @Path("/sincronizar-produtos/{idFilial}")
    public Response sincronizarProdutosPorFilial(
            @PathParam("idFilial") Long idFilial,
            @HeaderParam("Authorization") String token) {
        LOG.info("Recebida requisição para sincronizar produtos. Filial: " + idFilial);
        
        if (token == null || token.isEmpty()) {
            LOG.warn("Token não fornecido no header Authorization");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Collections.singletonMap("erro", "Token não fornecido"))
                    .build();
        }

        if (!token.startsWith("Bearer ")) {
            token = "Bearer " + token;
        }
        
        try {
            boolean sucesso = service.enviarProdutosPorFilialParaIfood(idFilial, token);
            LOG.info("Sincronização concluída com sucesso: " + sucesso);
            return Response.ok(Collections.singletonMap("sucesso", sucesso)).build();
        } catch (Exception e) {
            LOG.error("Erro ao sincronizar produtos", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Collections.singletonMap("erro", e.getMessage()))
                    .build();
        }
    }
} 