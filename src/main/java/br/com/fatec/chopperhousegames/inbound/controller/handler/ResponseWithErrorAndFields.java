package br.com.fatec.chopperhousegames.inbound.controller.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWithErrorAndFields {

    private String codigo;

    private String mensagem;

    private Map<String, String> campos;

}
