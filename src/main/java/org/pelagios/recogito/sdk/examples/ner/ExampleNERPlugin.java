package org.pelagios.recogito.sdk.examples.ner;

import java.util.List;

import org.pelagios.recogito.sdk.ner.EntityType;
import org.pelagios.recogito.sdk.ner.NERPlugin;
import org.pelagios.recogito.sdk.ner.Entity;

import java.util.ArrayList;

public class ExampleNERPlugin implements NERPlugin {

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
