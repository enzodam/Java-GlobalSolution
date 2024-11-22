package br.com.fiap.bo;


import br.com.fiap.dao.BombaDeRecargaDAO;
import br.com.fiap.to.BombaDeRecargaTO;

import java.util.ArrayList;

public class BombaDeRecargaBO {

    private BombaDeRecargaDAO bombaDeRecargaDAO;


    public ArrayList<BombaDeRecargaTO> findAll() {

        bombaDeRecargaDAO = new BombaDeRecargaDAO();

        return bombaDeRecargaDAO.findAll();

    }

    public BombaDeRecargaTO findByCodigo(Long codigo) {

        bombaDeRecargaDAO = new BombaDeRecargaDAO();

        return bombaDeRecargaDAO.findByCodigo(codigo);

    }

    public BombaDeRecargaTO save(BombaDeRecargaTO bombaDeRecarga) {

        bombaDeRecargaDAO = new BombaDeRecargaDAO();

        return bombaDeRecargaDAO.save(bombaDeRecarga);

    }

    public boolean delete(Long codigo) {

        bombaDeRecargaDAO = new BombaDeRecargaDAO();

        return bombaDeRecargaDAO.delete(codigo);

    }

    public BombaDeRecargaTO update(BombaDeRecargaTO bombaDeRecarga) {

        bombaDeRecargaDAO = new BombaDeRecargaDAO();

        return bombaDeRecargaDAO.update(bombaDeRecarga);

    }

}
