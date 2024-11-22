package br.com.fiap.dao;


import br.com.fiap.to.EnderecoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends Repository {
    public ArrayList<EnderecoTO> findAll() {

        ArrayList<EnderecoTO> enderecos = new ArrayList<>();

        String sql = "select * from ddd_endereco order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    EnderecoTO endereco = new EnderecoTO();

                    endereco.setCodigo(rs.getLong("codigo"));
                    endereco.setRua(rs.getString("rua"));
                    endereco.setNumero(rs.getInt("numero"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setEstado(rs.getString("estado"));
                    endereco.setCep(rs.getString("cep"));

                    enderecos.add(endereco);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return enderecos;

    }

    public EnderecoTO findByCodigo(Long codigo) {

        EnderecoTO endereco = new EnderecoTO();

        String sql = "select * from ddd_endereco where codigo = ?";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                endereco.setCodigo(rs.getLong("codigo"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCep(rs.getString("cep"));

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return endereco;

    }

    public EnderecoTO save(EnderecoTO endereco) {

        String sql = "insert into ddd_endereco(rua, numero, cidade, estado, cep) values(?, ?, ?, ?, ?)";

        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, endereco.getRua());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getCidade());
            ps.setString(4, endereco.getEstado());
            ps.setString(5, endereco.getCep());

            if (ps.executeUpdate() > 0) {

                return endereco;

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

        String sql = "delete from ddd_endereco where codigo = ?";

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

    public EnderecoTO update(EnderecoTO endereco) {

        String sql = "update ddd_endereco set rua=?, numero=?, cidade=?, estado=?, cep=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, endereco.getRua());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getCidade());
            ps.setString(4, endereco.getEstado());
            ps.setString(5, endereco.getCep());
            ps.setLong(6, endereco.getCodigo());

            if (ps.executeUpdate() > 0) {

                return endereco;

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

