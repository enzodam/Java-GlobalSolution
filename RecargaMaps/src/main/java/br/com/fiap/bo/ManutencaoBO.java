package br.com.fiap.bo;


import br.com.fiap.dao.ManutencaoDAO;
import br.com.fiap.to.ManutencaoTO;

import java.util.ArrayList;

public class ManutencaoBO {
    private ManutencaoDAO manutencaoDAO;


    public ArrayList<ManutencaoTO> findAll() {

        manutencaoDAO = new ManutencaoDAO();

        return manutencaoDAO.findAll();

    }

    public ManutencaoTO findByCodigo(Long codigo) {

        manutencaoDAO = new ManutencaoDAO();

        return manutencaoDAO.findByCodigo(codigo);

    }

    public ManutencaoTO save(ManutencaoTO manutencao) {

        manutencaoDAO = new ManutencaoDAO();

        return manutencaoDAO.save(manutencao);

    }

    public boolean delete(Long codigo) {

        manutencaoDAO = new ManutencaoDAO();

        return manutencaoDAO.delete(codigo);

    }

    public ManutencaoTO update(ManutencaoTO manutencao) {

        manutencaoDAO = new ManutencaoDAO();

        return manutencaoDAO.update(manutencao);

    }
}
