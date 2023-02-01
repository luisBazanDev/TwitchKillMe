package pe.bazan.luis.plugins.twitchkillme.utils;

import java.util.List;

public class Randomizer {
  public static Class randomizerList(List<Class> classList) {
    return classList.get((int) Math.floor(Math.random() * classList.size()));
  }
}
