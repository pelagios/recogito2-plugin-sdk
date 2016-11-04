package org.pelagios.recogito.sdk;

/**
 * Base interface for all types of Recogito server-side plugins.
 *
 * @author Rainer Simon <rainer.simon@ait.ac.at>
 */
public interface RecogitoPlugin {

  /** The (screen) name of this plugin **/
  public String getName();

  /** A human-readable one-line description **/
  public String getDescription();

  /** Name of the organization/group/person that is the creator of this plugin **/
  public String getOrganization();

  /** Plugin version **/
  public String getVersion();

}
