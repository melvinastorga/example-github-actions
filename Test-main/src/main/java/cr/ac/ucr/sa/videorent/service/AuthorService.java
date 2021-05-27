package cr.ac.ucr.sa.videorent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.sa.videorent.entity.Author;
import cr.ac.ucr.sa.videorent.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> findByName(String name){
		return authorRepository.findAuthorByName(name);
	}
	@Transactional // the method will be executed in a transactional manner, because it will insert into author and book tables
	public void insert(Author author) {
		authorRepository.saveAndFlush(author);
	}
	@Transactional
	public void delete(long id) {
		Author authorToDelete = authorRepository.getOne(id);
		authorRepository.delete(authorToDelete);
	}

}