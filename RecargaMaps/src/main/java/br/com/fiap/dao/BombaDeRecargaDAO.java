package br.com.fiap.dao;

import br.com.fiap.to.BombaDeRecargaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BombaDeRecargaDAO extends Repository {

    public ArrayList<BombaDeRecargaTO> findAll() {

        ArrayList<BombaDeRecargaTO> bombasDeRecarga = new ArrayList<>();

        String sql = "select * from ddd_bomba_de_recarga order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    BombaDeRecargaTO bombaDeRecarga = new BombaDeRecargaTO();

                    bombaDeRecarga.setCodigo(rs.getLong("codigo"));
                    bombaDeRecarga.setTipoBomba(rs.getString("tipoBomba"));

                    bombasDeRecarga.add(bombaDeRecarga);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return bombasDeRecarga;

    }

    public BombaDeRecargaTO findByCodigo(Long codigo) {

        BombaDeRecargaTO bombaDeRecarga = new BombaDeRecargaTO();

        String sql = "select * from ddd_bomba_de_recarga where codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bombaDeRecarga.setCodigo(rs.getLong("codigo"));
                bombaDeRecarga.setTipoBomba(rs.getString("tipoBomba"));

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return bombaDeRecarga;

    }

    public BombaDeRecargaTO save(BombaDeRecargaTO bombaDeRecarga) {

        String sql = "insert into ddd_bomba_de_recarga (tipoBomba) values (?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, bombaDeRecarga.getTipoBomba());

            if (ps.executeUpdate() > 0) {

                return bombaDeRecarga;

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

        String sql = "delete from ddd_bomba_de_recarga where codigo = ?";

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

    public BombaDeRecargaTO update(BombaDeRecargaTO bombaDeRecarga) {

        String sql = "update ddd_bomba_de_recarga set tipoBomba=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, bombaDeRecarga.getTipoBomba());

            if (ps.executeUpdate() > 0) {

                return bombaDeRecarga;

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