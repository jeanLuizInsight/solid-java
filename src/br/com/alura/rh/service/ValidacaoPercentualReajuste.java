package br.com.alura.rh.service;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {

    public void validar(final Funcionario funcionario, final BigDecimal aumento) {
        final var salario = funcionario.getSalario();
        final var percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }
}
