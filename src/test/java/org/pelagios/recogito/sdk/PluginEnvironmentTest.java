package org.pelagios.recogito.sdk;

import static org.junit.Assert.*;
import org.junit.Test;

public class PluginEnvironmentTest {

  @Test
  public void test() {
    PluginEnvironment env = new PluginEnvironment("src/test/resources");

    String f = env.findFile("findme.txt");
    assertEquals(f.endsWith("findme.txt"), true);
  }

}
