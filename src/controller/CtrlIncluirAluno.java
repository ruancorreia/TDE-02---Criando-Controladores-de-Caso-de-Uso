package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoCurso;

public class CtrlIncluirAluno {

    private Scanner scanner;
    private DaoAluno daoAluno;
    private DaoCurso daoCurso;

    public CtrlIncluirAluno(Scanner scanner, DaoAluno daoAluno, DaoCurso daoCurso) {
        this.scanner = scanner;
        this.daoAluno = daoAluno;
        this.daoCurso = daoCurso;
    }

    public void executar() {
        if (daoCurso.obterTodos().isEmpty()) {
            System.out.println("Erro: É necessário cadastrar ao menos um curso antes de cadastrar um aluno.");
            return;
        }

        try {
            System.out.println("\n--- Cadastro de Aluno ---");
            System.out.print("Digite a matrícula do aluno: ");
            int matricula = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.println("Cursos disponíveis:");
            List<Curso> cursos = daoCurso.obterTodos();
            for (Curso c : cursos) {
                System.out.println("  - Código: " + c.getCodigo() + ", Nome: " + c.getNome());
            }

            System.out.print("Digite o código do curso para matrícula: ");
            int codigoCurso = scanner.nextInt();
            scanner.nextLine();

            Curso cursoSelecionado = null;
            for (Curso c : cursos) {
                if (c.getCodigo() == codigoCurso) {
                    cursoSelecionado = c;
                    break;
                }
            }

            if (cursoSelecionado == null) {
                System.out.println("Erro: Nenhum curso encontrado com o código informado.");
                return;
            }

            Aluno novoAluno = new Aluno(matricula, nome, cursoSelecionado);
            daoAluno.adicionar(novoAluno);
            System.out.println("Aluno cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: A matrícula e o código do curso devem ser números inteiros.");
            scanner.nextLine();
        } catch (ModelException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
    }
}