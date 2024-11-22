package br.com.fiap.bo;


import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.to.AvaliacaoTO;

import java.util.ArrayList;

public class AvaliacaoBO {
    private AvaliacaoDAO avaliacaoDAO;


    public ArrayList<AvaliacaoTO> findAll() {

        avaliacaoDAO = new AvaliacaoDAO();

        return avaliacaoDAO.findAll();

    }

    public AvaliacaoTO findByCodigo(Long codigo) {

        avaliacaoDAO = new AvaliacaoDAO();

        return avaliacaoDAO.findByCodigo(codigo);

    }

    public AvaliacaoTO save(AvaliacaoTO avaliacao) {

        avaliacaoDAO = new AvaliacaoDAO();

        return avaliacaoDAO.save(avaliacao);

    }

    public boolean delete(Long codigo) {

        avaliacaoDAO = new AvaliacaoDAO();

        return avaliacaoDAO.delete(codigo);

    }

    public AvaliacaoTO update(AvaliacaoTO avaliacao) {

        avaliacaoDAO = new AvaliacaoDAO();

        return avaliacaoDAO.update(avaliacao);

    }
}
