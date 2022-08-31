package com.leandro.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.CategoriaRepository;
import com.leandro.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(null, "Tecnologia", "Livro de Tecnologia");

		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Livro para desenvolvedores de código limpo",
				categoria);

		categoria.getLivros().addAll(Arrays.asList(livro));
		

		this.categoriaRepository.saveAll(Arrays.asList(categoria));
		this.livroRepository.saveAll(Arrays.asList(livro));
	}

}
