---
title: Teleport
description: With this preset you can teleport players with certain characteristics.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Teleport

```yaml
settings:
  center: self # self, world, world:world
  x:
    min: 0
    max: 0
  y:
    min: 20
    max: 20
  z:
    min: 0
    max: 0
```

- Preset ID is `tp`

### Settings

- `center` - Center IDs
- `x` - `min` and `max` as Integer, the plugin randomizes a float number on these ranges, but if min and max are equal, the plugin uses the exact value.
- `y` - `min` and `max` as Integer, the plugin randomizes a float number on these ranges, but if min and max are equal, the plugin uses the exact value.
- `z` - `min` and `max` as Integer, the plugin randomizes a float number on these ranges, but if min and max are equal, the plugin uses the exact value.

### Center IDs

- `self` - The center is the player position.
- `world` - The center is the player's world spawn.
- `world:world` - The center is the world's spawn with format `world:custom_world_name_here`
