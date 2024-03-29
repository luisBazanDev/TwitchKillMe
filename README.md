# Twitch Kill Me
This is a popular event among streamers on twitch. So far the best way was a mod, mod is good but limited in some aspects and this plugin is here to cover these gaps.

## [Docs](https://luisbazandev.github.io/TwitchKillMe)

## Default config files
- [config.yml](./src/main/resources/config.yml)
- [notifications.yml](./src/main/resources/notifications.yml)
- [rewards.yml](./src/main/resources/rewards.yml)
- [messages.yml](./src/main/resources/messages.yml)

## Commands
- /twitchkillme reload - Reload config.
- /twitchkillme toggle - Enable or disable rewards.
- /twitchkillme test <reward-id> - Run reward as test.

## Permissions
- `tkm.commands` - Main command
- `tkm.commands.reload` - Reload config
- `tkm.commands.toggle` - Toggle rewards
- `tkm.commands.test` - Test reward

## Languages
- [ES](./languages/es.yml)
- [EN](./languages/en.yml)

## [Spigot page](https://www.spigotmc.org/resources/twitchkillme.107399/)

## License [MIT](./LICENSE)

## To-Do's
- [x] Channel points support
- [x] Hype Train support
- [X] Method for send message to twitch
- [X] On reward run, execute notification on minecraft and twitch
- [X] Bits support
- [X] Subscription support
- [X] Subscription gift support
- [X] Main command
- [X] Permissions
- [X] Reload command
- [X] Enable and disable system
- [X] Test command
- [X] Multi-languages support
- [X] Refresh token
- [X] Wiki
- [ ] Multi token support
- [ ] Implements the twtichtokengenerator API to get credentials
- [ ] Implements conditionals prices on rewards config >,=,<=, etc.
- [ ] Save rewards on system disable, and save on cache file
- [ ] User community Points Support
- [ ] Raid's support
- Presets
  - [x] Summon
  - [X] Give
  - [X] Armor
  - [X] Drop
  - [X] Run console command
  - [X] Gamemode
  - [X] Void a chunk
  - [X] Freeze Player
  - [X] Tp
  - [X] Place
  - [X] Clear inventory
  - [X] Random reward
  - [X] Multi reward
  - [X] Potions rain
  - [ ] Run player command
  - [ ] Tp to world
  - [ ] Skin
  - [ ] Randomizer inventory
  - [ ] Structure, datapack or schematic
  - [ ] Potion effect
  - [ ] Particles
  - [ ] Fireworks