package model;

import java.util.ArrayList;

public class Curso {
    private int codigo;
    private String nome;
    private ArrayList<Aluno> listaAlunos;

    public Curso(int codigo, String nome) throws ModelException {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.listaAlunos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ModelException {
        validarCodigo(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        validarNome(nome);
        this.nome = nome;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return new ArrayList<>(this.listaAlunos);
    }

    public boolean adicionarAluno(Aluno novoAluno) throws ModelException {
        if (novoAluno == null) {
            throw new ModelException("O aluno não pode ser nulo.");
        }
        if (!this.listaAlunos.contains(novoAluno)) {
            return this.listaAlunos.add(novoAluno);
        }
        return false;
    }

    public boolean removerAluno(Aluno exAluno) throws ModelException {
        if (exAluno == null) {
            throw new ModelException("O aluno não pode ser nulo.");
        }
        return this.listaAlunos.remove(exAluno);
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public static void validarCodigo(int codigo) throws ModelException {
        if (codigo <= 0) {
            throw new ModelException("O código do curso deve ser maior que zero.");
        }
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ModelException("O nome do curso não pode ser nulo ou vazio.");
        }
    }
}