package com.projarc.clean.adapter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import com.projarc.clean.application.dto.AssinaturaDTO;
import com.projarc.clean.application.dto.AssinaturaNovaDTO;
import com.projarc.clean.application.usecase.CriarAssinaturaUC;
import com.projarc.clean.application.usecase.ListarAssinaturaPorTipoUC;
import com.projarc.clean.application.usecase.ListarAssinaturasDeUmClienteUC;
import com.projarc.clean.application.usecase.ListarTodasAssinaturasUC;
import com.projarc.clean.persistence.enumeration.AssinaturaStatusEnum;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/servcad")
public class AssinaturaController {

    private final ListarAssinaturaPorTipoUC listarAssinaturaPorTipoUC;
    private final ListarTodasAssinaturasUC listarTodasAssinaturasUC;
    private final CriarAssinaturaUC criarAssinaturaUC;
    private final ListarAssinaturasDeUmClienteUC listarAssinaturasDeUmClienteUC;

    @Operation(description = "Lista assinaturas por tipo (todas, ativas ou canceladas)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AssinaturaDTO.class)))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/assinaturas/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        if (tipo.equals("todas")) {
            return ResponseEntity.ok(listarTodasAssinaturasUC.run());
        } else if (tipo.equals("ativas")) {
            return ResponseEntity.ok(listarAssinaturaPorTipoUC.run(AssinaturaStatusEnum.ATIVA));
        } else if (tipo.equals("canceladas")) {
            return ResponseEntity.ok(listarAssinaturaPorTipoUC.run(AssinaturaStatusEnum.CANCELADA));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(description = "Cadastra assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AssinaturaDTO.class))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/assinaturas")
    public ResponseEntity<AssinaturaDTO> cadastrarAssinatura(@RequestBody AssinaturaNovaDTO assinatura) {
        return new ResponseEntity<AssinaturaDTO>(
                criarAssinaturaUC.run(assinatura.getCodigoCliente(), assinatura.getCodigoAplicativo()),
                HttpStatus.CREATED);
    }

    @Operation(description = "Lista de assinaturas de um cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AssinaturaDTO.class)))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/asscli/{codigoCliente}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasDeUmCliente(@PathVariable Long codigoCliente) {
        return ResponseEntity.ok(listarAssinaturasDeUmClienteUC.run(codigoCliente));
    }
}
