package br.com.nebulastar.dao.jdbc;

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
public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            //utilizei serial no pgadmin 4 removendo a nescecidade de um sequenciador
            //já que o proprio pgadmin possui um se criar a propriedade "ID SERIAL PRIMARY KEY"
            String sql = "INSERT INTO tb_produto (nome, codigo, preco) VALUES (?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getCodigo());
            stm.setBigDecimal(3, produto.getPreco());
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
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "update tb_produto set nome = ? where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getCodigo());
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
    public Produto consultar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "select * from tb_produto where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(codigo));
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setPreco(rs.getBigDecimal("preco"));
            }
            return produto;
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
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM  tb_produto where codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, produto.getCodigo());
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
    public List<Produto> consultarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            String sql = "Select nome,codigo, preco from tb_produto ORDER BY nome asc";
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setNome(rs.getString("nome"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produtos.add(produto);

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
        return produtos;
    }

}