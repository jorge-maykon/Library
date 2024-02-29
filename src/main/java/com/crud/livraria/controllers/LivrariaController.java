package com.crud.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.livraria.models.Livro;
import com.crud.livraria.repository.LivrariaRepository;

// biblioteca para o registro de imagem

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

// Inicio da controladora

@Controller
public class LivrariaController {
	
	@Autowired
	private LivrariaRepository lr;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.GET)
	public String cadastrarLivro() {
		return "content/cadastrar-livro";
	}
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.POST)
	public String cadastrarLivro(Livro livro) {
		lr.save(livro);
		return "redirect:/listarLivros";
	}
	
	@RequestMapping("/listarLivros")
	public ModelAndView listarLivros() {
		
		ModelAndView mv = new ModelAndView("content/listar-livros");
		
		Iterable<Livro> livros = lr.findAll();
		mv.addObject("livros", livros);
		
		return mv;
		
	}
	
	@RequestMapping(value="/alterarLivro/{codigoLivro}", method=RequestMethod.GET)
	public ModelAndView formAlterarLivro(@PathVariable("codigoLivro") long codigoLivro) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivro);
		
		ModelAndView mv = new ModelAndView("content/atualizar-livro");
		
		mv.addObject("livro", livro);
		
		return mv;
		
	}
	
	@RequestMapping(value="/alterarLivro/{codigoLivro}", method=RequestMethod.POST)
	public String alterarLivro(@Validated Livro livro, BindingResult result, RedirectAttributes attributes) {
		
		lr.save(livro);
		return "redirect:/listarLivros";
		
	}
	
	@RequestMapping("/confirmarExclusaoLivro/{codigoLivro}")
	public ModelAndView confirmarExclusaoLivro(@PathVariable("codigoLivro") long codigoLivro) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivro);
		
		ModelAndView mv = new ModelAndView("content/excluir-livro");
		
		mv.addObject("livro", livro);
		
		return mv;
		
	}
	
	@RequestMapping("/excluirLivro")
	public String excluirLivro(long codigoLivro) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivro);
		lr.delete(livro);
		
		return "redirect:/listarLivros";
		
	}
	@PostMapping("/upload")
     public String handleFileUpload(@RequestParam("file") MultipartFile file) {
         // lógica para processar o arquivo
         return "redirect:/index";
     }
}