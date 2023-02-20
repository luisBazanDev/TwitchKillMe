---
title: Give preset
description: With this preset you can give items to players with certain characteristics.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Give preset

With this preset you can give items to players with certain characteristics.

```yaml
settings:
  slot: -1
  amount: 2
  custom-model: 0
  material: "POTATO"
  name: "&e&lPotato"
  lore:
    - "&f&lPotato &d&lreward"
    - "&7This is a simple potato"
```

- Preset ID is `summon`

### Settings

- `slot` - Slot id of the player's inventory, if you set on `-1` slot random.
- `amount` - Is an integer number minimus 1, determines the number of items with these characteristics.
- `custom-model` - Integer, custom model id.
- `material` - Material ID, list of material [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html).
- `name` - Display name of the item.
- `lore` - Lore lines of the item.
