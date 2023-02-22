---
title: Armor preset
description: With this preset you can give items to players with certain characteristics.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Armor preset

With this preset you can give items to players with certain characteristics.

```yaml
settings:
  slot: "helmet"
  custom-model: 0
  material: "BLACK_STAINED_GLASS"
  name: "&f&lAstronaut helmet"
  lore:
    - "&7This helmet was development"
    - "&7by &fNASA&7. And it was used"
    - "&7in the &eApollo missions&7."
    - "&7The specific mission is 11."
```

- Preset ID is `armor`

### Settings

- `slot` - Slot id of the player's inventory `helmet`, `chestplate`, `leggings`, `boots`
- `custom-model` - Integer, custom model id.
- `material` - Material ID, list of material [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html).
- `name` - Display name of the item.
- `lore` - Lore lines of the item.
