package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDAO {
    static Connection connection;
    static Statement stmt;

    @BeforeClass
    public static void beforeClass() throws SQLException {

        System.out.println("Iniciando Conexão com banco");
        connection = ConnectionFactory.getConnection();
        System.out.println("Conexão Feita com sucesso!!!");
        stmt = connection.createStatement();
        connection.setAutoCommit(false);
    }

    @Test
    public void testeRetornoSelectDadosTeste() throws SQLException {

        String comandoSql = "SELECT dt.MASSA_TESTE  FROM DADOS_TESTE dt WHERE ID_CASO_TESTE = 1";//Criando um comando SQL
        ResultSet resultSet = stmt.executeQuery(comandoSql); // Faz a consulta e retorna em resultSET
        resultSet.next(); // Aponta para o primeiro valor de resultados
        String jsonMassaTeste = resultSet.getString(1);
        Assert.assertTrue("informações não existentes no Select", jsonMassaTeste.contains("\"url\":\"https://amazon.com.br\""));

    }

    @After
    public void after() throws SQLException {
        stmt.close();
        connection.close();
        System.out.println("Conexão Fechadas com sucesso!!!");
    }


}
