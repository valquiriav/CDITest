package br.com.letscode.CDITest;

import java.util.ArrayList;

public class Cadastro {

    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}