export const SITE = {
  title: "TwitchKillMe",
  description: "Plugin for mc",
  defaultLanguage: "en_US",
};

export type Frontmatter = {
  title: string;
  description: string;
  layout: string;
  currentPathMenu: Array<string>;
  image?: { src: string; alt: string };
  dir?: "ltr" | "rtl";
  ogLocale?: string;
  lang?: string;
};

export const MENU_LANGS = {
  "en-us": {
    name: "en-us",
    menu: {
      getting_started: {
        name: "Getting Started",
        installation: "Installation",
        tokens: "Twitch tokens",
        config: "Configuration",
      },
      presets: {
        name: "Presets",
        summon: "Summon",
        give: "Give",
        armor: "Armor",
        drop: "Drop",
        "console-command": "Console command",
        gamemode: "Gamemode",
        "void-chunk": "Void chunk",
        freeze: "Freeze",
        teleport: "Teleport",
        place: "Place",
      },
    },
    footer: {
      config_files: "Config files",
      languages: "Languages",
      langs: ["English", "Spanish"],
      other_links: "Other links",
      others: ["Spigot Page", "License (MIT)", "Docs"],
    },
  },
};
