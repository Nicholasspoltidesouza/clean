package com.projarc.clean.adapter;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projarc.clean.application.dto.PagamentoDTO;
import com.projarc.clean.application.dto.PagamentoNovoDTO;
import com.projarc.clean.application.usecase.CriarPagamentoUC;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PagamentoController {

    private final CriarPagamentoUC criarPagamentoUC;

    @Operation(description = "Realiza um pagamento de uma assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PagamentoDTO.class))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/registrarpagamento")
    public ResponseEntity<PagamentoDTO> registrarPagamento(@RequestBody PagamentoNovoDTO pagamento) {
        return ResponseEntity.ok(criarPagamentoUC.run(pagamento.getIdAssinatura(), pagamento.getValorPago(),
                pagamento.getPromocao()));
    }

}
