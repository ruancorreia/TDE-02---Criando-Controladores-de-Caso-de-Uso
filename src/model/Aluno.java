package model;

public class Aluno {
    private int matricula;
    private String nome;
    private Curso curso;

    public Aluno(int matricula, String nome, Curso curso) throws ModelException {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setCurso(curso);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws ModelException {
        validarMatricula(matricula);
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        validarNome(nome);
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) throws ModelException {
        validarCurso(curso);

        if(this.curso != null) {
            this.curso.removerAluno(this);
        }

        this.curso = curso;
        this.curso.adicionarAluno(this);
    }

    public static void validarMatricula(int matricula) throws ModelException {
        if (matricula <= 0) {
            throw new ModelException("A matrícula do aluno deve ser maior que zero.");
        }
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ModelException("O nome do aluno não pode ser nulo ou vazio.");
        }
    }

    public static void validarCurso(Curso curso) throws ModelException {
        if (curso == null) {
            throw new ModelException("O aluno deve estar obrigatoriamente matriculado em um curso.");
        }
    }
}