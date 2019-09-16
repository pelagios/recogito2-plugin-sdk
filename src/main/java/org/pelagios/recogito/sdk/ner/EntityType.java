package org.pelagios.recogito.sdk.ner;

import java.util.List;
import java.util.ArrayList;

/**
 * To be extended in the future, potentially.
 *
 * @author Rainer Simon <rainer.simon@ait.ac.at>
 */
public class EntityType { 

  // Just some default helpers
  public static EntityType LOCATION = new EntityType("LOCATION");
  public static EntityType PERSON   = new EntityType("PERSON");
  public static EntityType DATE     = new EntityType("DATE");

  private final String name;

  private List<String> labels = new ArrayList();

  public EntityType(String name) {
    this.name = name;
  }

  public void addLabel(String label) {
    this.labels.add(label);
  }

  public List<String> getLabels() {
    return this.labels;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
