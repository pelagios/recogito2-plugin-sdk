package org.pelagios.recogito.sdk.examples.ner;

import java.util.List;
import java.util.ArrayList;
import org.pelagios.recogito.sdk.ner.EntityType;
import org.pelagios.recogito.sdk.ner.NERPlugin;
import org.pelagios.recogito.sdk.ner.Entity;

public class ExampleNERPlugin implements NERPlugin {

  @Override
  public String getName() {
    return "Example NER Plugin";
  }

  @Override
  public String getDescription() {
    return "A dummy plugin to demonstrate the use of the Recogito NER plugin interface.";
  }

  @Override
  public String getOrganization() {
    return "Pelagios Commons";
  }

  @Override
  public String getVersion() {
    return "1.0";
  }

  @Override
  public List<String> getSupportedLanguages() {
    return new ArrayList<String>();
  }

  /**
   * For testing and demonstration purposes, the dummy NER plugin
   * reports a 'LOCATION' entity for every uppercase word. Don't consider
   * this a sensible
   */
  @Override
  public List<Entity> parse(String text) {
    String[] words = text.split(" ");
    List<Entity> phrases = new ArrayList<Entity>();

    if (words.length == 0)
    return phrases;

    int runningIdx = 0;
    int runningOffset = 0;

    while (runningIdx < words.length) {
      String nextWord = words[runningIdx];
      runningOffset = text.indexOf(nextWord, runningOffset);

      if (startsWithUpperCase(nextWord)) {
        phrases.add(new Entity(
        nextWord,
        EntityType.LOCATION,
        runningOffset
        ));
      }

      runningIdx++;
      runningOffset += nextWord.length();
    }

    return phrases;
  }

  /** Again, this is purely for demo purposes and not universally applicable! **/
  private boolean startsWithUpperCase(String str) {
    char ch = str.charAt(0);
    return ch >= 'A' && ch <= 'Z';
  }

}
