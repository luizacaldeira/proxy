import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente(1, "João", "Juiz de Fora", 5000.0f, 1200.0f));
        BD.addCliente(new Cliente(2, "Maria", "Juiz de Fora", 10000.0f, 0.0f));
    }

    @Test
    void deveRetornarDadosPessoaisCliente() {
        ClienteProxy cliente = new ClienteProxy(1);

        assertEquals(Arrays.asList("João", "Juiz de Fora"), cliente.obterDadosPessoais());
    }

    @Test
    void deveRetornarDadosFinanceirosCliente() {
        Funcionario funcionario = new Funcionario("Ana", true);
        ClienteProxy cliente = new ClienteProxy(2);

        assertEquals(Arrays.asList(10000.0f, 0.0f), cliente.obterDadosFinanceiros(funcionario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarDadosFinanceirosCliente() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            ClienteProxy cliente = new ClienteProxy(2);

            cliente.obterDadosFinanceiros(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

    @Test
    void deveReutilizarClienteJaCarregado() {
        Funcionario funcionario = new Funcionario("Ana", true);
        ClienteProxy cliente = new ClienteProxy(1);

        cliente.obterDadosPessoais();
        cliente.obterDadosPessoais();

        assertEquals(Arrays.asList(5000.0f, 1200.0f), cliente.obterDadosFinanceiros(funcionario));
    }
}