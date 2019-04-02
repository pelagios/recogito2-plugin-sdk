package org.pelagios.recogito.sdk;

import java.io.File;
import java.util.Map; 
import java.util.HashMap;

/**
 * Base interface for conveying various useful environment settings to the plugin during runtime.
 *
 * @author Rainer Simon <rainer.simon@ait.ac.at>
 */
public class PluginEnvironment {

  private File pluginsFolder;
  private Map<String, String> config;

  public PluginEnvironment(File pluginsFolder) {
    this.pluginsFolder = pluginsFolder;
    this.config = new HashMap<String, String>();
  }

  public PluginEnvironment(File pluginsFolder, Map<String, String> config) {
    this.pluginsFolder = pluginsFolder;
    this.config = config;
  }

  /** The Recogito /plugins folder **/
  public File getPluginsFolder() {
    return pluginsFolder;
  }

  /** Plugin config file contents (if any) **/
  public Map<String, String> getPluginConfig() {
    return config;
  }

}