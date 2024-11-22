package br.com.fiap.bo;

import br.com.fiap.dao.RecargaDAO;
import br.com.fiap.to.RecargaTO;

import java.util.ArrayList;

public class RecargaBO {
    private RecargaDAO recargaDAO;


    public ArrayList<RecargaTO> findAll() {

        recargaDAO = new RecargaDAO();

        return recargaDAO.findAll();

    }

    public RecargaTO findByCodigo(Long codigo) {

        recargaDAO = new RecargaDAO();

        return recargaDAO.findByCodigo(codigo);

    }

    public RecargaTO save(RecargaTO recarga) {

        recargaDAO = new RecargaDAO();

        return recargaDAO.save(recarga);

    }

    public boolean delete(Long codigo) {

        recargaDAO = new RecargaDAO();

        return recargaDAO.delete(codigo);

    }

    public RecargaTO update(RecargaTO recarga) {

        recargaDAO = new RecargaDAO();

        return recargaDAO.update(recarga);

    }
}
