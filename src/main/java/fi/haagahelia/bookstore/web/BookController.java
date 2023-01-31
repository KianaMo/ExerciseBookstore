package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;	

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class BookController {
	public List<Book> books = new ArrayList<Book>();
	
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