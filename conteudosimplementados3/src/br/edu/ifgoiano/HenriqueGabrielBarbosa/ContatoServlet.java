package br.edu.ifgoiano.HenriqueGabrielBarbosa;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/ligacao/cadastro")
public class ContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ConversaoDePesoException peso = new ConversaoDePesoException();
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		String datatexto = req.getParameter("data");
		String peso = req.getParameter("peso");
		
		PegarPeso(peso);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(datatexto, formatador);
	
		System.out.println("O nome informado foi : " + nome);
		System.out.println("A senha informada foi : " + senha);
		System.out.println("A data informada foi : " + data);
		
		
		PrintWriter imprimir = resp.getWriter();
		imprimir.println("<html>"
				+ "<body>"
				+ "<h2>"
				+ "Sucessso!"
				+ "</h2>"
				+ "</body>"
				+ "</html>");
	}
	
	public void PegarPeso(String Peso1) throws ConversaoDePesoException {
		try {
			double pesoformatado;
			
			pesoformatado = Double.parseDouble(Peso1);
			
		}catch (Exception e) {
			throw new ConversaoDePesoException("Erro no peso olhar lá, tô de olho em você!");
		}
	}
}
