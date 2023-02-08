package fi.haagahelia.bookstore.web;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookStoreRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 return "addbook";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model){
		model.addAttribute("book", repository.findById(id));
	 return "editbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	
	
	@RequestMapping(value = "/delete/{id}", 
			method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model){ 
		repository.deleteById(id);
	 return "redirect:../booklist";
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