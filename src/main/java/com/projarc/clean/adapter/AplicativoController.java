package com.projarc.clean.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projarc.clean.application.dto.AplicativoDTO;
import com.projarc.clean.application.usecase.ListarTodosAplicativosUC;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/servcad")
public class AplicativoController {

    private final ListarTodosAplicativosUC listarTodosAplicativosUC;

    @Autowired
    public AplicativoController(ListarTodosAplicativosUC listarTodosAplicativosUC) {
        this.listarTodosAplicativosUC = listarTodosAplicativosUC;
    }

    @Operation(description = "Lista todos os aplicativos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AplicativoDTO.class)))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/aplicativos")
    public ResponseEntity<List<AplicativoDTO>> listarAplicativos() {
        return ResponseEntity.ok(listarTodosAplicativosUC.run());
    }

}
