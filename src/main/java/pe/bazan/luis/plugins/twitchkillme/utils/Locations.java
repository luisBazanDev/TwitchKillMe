package pe.bazan.luis.plugins.twitchkillme.utils;

import org.bukkit.Location;

public class Locations {
  public static Location radiusLocationXZ(Location origin, double radius) {
    double x = Math.random() * radius;
    double z = Math.random() * radius;
    if(Math.random() >= 0.5) x *= -1;
    if(Math.random() >= 0.5) z *= -1;
    return origin.add(x, 0, z);
  }
}
