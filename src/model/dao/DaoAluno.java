package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class DaoAluno {

    private static List<Aluno> listaAlunos = new ArrayList<>();

    public void adicionar(Aluno a) {
        listaAlunos.add(a);
    }

    public List<Aluno> obterTodos(){
        return new ArrayList<>(listaAlunos);
    }

}