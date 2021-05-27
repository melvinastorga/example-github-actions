package cr.ac.ucr.sa.videorent.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cr.ac.ucr.sa.videorent.entity.Author;
import cr.ac.ucr.sa.videorent.entity.Book;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuthorServiceTest {
	@Autowired
	private AuthorService authorService;
	
	@Test
	@Sql("/author-service-test.sql")
	public void busqueda_de_autores_por_nombre_con_resultados() {
		String nameToSearch = "Mark Janel";
		List<Author> authors = authorService.findByName(nameToSearch);
		assertEquals(nameToSearch, authors.get(0).getName(),"The search by name failed");
		assertTrue(authors.size()>=1);
	}
	
	@Test
	public void inserción_exitosa_de_nuevo_autor() {
		Author author = new Author();
		author.setName("Nicolas Negroponte");
		author.setAge(60);
		author.setGenre("Computación");
		
		Book book = new Book();
		book.setIsbn("0-679-43919-6");
		book.setTitle("Being digital");
		
		author.addBook(book);
		authorService.insert(author);
		assertTrue(author.getId() != 0);
	}
	
	@Test
	public void borrado_exitoso_de_autor_por_id() {
	
	}
}