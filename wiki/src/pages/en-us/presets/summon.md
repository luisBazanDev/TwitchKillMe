---
title: Summon preset
description: With this preset you will be able to summon mobs with certain characteristics.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Summon preset

With this preset you will be able to summon mobs with certain characteristics.

```yaml
preset: "summon"
settings:
  type: "ZOMBIE"
  amount: 2
  summon-radius: 3
  name: "%username%'s"
  equip-default: true
  health: 20
  top-world: false
```

- Preset ID is `summon`

### Settings

- `type` - The type of entity to invoke, [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/EntityType.html) you can review a list of the allowed ID's.
- `amount` - Is an integer number minimus 1, determines the number of entities with these characteristics will spawn.
- `summon-radius` - Is an integer number minimus 0, it determines the spawn radius around the player's position.
- `name` - String, display name of the entities.
- `equip-default` - Boolean, if the options is on true entities will be affected by the loot tables of the world where they spawn.
- `health` - Integer minimus 1, it only the health of the spawned entities.
- `top-world` - Boolean, if the options is on true when a position is located in "x" and "z" the highest block in the world will be chosen in that position regardless of the height of the player.
