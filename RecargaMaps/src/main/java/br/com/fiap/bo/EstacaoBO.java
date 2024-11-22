package br.com.fiap.bo;

import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.to.EstacaoTO;

import java.util.ArrayList;

public class EstacaoBO {
    private EstacaoDAO estacaoDAO;


    public ArrayList<EstacaoTO> findAll() {

        estacaoDAO = new EstacaoDAO();

        return estacaoDAO.findAll();

    }

    public EstacaoTO findByCodigo(Long codigo) {

        estacaoDAO = new EstacaoDAO();

        return estacaoDAO.findByCodigo(codigo);

    }

    public EstacaoTO save(EstacaoTO estacao) {

        estacaoDAO = new EstacaoDAO();

        return estacaoDAO.save(estacao);

    }

    public boolean delete(Long codigo) {

        estacaoDAO = new EstacaoDAO();

        return estacaoDAO.delete(codigo);

    }

    public EstacaoTO update(EstacaoTO estacao) {

        estacaoDAO = new EstacaoDAO();

        return estacaoDAO.update(estacao);

    }
}
