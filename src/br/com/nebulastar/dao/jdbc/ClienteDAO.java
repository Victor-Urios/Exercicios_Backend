package br.com.nebulastar.dao.jdbc;

import br.com.nebulastar.domain.Cliente;
import br.com.nebulastar.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nebula Stardust
 */
public class ClienteDAO implements IClienteDAO {
    @Override
    public Integer cadastrar(Cliente cliente) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_cliente2 (id, nome, codigo) VALUES (nextval('SQ_CLIENTE2'), ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && stm.isClosed()) {
                stm.close();
            }
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "update tb_cliente2 set nome = ? where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && stm.isClosed()) {
                stm.close();
            }
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Cliente consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_cliente2 where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(codigo));
            rs = stm.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCodigo(rs.getInt("codigo"));
            }
                return cliente;
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && stm.isClosed()) {
                stm.close();
            }
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM  tb_cliente2 where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cliente.getCodigo());
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && stm.isClosed()) {
                stm.close();
            }
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<Cliente> consultarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "Select id,nome, codigo from tb_cliente2 ORDER BY nome asc";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCodigo(rs.getInt("codigo"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (stm != null && stm.isClosed()) {
                stm.close();
            }
            if (connection != null && connection.isClosed()) {
                connection.close();
            }
        }
        return clientes;
    }
}

