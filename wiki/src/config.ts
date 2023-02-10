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
    menu: {
      getting_started: {
        name: "Getting Started",
        instalation: "Instalation",
        tokens: "Twitch tokens",
        config: "Configuration",
      },
    },
  },
};
