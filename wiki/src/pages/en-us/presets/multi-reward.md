---
title: Multi reward
description: With this preset, you can run other rewards simultaneously.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Multi reward

With this preset, you can run other rewards simultaneously.

```yaml
settings:
  rewards:
    - reward-1
    - reward-2
    - reward-3
```

- Preset ID is `multi-reward`

### Settings

- `rewards` - List of Strings, they should simply have the id of the reward.
