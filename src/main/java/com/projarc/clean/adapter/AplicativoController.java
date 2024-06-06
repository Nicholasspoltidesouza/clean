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

import com.projarc.clean.application.dto.AplicativoDTO;
import com.projarc.clean.application.dto.AplicativoPatchDTO;
import com.projarc.clean.application.usecase.AtualizarCustoAplicativoUC;
import com.projarc.clean.application.usecase.ListarTodosAplicativosUC;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/servcad")
public class AplicativoController {

    private final ListarTodosAplicativosUC listarTodosAplicativosUC;

    private final AtualizarCustoAplicativoUC atualizarCustoAplicativoUC;

    @Operation(description = "Lista todos os aplicativos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AplicativoDTO.class)))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/aplicativos")
    public ResponseEntity<List<AplicativoDTO>> listarAplicativos() {
        return ResponseEntity.ok(listarTodosAplicativosUC.run());
    }

    @Operation(description = "Atualiza custo de um aplicativo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AplicativoDTO.class))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @PostMapping("/aplicativos/atualizacusto/{idAplicativo}")
    public ResponseEntity<AplicativoDTO> atualizarCustoAplicativo(@PathVariable Long idAplicativo,
            @RequestBody AplicativoPatchDTO aplicativoPatchDTO) {
        AplicativoDTO aplicativoAtualizado = atualizarCustoAplicativoUC.run(idAplicativo,
                aplicativoPatchDTO.custoMensal());
        return new ResponseEntity<>(aplicativoAtualizado, HttpStatus.OK);
    }

}
