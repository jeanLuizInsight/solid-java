package br.com.alura.rh.service;

import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void validar(final Funcionario funcionario, final BigDecimal aumento);
}
