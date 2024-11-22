package br.com.fiap.bo;


import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.to.PagamentoTO;

import java.util.ArrayList;

public class PagamentoBO {
    private PagamentoDAO pagamentoDAO;


    public ArrayList<PagamentoTO> findAll() {

        pagamentoDAO = new PagamentoDAO();

        return pagamentoDAO.findAll();

    }

    public PagamentoTO findByCodigo(Long codigo) {

        pagamentoDAO = new PagamentoDAO();

        return pagamentoDAO.findByCodigo(codigo);

    }

    public PagamentoTO save(PagamentoTO pagamento) {

        pagamentoDAO = new PagamentoDAO();

        return pagamentoDAO.save(pagamento);

    }

    public boolean delete(Long codigo) {

        pagamentoDAO = new PagamentoDAO();

        return pagamentoDAO.delete(codigo);

    }

    public PagamentoTO update(PagamentoTO pagamento) {

        pagamentoDAO = new PagamentoDAO();

        return pagamentoDAO.update(pagamento);

    }
}
