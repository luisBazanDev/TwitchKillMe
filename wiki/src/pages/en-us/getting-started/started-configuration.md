---
title: Started Configuration
description: In this section we are going to see how to configure this plugin in depth.
layout: ../../../layouts/MainLayout.astro
lang: en-us
---

# Started Configuration

In this section we are going to see how to configure this plugin in depth.

## # config.yml

```yaml
enable: false

twitch:
  token: "rfx2uswqe8lu4g1mkagrvg5tv0ks3"
  refresh:
    refresh_token: "5b93chm63hdve3mycz05zfzatkfdenfspp1h1ar2xxdalen01"
    client_id: "axjhfp777tflhy0yjb5sftsil"
    client_secret: "41vpdji4e9gif429md0ouet6fktd2"
  chat-token: "oauth:rfx2uswqe8lu4g1mkagrvg5tv0ks3" # "" use token default
  channels:
    - valerihe/582076854

# Here the white list of players to apply the rewards
players:
  - player1
  - player2
```

- `enable` - Boolean if it is true the rewards are activated.
- `twitch.token` - The streamer's token.
- `twitch.refresh.refresh_token` - The streamer's refresh token.
- `twitch.refresh.client_id` - Client id of your twitch app.
- `twitch.refresh.client_secret` - Client secret of your twitch app.
- `players` - String arrayy, list of players who will be affected with rewards.

## # notifications.yml

```yaml
notifications:
  notification1: [...]
  notification2: [...]
  notification3: [...]
```

### _Notification_

```yaml
minecraft:
  title:
    content: "&f¡Reward! &a%name%"
    fadein: 20
    stay: 20
    fadeout: 20
  subtitle: "&f%method% &ax%amount%"
  actionbar: "&fThanks &e%username%"
twitch: "¡Thanks %username% for you %name%!"
sound:
  sound: "ENTITY_PLAYER_LEVELUP"
  pitch: 2
  volume: 0.3
```

- `minecraft.title.content` - String, content of title.
- `minecraft.title.fadein` - Integer, time to appear.
- `minecraft.title.stay` - Integer, time to stay.
- `minecraft.title.fadeout` - Integer, time to disappear.
- `minecraft.subtitle` - String, content of subtitle.
- `minecraft.actionbar` - String, content of actionbar.
- `minecraft.twitch` - Integer, content for the message to send to twitch.
- `minecraft.sound.sound` - String, Sound id list of sound [here](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html).
- `minecraft.sound.pitch` - Double, 0 to 2.
- `minecraft.sound.volume` - Double, 0 to 2.

### _Variables_

- `%name%` - Reward name
- `%username%` - User's twitch name
- `%amount%` - Amount for active this reward
- `%method%` - Bits / Channel Points / Hype Train / Subs

## # reward.yml

```yaml
rewards:
  reward1: [...]
  reward2: [...]
  reward3: [...]
```

### _Basic reward_

```yaml
preset: "summon"
name: "Zombie"
notification: default
active:
  points: 40
  bits: 12
  sub: 1
  subs-gifts: 1
  hype-train: 1
settings: [...]
```

- `preset`- String, complete presets list [here](/TwitchKillMe/en-us/presets).
- `name` - String, A simple name.
- `notification` - String, The id of a notification defined in the notifications.yml file.
- `active.points` - Integer, Exact amount.
- `active.bits` - Integer, Exact amount.
- `active.sub` - Integer, Exact amount.
- `active.subs-gifts` - Integer, Exact amount.
- `active.hype-train` - Integer, Exact amount.

### _Variables_

- `%name%` - Reward name
- `%username%` - User's twitch name
- `%amount%` - Amount for active this reward
- `%method%` - Bits / Channel Points / Hype Train / Subs
