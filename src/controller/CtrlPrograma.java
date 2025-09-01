package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import model.Aluno;
import model.Curso;
import model.dao.DaoAluno;
import model.dao.DaoCurso;

public class CtrlPrograma {

	private static DaoCurso daoCurso = new DaoCurso();
	private static DaoAluno daoAluno = new DaoAluno();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		while (true) {
			mostrarMenu();
			try {
				opcao = scanner.nextInt();
				scanner.nextLine();

				switch (opcao) {
					case 1:

						new CtrlIncluirCurso(scanner, daoCurso).executar();
						break;
					case 2:

						new CtrlIncluirAluno(scanner, daoAluno, daoCurso).executar();
						break;
					case 3:
						listarCursos();
						break;
					case 4:
						listarAlunos();
						break;
					case 5:
						System.out.println("Saindo do programa...");
						scanner.close();
						System.exit(0);
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
				scanner.nextLine(); // Limpa o buffer do scanner
			}
			System.out.println("\nPressione Enter para continuar...");
			scanner.nextLine();
		}
	}

	private static void mostrarMenu() {
		System.out.println("\n--- MENU PRINCIPAL ---");
		System.out.println("1. Incluir Curso");
		System.out.println("2. Incluir Aluno");
		System.out.println("3. Listar Cursos");
		System.out.println("4. Listar Alunos");
		System.out.println("5. Sair");
		System.out.print("Escolha uma opção: ");
	}

	private static void listarCursos() {
		System.out.println("\n--- Lista de Cursos ---");
		List<Curso> cursos = daoCurso.obterTodos();

		if (cursos.isEmpty()) {
			System.out.println("Nenhum curso cadastrado.");
		} else {
			for (Curso c : cursos) {
				System.out.println("Código: " + c.getCodigo() + " | Nome: " + c.getNome() + " | Alunos matriculados: " + c.getListaAlunos().size());
			}
		}
	}

	private static void listarAlunos() {
		System.out.println("\n--- Lista de Alunos ---");
		List<Aluno> alunos = daoAluno.obterTodos();

		if (alunos.isEmpty()) {
			System.out.println("Nenhum aluno cadastrado.");
		} else {
			for (Aluno a : alunos) {
				System.out.println("Matrícula: " + a.getMatricula() + " | Nome: " + a.getNome() + " | Curso: " + a.getCurso().getNome());
			}
		}
	}
}