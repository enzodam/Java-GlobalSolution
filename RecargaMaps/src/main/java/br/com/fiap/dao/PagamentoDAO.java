package br.com.fiap.dao;


import br.com.fiap.to.PagamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoDAO extends Repository {
    public ArrayList<PagamentoTO> findAll() {

        ArrayList<PagamentoTO> pagamentos = new ArrayList<>();

        String sql = "select * from ddd_pagamento order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    PagamentoTO pagamento = new PagamentoTO();

                    pagamento.setCodigo(rs.getLong("codigo"));
                    pagamento.setMetodoPagamento(rs.getString("metodoPagamento"));
                    pagamento.setValorPago(rs.getDouble("valorPago"));
                    pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());


                    pagamentos.add(pagamento);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return pagamentos;

    }

    public PagamentoTO findByCodigo(Long codigo) {

        PagamentoTO pagamento = new PagamentoTO();

        String sql = "select * from ddd_pagamento where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                pagamento.setCodigo(rs.getLong("codigo"));
                pagamento.setMetodoPagamento(rs.getString("metodoPagamento"));
                pagamento.setValorPago(rs.getDouble("valorPago"));
                pagamento.setDataPagamento(rs.getDate("dataPagamento").toLocalDate());


            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return pagamento;

    }

    public PagamentoTO save(PagamentoTO pagamento) {

        String sql = "insert into ddd_pagamento( metodoPagamento, valorPago, dataPagamento) values(?, ?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, pagamento.getMetodoPagamento());
            ps.setDouble(2, pagamento.getValorPago());
            ps.setDate(3, java.sql.Date.valueOf(pagamento.getDataPagamento()));

            if (ps.executeUpdate() > 0) {

                return pagamento;

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro ao salvar: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return null;

    }

    public boolean delete(Long codigo) {

        String sql = "delete from ddd_pagamento where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Erro ao excluir: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return false;

    }

    public PagamentoTO update(PagamentoTO pagamento) {

        String sql = "update ddd_pagamento set metodoPagamento=?, valorPago=?, dataPagamento=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, pagamento.getMetodoPagamento());
            ps.setDouble(2, pagamento.getValorPago());
            ps.setDate(3, java.sql.Date.valueOf(pagamento.getDataPagamento()));
            ps.setLong(4, pagamento.getCodigo());

            if (ps.executeUpdate() > 0) {

                return pagamento;

            } else {

                return null;

            }


        } catch (SQLException e) {

            System.out.println("Erro ao atualizar: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return null;

    }
}

