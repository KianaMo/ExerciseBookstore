package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookStoreRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookStoreRepository repository) {
		return (args) -> {
	 Book book1 = new Book("Scarlett", "Alexandra Ripely", "1991", "97804466", 45.5);
	 Book book2 = new Book("Cirque Du Freak", "Darren O'Shaughnessy", "2000", "8976549", 63.9);
	 Book book3 = new Book("My Uncle Napoleon", "Iraj Pezeshkzad", "1973", "65438764", 58.9);
	 
	 repository.save(book1);
	 repository.save(book2);
	 repository.save(book3);
	};
	}

}
