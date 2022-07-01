package br.com.alura.rh.service;

import br.com.alura.rh.exception.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReajusteService  {

    private List<ValidacaoReajuste> validacoesReajuste;

    public ReajusteService(List<ValidacaoReajuste> validacoesReajuste) {
        this.validacoesReajuste = validacoesReajuste;
    }

    public void reajustarSalarioDoFuncionario(final Funcionario funcionario, final BigDecimal aumento) {
        this.validacoesReajuste.forEach(val -> val.validar(funcionario, aumento));
        final var salarioAjustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioAjustado);
    }
}
