package br.com.atacadao.service;

import br.com.atacadao.dto.ProductDTO;
import br.com.atacadao.dto.Ifood.ProductIfoodDTO;
import br.com.atacadao.dto.Ifood.ProductIfoodMapper;
import br.com.atacadao.config.IfoodRestClient;
import br.com.atacadao.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductIfoodService {
    private static final Logger LOG = Logger.getLogger(ProductIfoodService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final IfoodRestClient restClient;
    private final ProdutoRepository produtoRepository;
    private final String merchantId;

    @Inject
    public ProductIfoodService(
            @RestClient IfoodRestClient restClient,
            ProdutoRepository produtoRepository,
            @ConfigProperty(name = "ifood-api.merchant.id") String merchantId) {
        this.restClient = restClient;
        this.produtoRepository = produtoRepository;
        this.merchantId = merchantId;
    }

    public boolean enviarProdutosPorFilialParaIfood(Long idFilial, String token) throws Exception {
        LOG.info("Iniciando envio de produtos para o iFood. Filial: " + idFilial);
        
        List<ProductDTO> produtos = produtoRepository.buscarProdutosPorFilial(idFilial);
        LOG.info("Produtos encontrados no banco: " + produtos.size());

        if (produtos.isEmpty()) {
            LOG.warn("Nenhum produto encontrado para enviar ao iFood");
            return false;
        }

        List<ProductIfoodDTO> dtos = produtos.stream()
                .map(ProductIfoodMapper::toIfood)
                .collect(Collectors.toList());
        LOG.info("Produtos convertidos para formato iFood: " + dtos.size());

        try {
            // Log do primeiro produto para debug
            if (!dtos.isEmpty()) {
                String jsonProduto = objectMapper.writeValueAsString(List.of(dtos.get(0)));
                LOG.info("Exemplo do primeiro produto a ser enviado: " + jsonProduto);
            }

            LOG.info("Enviando produtos para o iFood. MerchantId: " + merchantId);
            LOG.info("Token utilizado (primeiros 50 caracteres): " + token.substring(0, Math.min(token.length(), 50)) + "...");
            LOG.info("URL da chamada: https://merchant-api.ifood.com.br/item/v1.0/ingestion/" + merchantId + "?reset=false");
            
            restClient.enviarProdutos(token, "*/*", merchantId, false, dtos);
            LOG.info("Produtos enviados com sucesso para o iFood");
            return true;
        } catch (Exception e) {
            LOG.error("Erro ao enviar produtos para o iFood", e);
            if (e instanceof jakarta.ws.rs.WebApplicationException) {
                jakarta.ws.rs.WebApplicationException webEx = (jakarta.ws.rs.WebApplicationException) e;
                String responseBody = webEx.getResponse().readEntity(String.class);
                LOG.error("Resposta do erro: " + responseBody);
            }
            throw e;
        }
    }
}
