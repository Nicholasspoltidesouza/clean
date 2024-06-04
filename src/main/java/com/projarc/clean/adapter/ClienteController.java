package com.projarc.clean.adapter;

import com.projarc.clean.application.dto.ClienteDTO;
import com.projarc.clean.application.usecase.ListarTodosClientesUC;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/servcad")
public class ClienteController {
    private ListarTodosClientesUC listarTodosClientesUC;

    @Autowired
    public void setListarTodosClientesUC(ListarTodosClientesUC listarTodosClientesUC) {
        this.listarTodosClientesUC = listarTodosClientesUC;
    }

    @Operation(description = "Lista todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))),
            @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/clientes")
    public ResponseEntity<Collection<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(listarTodosClientesUC.run());
    }
}
