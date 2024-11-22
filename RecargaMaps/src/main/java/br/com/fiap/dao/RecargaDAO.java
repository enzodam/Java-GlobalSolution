package br.com.fiap.dao;


import br.com.fiap.to.RecargaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecargaDAO extends Repository {
    public ArrayList<RecargaTO> findAll() {

        ArrayList<RecargaTO> recargas = new ArrayList<>();

        String sql = "select * from ddd_recarga order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    RecargaTO recarga = new RecargaTO();

                    recarga.setCodigo(rs.getLong("codigo"));
                    recarga.setDataRecarga(rs.getDate("dataRecarga").toLocalDate());
                    recarga.setValorCobrado(rs.getDouble("valorCobrado"));

                    recargas.add(recarga);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return recargas;

    }

    public RecargaTO findByCodigo(Long codigo) {

        RecargaTO recarga = new RecargaTO();

        String sql = "select * from ddd_recarga where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                recarga.setCodigo(rs.getLong("codigo"));
                recarga.setDataRecarga(rs.getDate("dataRecarga").toLocalDate());
                recarga.setValorCobrado(rs.getDouble("valorCobrado"));

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return recarga;

    }

    public RecargaTO save(RecargaTO recarga) {

        String sql = "insert into ddd_recarga(dataRecarga, valorCobrado) values(?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(recarga.getDataRecarga()));
            ps.setDouble(2, recarga.getValorCobrado());

            if (ps.executeUpdate() > 0) {

                return recarga;

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

        String sql = "delete from ddd_recarga where codigo = ?";

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

    public RecargaTO update(RecargaTO recarga) {

        String sql = "update ddd_recarga set dataRecarga=?, valorCobrado=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(recarga.getDataRecarga()));
            ps.setDouble(2, recarga.getValorCobrado());
            ps.setLong(3, recarga.getCodigo());

            if (ps.executeUpdate() > 0) {

                return recarga;

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

