package org.pelagios.recogito.sdk.ner;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class DummyNERPluginTest {

  private String SAMPLE_TEXT =
    "This is some sample text to test the DummyNERPlugin, which will classify every uppercase word as a Location.";
  
  private Phrase firstExpectedMatch = new Phrase("This", EntityType.LOCATION, 0);
  private Phrase secondExpectedMatch = new Phrase("DummyNERPlugin,", EntityType.LOCATION, 37);
  private Phrase thirdExpectedMatch = new Phrase("Location.", EntityType.LOCATION, 99);
	
  @Test
  public void test() {
	DummyNERPlugin plugin = new DummyNERPlugin();
	List<Phrase> entities = plugin.parse(SAMPLE_TEXT);
	
	for (int i=0; i<3; i++) {
	  System.out.println(entities.get(i).toString());
	}
	
	assertEquals(3, entities.size());
	assertEquals(firstExpectedMatch, entities.get(0));
	assertEquals(secondExpectedMatch, entities.get(1));
	assertEquals(thirdExpectedMatch, entities.get(2));
  }

}
