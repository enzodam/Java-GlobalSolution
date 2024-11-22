package br.com.fiap.dao;


import br.com.fiap.to.CashBackTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CashBackDAO extends Repository {

    public ArrayList<CashBackTO> findAll() {

        ArrayList<CashBackTO> cashbacks = new ArrayList<>();

        String sql = "select * from ddd_cashback order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    CashBackTO cashback = new CashBackTO();

                    cashback.setCodigo(rs.getLong("codigo"));
                    cashback.setValorAcumulado(rs.getDouble("valorAcumulado"));
                    cashback.setValorUtilizado(rs.getDouble("valorUtilizado"));
                    cashback.setDataUltimaAtualizacao(rs.getDate("dataUltimaAtualizacao").toLocalDate());

                    cashbacks.add(cashback);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return cashbacks;

    }

    public CashBackTO findByCodigo(Long codigo) {

        CashBackTO cashback = new CashBackTO();

        String sql = "select * from ddd_cashback where codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cashback.setCodigo(rs.getLong("codigo"));
                cashback.setValorAcumulado(rs.getDouble("valorAcumulado"));
                cashback.setValorUtilizado(rs.getDouble("valorUtilizado"));
                cashback.setDataUltimaAtualizacao(rs.getDate("dataUltimaAtualizacao").toLocalDate());

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return cashback;

    }

    public CashBackTO save(CashBackTO cashback) {

        String sql = "insert into ddd_cashback (valorAcumulado, valorUtilizado, dataUltimaAtualizacao) values (?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDouble(1, cashback.getValorAcumulado());
            ps.setDouble(2, cashback.getValorUtilizado());
            ps.setDate(3, java.sql.Date.valueOf(cashback.getDataUltimaAtualizacao()));

            if (ps.executeUpdate() > 0) {

                return cashback;

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

        String sql = "delete from ddd_cashback where codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Erro ao excluir: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return false;

    }

    public CashBackTO update(CashBackTO cashback) {

        String sql = "update ddd_cashback set valorAcumulado=?, valorUtilizado=?, dataUltimaAtualizacao=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDouble(1, cashback.getValorAcumulado());
            ps.setDouble(2, cashback.getValorUtilizado());
            ps.setDate(3, java.sql.Date.valueOf(cashback.getDataUltimaAtualizacao()));

            if (ps.executeUpdate() > 0) {

                return cashback;

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

}
