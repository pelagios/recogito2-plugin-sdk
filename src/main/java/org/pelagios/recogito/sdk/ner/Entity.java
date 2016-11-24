package org.pelagios.recogito.sdk.ner;

import java.net.URI;
import java.util.Objects;

/**
 * An instance of a named entity, consisting of the text string, the entity
 * type, and the offset of the entity within the text.
 *
 * @author Rainer Simon <rainer.simon@ait.ac.at>
 */
public class Entity {

  public final String chars;

  public final EntityType entityType;

  public final int charOffset;
  
  public final URI uri;
  
  public Entity(String chars, EntityType entityType, int charOffset) {
    this(chars, entityType, charOffset, null);
  }

  public Entity(String chars, EntityType entityType, int charOffset, URI uri) {
    this.chars = chars;
    this.entityType = entityType;
    this.charOffset = charOffset;
    this.uri = uri;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Entity))
    return false;

    Entity other = (Entity) obj;

    return chars.equals(other.chars) &&
    entityType.equals(other.entityType) &&
    charOffset == other.charOffset;
  }

  @Override
  public int hashCode() {
    return Objects.hash(chars, entityType, charOffset);
  }

  public String toString() {
    return "[" + chars + "|" + entityType.toString() + "|" + charOffset + "]";
  }

}
