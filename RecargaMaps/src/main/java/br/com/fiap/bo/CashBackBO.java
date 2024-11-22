package br.com.fiap.bo;

import br.com.fiap.dao.CashBackDAO;
import br.com.fiap.to.CashBackTO;

import java.util.ArrayList;

public class CashBackBO {

    private CashBackDAO cashBackDAO;


    public ArrayList<CashBackTO> findAll() {

        cashBackDAO = new CashBackDAO();

        return cashBackDAO.findAll();

    }

    public CashBackTO findByCodigo(Long codigo) {

        cashBackDAO = new CashBackDAO();

        return cashBackDAO.findByCodigo(codigo);

    }

    public CashBackTO save(CashBackTO cashback) {

        cashBackDAO = new CashBackDAO();

        return cashBackDAO.save(cashback);

    }

    public boolean delete(Long codigo) {

        cashBackDAO = new CashBackDAO();

        return cashBackDAO.delete(codigo);

    }

    public CashBackTO update(CashBackTO cashback) {

        cashBackDAO = new CashBackDAO();

        return cashBackDAO.update(cashback);

    }

}
