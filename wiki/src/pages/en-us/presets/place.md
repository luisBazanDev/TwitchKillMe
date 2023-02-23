---
title: Place
description: With this preset you can place blocks in an exactly position.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Place

With this preset you can place blocks in an exactly position.

```yaml
settings:
  blocks:
    0:
      material: COBWEB
      cords: [0, 0, 0]
    1:
      material: LAVA
      cords: [0, -1, 0]
```

- Preset ID is `place`

### Settings

- `blocks` - Section of blocks

### Block

```yaml
id:
  material: LAVA
  cords: [0, -1, 0]
```

- `material` - Material ID, list of material [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html).
- `cords` - List of three integers.

_Note: Block [0, 0, 0] is the position of the player._
