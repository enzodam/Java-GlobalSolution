package br.com.fiap.dao;

import br.com.fiap.to.AvaliacaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacaoDAO extends Repository {
    public ArrayList<AvaliacaoTO> findAll() {

        ArrayList<AvaliacaoTO> avaliacoes = new ArrayList<>();

        String sql = "select * from ddd_avaliacao order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    AvaliacaoTO avaliacao = new AvaliacaoTO();

                    avaliacao.setCodigo(rs.getLong("codigo"));
                    avaliacao.setNota(rs.getInt("nota"));
                    avaliacao.setComentario(rs.getString("comentario"));

                    avaliacoes.add(avaliacao);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return avaliacoes;

    }

    public AvaliacaoTO findByCodigo(Long codigo) {

        AvaliacaoTO avaliacao = new AvaliacaoTO();

        String sql = "select * from ddd_avaliacao where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                avaliacao.setCodigo(rs.getLong("codigo"));
                avaliacao.setNota(rs.getInt("nota"));
                avaliacao.setComentario(rs.getString("comentario"));


            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return avaliacao;

    }

    public AvaliacaoTO save(AvaliacaoTO avaliacao) {

        String sql = "insert into ddd_avaliacao( nota, comentario) values(?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setInt(1, avaliacao.getNota());
            ps.setString(2, avaliacao.getComentario());

            if (ps.executeUpdate() > 0) {

                return avaliacao;

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

        String sql = "delete from ddd_avaliacao where codigo = ?";

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

    public AvaliacaoTO update(AvaliacaoTO avaliacao) {

        String sql = "update ddd_avaliacao set nota=?, comentario=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setInt(1, avaliacao.getNota());
            ps.setString(2, avaliacao.getComentario());
            ps.setLong(3, avaliacao.getCodigo());

            if (ps.executeUpdate() > 0) {

                return avaliacao;

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


