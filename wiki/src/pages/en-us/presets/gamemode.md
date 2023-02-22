---
title: Gamemode
description: With this preset you can change player's gamemode.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Gamemode

With this preset you can change player's gamemode.

```yaml
settings:
  gamemode: "creative"
  time: 10
  alert: "actionbar"
```

- Preset ID is `gamemode`

### Settings

- `gamemode` - Gamemodes ID.
- `time` - Integer in seconds.
- `alert` - String for now only `bossbar` and `actionbar`

_Note: Be careful with the use, because when the reward is activated it takes the current game mode of the player to be able to reset it, this means that if it is used too often it is possible to bug the player._

### Gamemodes IDs

- `survival` - Player has limited life and resources.
- `creative` - Player has ilimited life and resources.
- `adventure` - Similar to survival but you can't break blocks.
- `spectator` - Without resources, life and cannot interact with anything but absolute movement.
