package pe.bazan.luis.plugins.twitchkillme.utils;

import java.util.List;

public class Randomizer {
  public static <T> T randomizerList(List<T> classList) {
    return classList.get((int) Math.floor(Math.random() * classList.size()));
  }
}
