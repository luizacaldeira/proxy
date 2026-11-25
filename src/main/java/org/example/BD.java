package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, Cliente> clientes = new HashMap<>();

    public static Cliente getCliente(Integer codigo) {
        return clientes.get(codigo);
    }

    public static void addCliente(Cliente cliente) {
        clientes.put(cliente.getCodigo(), cliente);
    }
}
