package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository {

    public ArrayList<CarroTO> findAll() {

        ArrayList<CarroTO> carros = new ArrayList<>();

        String sql = "select * from ddd_carros order by codigo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    CarroTO carro = new CarroTO();

                    carro.setCodigo(rs.getLong("codigo"));
                    carro.setPlaca(rs.getString("placa"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setAno(rs.getInt("ano"));

                    carros.add(carro);

                }

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return carros;

    }

    public CarroTO findByCodigo(Long codigo) {

        CarroTO carro = new CarroTO();

        String sql = "select * from ddd_carros where codigo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setLong(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                carro.setCodigo(rs.getLong("codigo"));
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getInt("ano"));

            } else {

                return null;

            }

        } catch (SQLException e) {

            System.out.println("Erro na consulta: " + e.getMessage());

        } finally {

            closeConnection();

        }

        return carro;

    }

    public CarroTO save(CarroTO cliente) {

        String sql = "insert into ddd_carros (placa, modelo, ano) values (?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, cliente.getPlaca());
            ps.setString(2, cliente.getModelo());
            ps.setInt(3, cliente.getAno());

            if (ps.executeUpdate() > 0) {

                return cliente;

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

        String sql = "delete from ddd_carros where codigo = ?";

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

    public CarroTO update(CarroTO carro) {

        String sql = "update ddd_carros set placa=?, modelo=?, ano=? where codigo=?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {

            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setInt(3, carro.getAno());

            if (ps.executeUpdate() > 0) {

                return carro;

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
