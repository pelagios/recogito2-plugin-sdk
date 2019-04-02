package org.pelagios.recogito.sdk;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
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

  public PluginEnvironment(String pluginsFolder) {
    this.pluginsFolder = new File(pluginsFolder);
    this.config = new HashMap<String, String>();
  }

  public PluginEnvironment(String pluginsFolder, Map<String, String> config) {
    this.pluginsFolder = new File(pluginsFolder);
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

  /** Recursive method that does the searching for .findFile **/
  private File findRecursive(String filename, File folder) {
    File[] files = folder.listFiles();

    File match = null; // I hate java
    for (File f : files) {
      if (f.getName().equals(filename) && f.isFile()) {
        match = f;
      }
    }

    if (match == null) {
      List<File> subfolders = new ArrayList<File>();
      for (File f : files) {
        if (f.isDirectory())
          subfolders.add(f);
      }

      // Recurse for all subfolders
      for (File subfolder: subfolders) {
        File maybeMatch = findRecursive(filename, subfolder);
        if (maybeMatch != null) {
          return maybeMatch;     
        }   
      }

      return null;
    } else {
      return match;
    }
  }

  /** Finds the given file in the environment's plugin folder **/
  public String findFile(String filename) {
    File f = findRecursive(filename, this.pluginsFolder);
    if (f == null) {
      return null;
    } else {
      return f.getAbsolutePath();
    }
  }

}