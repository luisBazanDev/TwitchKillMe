import React from "react";
import MenuSection from "./MenuSection";
import MenuElement from "./MenuElement";

function Menu({ lang, active, currentPathMenu }) {
  if (!active) return null;
  return (
    <div className="flex flex-col w-full bg-tkm_gray_dark text-tkm_white mt-3 pl-2">
      <MenuSection
        title={lang.menu.getting_started.name}
        drop={currentPathMenu.includes("getting-started")}
      >
        <MenuElement
          active={
            currentPathMenu.includes("getting-started") &&
            currentPathMenu.length == 1
          }
          link={`/TwitchKillMe/${lang.name}/getting-started`}
        >
          /
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("instalation")}
          link={`/TwitchKillMe/${lang.name}/getting-started/instalation`}
        >
          {lang.menu.getting_started.instalation}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("twitch-tokens")}
          link={`/TwitchKillMe/${lang.name}/getting-started/twitch-tokens`}
        >
          {lang.menu.getting_started.tokens}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("started-configuration")}
          link={`/TwitchKillMe/${lang.name}/getting-started/started-configuration`}
        >
          {lang.menu.getting_started.config}
        </MenuElement>
      </MenuSection>
      <MenuSection
        title={lang.menu.presets.name}
        drop={currentPathMenu.includes("presets")}
      >
        <MenuElement
          active={currentPathMenu.includes("started-configuration")}
          link={`/TwitchKillMe/${lang.name}/presets/summon`}
        >
          {lang.menu.presets.summon}
        </MenuElement>
      </MenuSection>
      <MenuSection title="Rewards collection">
        <MenuElement>Zombies reward</MenuElement>
      </MenuSection>
    </div>
  );
}

export default Menu;
