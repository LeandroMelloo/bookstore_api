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
		Categoria categoria3 = new Categoria(null, "Biologia", "Livro de Biologia");

		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Livro código limpo", categoria1);
		Livro livro2 = new Livro(null, "NodeJS", "Robert Martin", "Livro NodeJS", categoria2);
		Livro livro3 = new Livro(null, "Java", "Robert Martin", "Livro Java", categoria1);
		Livro livro4 = new Livro(null, "Python", "Robert Martin", "Livro de Python", categoria2);
		Livro livro5 = new Livro(null, "Planeta Vegetal", "Adiano del Pietro", "Livro Planeta Vegetal", categoria3);
		Livro livro6 = new Livro(null, "Planeta Terra", "Carlos Albanes", "Planeta Terra para todos", categoria3);

		categoria1.getLivros().addAll(Arrays.asList(livro1, livro3));
		categoria2.getLivros().addAll(Arrays.asList(livro2, livro4));
		categoria3.getLivros().addAll(Arrays.asList(livro5, livro6));

		this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		this.livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5, livro6));
	}
}
