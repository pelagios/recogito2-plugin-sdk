package org.pelagios.recogito.sdk.ner;

import java.util.Objects;

public class Entity {
	
  public final String chars;
  
  public final EntityType entityType;
  
  public final int charOffset;
	
  public Entity(String chars, EntityType entityType, int charOffset) {
	this.chars = chars;
	this.entityType = entityType;
    this.charOffset = charOffset;
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