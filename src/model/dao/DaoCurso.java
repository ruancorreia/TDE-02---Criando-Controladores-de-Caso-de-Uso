package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class DaoCurso {

    private static List<Curso> listaCursos = new ArrayList<>();

    public void adicionar(Curso c) {
        listaCursos.add(c);
    }

    public List<Curso> obterTodos() {
        return new ArrayList<>(listaCursos);
    }
}