package org.pelagios.recogito.sdk.examples.ner;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.pelagios.recogito.sdk.PluginEnvironment;
import org.pelagios.recogito.sdk.examples.ner.ExampleNERPlugin;
import org.pelagios.recogito.sdk.ner.EntityType;
import org.pelagios.recogito.sdk.ner.Entity;

public class ExampleNERPluginTest {

  private String SAMPLE_TEXT =
    "This is some sample text to test the DummyNERPlugin, which will classify every uppercase word as a Location.";

  private Entity firstExpectedMatch = new Entity("This", EntityType.LOCATION, 0);
  private Entity secondExpectedMatch = new Entity("DummyNERPlugin,", EntityType.LOCATION, 37);
  private Entity thirdExpectedMatch = new Entity("Location.", EntityType.LOCATION, 99);

  @Test
  public void test() {
    ExampleNERPlugin plugin = new ExampleNERPlugin();
    List<Entity> entities = plugin.parse(SAMPLE_TEXT, new PluginEnvironment("."));

    assertEquals(3, entities.size());
    assertEquals(firstExpectedMatch, entities.get(0));
    assertEquals(secondExpectedMatch, entities.get(1));
    assertEquals(thirdExpectedMatch, entities.get(2));
  }

}
