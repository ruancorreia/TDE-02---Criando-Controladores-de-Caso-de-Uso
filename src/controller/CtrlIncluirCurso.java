package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;

public class CtrlIncluirCurso {

    private Scanner scanner;
    private DaoCurso daoCurso;

    public CtrlIncluirCurso(Scanner scanner, DaoCurso daoCurso) {
        this.scanner = scanner;
        this.daoCurso = daoCurso;
    }

    public void executar() {
        try {
            System.out.println("\n--- Cadastro de Curso ---");
            System.out.print("Digite o código do curso: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do curso: ");
            String nome = scanner.nextLine();

            Curso novoCurso = new Curso(codigo, nome);
            daoCurso.adicionar(novoCurso);

            System.out.println("Curso cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: O código deve ser um número inteiro.");
            scanner.nextLine(); // Limpar o buffer, nunca esquecer disso
        } catch (ModelException e) {
            System.out.println("Erro ao cadastrar curso: " + e.getMessage());
        }
    }
}