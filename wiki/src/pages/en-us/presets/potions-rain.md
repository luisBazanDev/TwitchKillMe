---
title: Potions rain
description: With this preset, you can spawn potions of many effects in a radius of the player.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Potions rain

With this preset, you can spawn potions of many effects in a radius of the player.

```yaml
settings:
  radius: 5
  effects:
    - SPEED;2;1;300
    - ABSORPTION;2;0;200
```

- Preset ID is `potions-rain`

### Settings

- `radius` - Integer number, this is the radius where potions will spawn.
- `effects` - List of the effects

### Effect format

`EFFECT;AMOUNT;AMPLIFIER;DURATION_IN_TICKS`

- `EFFECT` - Potion effect type, list [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/potion/PotionEffectType.html).
- `AMOUNT` - Integer number, amount of potions of this type will spawn.
- `AMPLIFIER` - Integer number, initial value 0, max value 244
- `DURATION_IN_TICKS` - Integer numberm, amount of time in ticks that each of these potions lasts.
- Example `ABSORPTION;3;0;300`

_Note: 20 ticks = 1 second_
