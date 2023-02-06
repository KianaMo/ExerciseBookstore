package fi.haagahelia.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<Book, Long>{

}
