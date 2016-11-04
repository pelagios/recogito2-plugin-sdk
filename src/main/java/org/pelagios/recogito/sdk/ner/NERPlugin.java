package org.pelagios.recogito.sdk.ner;

import java.util.List;
import org.pelagios.recogito.sdk.RecogitoPlugin;

/**
 * Base interface for all Recogito NER plugins.
 *
 * @author Rainer Simon <rainer.simon@ait.ac.at>
 */
public interface NERPlugin extends RecogitoPlugin {

  /**
   * Return a list of specifically supported languages (using 2- or 3-digit ISO codes)
   * or an empty list, of not language specific.
   *
   * @return the list of langauges
   */
  public List<String> getSupportedLanguages();

  /**
   * Perform NER on the provided text string.
   * @return the list of recognized Entities
   */
  public List<Entity> parse(String text);

}
