package entity;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.entity.Directory;

public class DirectoryTest {
    
	Directory directory;
	@Before
	public void init(){
		directory = new Directory();
	}
	
	@Test
	public void testSetEmail() {
		directory.setEmail("edy.aguirre@tallertechnologies.com");
		assertTrue(directory.getEmail() == "edy.aguirre@tallertechnologies.com");  
	}
    
	@Test
	public void testGetEmail() {
		directory.setEmail("edy.aguirre@tallertechnologies.com");
		assertTrue(directory.getEmail()=="edy.aguirre@tallertechnologies.com");
	}
	
	@Test
	public void testSetNombre(){
		directory.setNombre("edy");
		assertTrue(directory.getNombre()=="edy");
	}
	
}
