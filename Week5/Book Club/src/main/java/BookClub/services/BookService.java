package BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BookClub.models.Book;
import BookClub.models.User;
import BookClub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public List<Book> getByUser(User user){
		return bookRepo.findAllByUser(user);
	}
	
	public Book getById(Long id) {
		Optional<Book> potentialBook = bookRepo.findById(id);
		if (potentialBook.isPresent()) {
			return potentialBook.get();
		}
		System.out.println("BookService: book not found");
		return null;
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Book book) {
		bookRepo.delete(book);
	}
}
