package org.pelagios.recogito.sdk.ner;

import java.util.List;

public interface NERPlugin {
	
  public List<Phrase> parse(String text);
	
}
