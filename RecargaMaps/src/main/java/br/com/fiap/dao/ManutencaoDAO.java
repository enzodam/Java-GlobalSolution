package br.com.fiap.dao;

import br.com.fiap.to.ManutencaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManutencaoDAO extends Repository {
    public ArrayList<ManutencaoTO> findAll() {

        ArrayList<ManutencaoTO> manutencoes = new ArrayList<>();

        String sql = "select * from ddd_manutencao order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    ManutencaoTO manutencao = new ManutencaoTO();

                    manutencao.setCodigo(rs.getLong("codigo"));
                    manutencao.setDataManutencao(rs.getDate("dataManutenção").toLocalDate());
                    manutencao.setDescricao(rs.getString("descrição"));
                    manutencao.setResponsavel(rs.getString("responsavel"));;

                    manutencoes.add(manutencao);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return manutencoes;

    }

    public ManutencaoTO findByCodigo(Long codigo) {

        ManutencaoTO manutencao = new ManutencaoTO();

        String sql = "select * from ddd_manutencao where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                manutencao.setCodigo(rs.getLong("codigo"));
                manutencao.setDataManutencao(rs.getDate("dataManutencao").toLocalDate());
                manutencao.setDescricao(rs.getString("descricao"));
                manutencao.setResponsavel(rs.getString("responsavel"));;

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return manutencao;

    }

    public ManutencaoTO save(ManutencaoTO manutencao) {

        String sql = "insert into ddd_manutencao( dataManutencao, descricao, responsavel) values(?, ?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(manutencao.getDataManutencao()));
            ps.setString(2, manutencao.getDescricao());
            ps.setString(3, manutencao.getResponsavel());

            if (ps.executeUpdate() > 0) {

                return manutencao;

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

        String sql = "delete from ddd_manutencao where codigo = ?";

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

    public ManutencaoTO update(ManutencaoTO manutencao) {

        String sql = "update ddd_manutencao set dataManutencao=?, descricao=?, responsavel=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(manutencao.getDataManutencao()));
            ps.setString(2, manutencao.getDescricao());
            ps.setString(3, manutencao.getResponsavel());
            ps.setLong(4, manutencao.getCodigo());

            if (ps.executeUpdate() > 0) {

                return manutencao;

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

