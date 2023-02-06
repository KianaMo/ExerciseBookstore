package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookStoreRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {
	public List<Book> books = new ArrayList<Book>();
	@Autowired
	private BookStoreRepository repository;
	
	@RequestMapping("/booklist")
	public String books(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@GetMapping("/index")
	public String bookForm(Model model) {
		model.addAttribute("books", books);
		return  "result";
	}
	
	@PostMapping("/index")
	public String bookSubmit(@ModelAttribute Book newBook, Model model) {
		books.add(newBook);
		
		model.addAttribute("books", books);
		return  "redirect:/index";
	}

}