package br.com.fiap.dao;

import br.com.fiap.to.EstacaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class EstacaoDAO extends Repository {
    public ArrayList<EstacaoTO> findAll() {

        ArrayList<EstacaoTO> estacoes = new ArrayList<>();

        String sql = "select * from ddd_estacao order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    EstacaoTO estacao = new EstacaoTO();

                    estacao.setCodigo(rs.getLong("codigo"));
                    estacao.setNome(rs.getString("nome"));
                    estacao.setPreco(rs.getDouble("preco"));
                    estacao.setHorarioDeAbertura(LocalTime.parse(rs.getString("horario_de_abertura")));
                    estacao.setHorarioDeFechamento(LocalTime.parse(rs.getString("horario_de_fechamento")));
                    estacao.setBombaDisponivel(rs.getBoolean("bomba_disponivel"));

                    estacoes.add(estacao);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return estacoes;

    }

    public EstacaoTO findByCodigo(Long codigo) {

        EstacaoTO estacao = new EstacaoTO();

        String sql = "select * from ddd_estacao where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                estacao.setCodigo(rs.getLong("codigo"));
                estacao.setNome(rs.getString("nome"));
                estacao.setPreco(rs.getDouble("preco"));
                estacao.setHorarioDeAbertura(LocalTime.parse(rs.getString("horario_de_abertura")));
                estacao.setHorarioDeFechamento(LocalTime.parse(rs.getString("horario_de_fechamento")));
                estacao.setBombaDisponivel(rs.getBoolean("bomba_disponivel"));

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return estacao;

    }

    public EstacaoTO save(EstacaoTO estacao) {

        String sql = "insert into ddd_estacao(nome, preco, horario_de_abertura, horario_de_fechamento, bomba_disponivel) values(?, ?, ?, ?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, estacao.getNome());
            ps.setDouble(2, estacao.getPreco());
            ps.setString(3, estacao.getHorarioDeAbertura().toString());
            ps.setString(4, estacao.getHorarioDeFechamento().toString());
            ps.setBoolean(5, estacao.getBombaDisponivel());

            if (ps.executeUpdate() > 0) {

                return estacao;

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

        String sql = "delete from ddd_estacao where codigo = ?";

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

    public EstacaoTO update(EstacaoTO estacao) {

        String sql = "update ddd_estacao set nome=?, preco=?, horario_de_abertura=?, horario_de_fechamento=?, bomba_disponivel=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, estacao.getNome());
            ps.setDouble(2, estacao.getPreco());
            ps.setString(3, estacao.getHorarioDeAbertura().toString());
            ps.setString(4, estacao.getHorarioDeFechamento().toString());
            ps.setBoolean(5, estacao.getBombaDisponivel());
            ps.setLong(6, estacao.getCodigo());

            if (ps.executeUpdate() > 0) {

                return estacao;

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

