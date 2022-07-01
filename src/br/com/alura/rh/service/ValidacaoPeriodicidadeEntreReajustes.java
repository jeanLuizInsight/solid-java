package br.com.alura.rh.service;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    public void validar(final Funcionario funcionario, final BigDecimal aumento) {
        final var dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        final var dataAtual = LocalDate.now();
        final var mesesUltimoreajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
        if (mesesUltimoreajuste < 6) {
            throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses!");
        }
    }
}
