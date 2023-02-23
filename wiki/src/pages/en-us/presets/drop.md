---
title: Drop
description: With this preset you can drop items from te player's inventory.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Drop

With this preset you can drop items from te player's inventory.

```yaml
settings:
  slot: "main-hand"
  slots:
    - main-hand
    - chestplate
```

- Preset ID is `drop`

### Settings

- `slot` - Slot ID, just one slot.
- `slots` - List of Slot IDs, many slots.

_Note: Slot or slots, you can't use both at the same time._

### Slots IDs

- `helmet` - Helmet slot.
- `chestplate` - Chest slot.
- `leggings` - Legs slot.
- `boots` - Foot slot.
- `main-hand` - Primary hand slot.
- `off-hand` - Secundary hand slot.
- `random` - Random slot.
- Number - Integer from 0 to 45.

![slots](/TwitchKillMe/presets/inventory-ids.png)
