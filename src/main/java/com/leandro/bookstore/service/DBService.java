package com.leandro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.bookstore.domain.Categoria;
import com.leandro.bookstore.domain.Livro;
import com.leandro.bookstore.repositories.CategoriaRepository;
import com.leandro.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria categoria1 = new Categoria(null, "Tecnologia", "Livro de Tecnologia");
		Categoria categoria2 = new Categoria(null, "Informática", "Livro de Informática");

		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Livro código limpo", categoria1);
		Livro livro2 = new Livro(null, "NodeJS", "Robert Martin", "Livro NodeJS", categoria2);
		Livro livro3 = new Livro(null, "Java", "Robert Martin", "Livro Java", categoria1);
		Livro livro4 = new Livro(null, "Python", "Robert Martin", "Livro de Python", categoria2);

		categoria1.getLivros().addAll(Arrays.asList(livro1, livro3));
		categoria2.getLivros().addAll(Arrays.asList(livro2, livro4));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3));
	}
}
