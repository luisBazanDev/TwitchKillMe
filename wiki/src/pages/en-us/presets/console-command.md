---
title: Console command
description: With this preset you can run commands like a console.
layout: ../../../layouts/MainLayout.astro
lang: en-us
author: Luis Bazán
---

# Console command

With this preset you can run commands like a console.

```yaml
settings:
  interval: 0
  commands:
    - "kill %player%"
    - "say ¡You died!"
```

- Preset ID is `console-command`

### Settings

- `interval` - Integer in ticks, 20 ticks = 1 second
- `commands` - List of string, you can use variables.
