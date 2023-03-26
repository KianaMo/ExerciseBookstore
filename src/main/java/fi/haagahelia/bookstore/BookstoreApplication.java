package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookStoreRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookStoreRepository repository, CategoryRepository categoryRepo, UserRepository userRepo ) {
		return (args) -> {
	 Category category1 = new Category("Crime");
	 Category category2 = new Category("Drama");
	 Category category3 = new Category("Horror");
	 
	 categoryRepo.save(category1);
	 categoryRepo.save(category2);
	 categoryRepo.save(category3);
			
	 Book book1 = new Book("Scarlett", "Alexandra Ripely", "1991", "97804466", 45.5, category1);
	 Book book2 = new Book("Cirque Du Freak", "Darren O'Shaughnessy", "2000", "8976549", 63.9, category2);
	 Book book3 = new Book("My Uncle Napoleon", "Iraj", "1973", "65438764", 58.9, category3);
	 
	 repository.save(book1);
	 repository.save(book2);
	 repository.save(book3);
	 
	 // Il0v$myc@t4EvEr
	 User user1 = new User("Kiana", "$2a$10$Xp8gdIOy8wNpuImpEQ3.GuF5hq7F5RCi1peqMk.I/8AJVkn0.2cZm","ROLE_USER");
	 // 13623%#@PoK
	 User user2= new User("Ari", "$2a$10$GxyRBBkePbs.aBn3sdxPrOyD0iMpBEItI74e//.mpOw/TdS158gte","ROLE_ADMIN");
	 userRepo.save(user1);
	 userRepo.save(user2);

	};
	}

}
