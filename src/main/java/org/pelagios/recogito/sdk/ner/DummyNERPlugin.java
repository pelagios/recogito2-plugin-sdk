package org.pelagios.recogito.sdk.ner;

import java.util.List;
import java.util.ArrayList;

public class DummyNERPlugin implements NERPlugin {

  /**
   * For testing and demonstration purposes, the dummy NER plugin
   * reports a 'LOCATION' entity for every uppercase word. Don't consider
   * this a sensible 
   */
  @Override
  public List<Phrase> parse(String text) {
    String[] words = text.split(" ");
    List<Phrase> phrases = new ArrayList<Phrase>();

    if (words.length == 0)
      return phrases;
  
    int runningIdx = 0;
    int runningOffset = 0;
  
    while (runningIdx < words.length) {
      String nextWord = words[runningIdx];
      runningOffset = text.indexOf(nextWord, runningOffset);
      
	  if (startsWithUpperCase(nextWord)) {
        phrases.add(new Phrase(
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
