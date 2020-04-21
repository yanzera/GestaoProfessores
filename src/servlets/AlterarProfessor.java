package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProfessorService;

import model.Professor;

import java.io.PrintWriter;

@WebServlet("/AlterarProfessor.do")
public class AlterarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capturando a matr�cula do professor, que o usu�rio quer alterar:
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		
		// Solicitando � service os dados do professor da matr�cula informada:
		ProfessorService professorService = new ProfessorService();
		Professor professor = professorService.consultar(matricula);
		
		// Sa�da:
		// Formul�rio para alterar os dados do professor:
		response.setContentType("text/html");
		
		// Criando um objeto para sa�da de caracteres:
		PrintWriter saida = response.getWriter();
		saida.println("<form action='AlterarProfessor.do' method='post'>");
		saida.println("Matr�cula: " + professor.getMatricula());
		saida.println("<input type=\"hidden\" name='matricula_professor' value='"
						+ professor.getMatricula() + "'> <br>");
		saida.println("Nome: ");
		saida.println("<input type='text' name='nome_professor' value='" 
						+ professor.getNome() + "'> <br> ");
		saida.println("CPF: ");
		saida.println("<input type='text' name='cpf_professor' value='"
						+ professor.getCpf() + "'> <br> ");
		saida.println("Endere�o: ");
		saida.println("<input type='text' name='endereco_professor' value='"
						+ professor.getEndereco() + "'> <br>");
		saida.println("<input type='submit'> ");
		saida.println("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

