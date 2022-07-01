package br.com.alura.rh.service;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

    public void promover(final Funcionario funcionario, final boolean metaBatida) {
        final var cargoAtual = funcionario.getCargo();
        if (Cargo.GERENTE.equals(cargoAtual)) {
            throw new ValidacaoException("Gerentes não podem ser promovidos!");
        }
        if (metaBatida) {
            final var novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Funcionário não bateu a meta!");
        }
    }
}
