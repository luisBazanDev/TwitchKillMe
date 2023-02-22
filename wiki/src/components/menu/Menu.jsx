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
            currentPathMenu.length == 2
          }
          link={`/TwitchKillMe/${lang.name}/getting-started`}
        >
          /
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("installation")}
          link={`/TwitchKillMe/${lang.name}/getting-started/installation`}
        >
          {lang.menu.getting_started.installation}
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
          active={
            currentPathMenu.includes("presets") && currentPathMenu.length == 2
          }
          link={`/TwitchKillMe/${lang.name}/presets`}
        >
          /
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("summon")}
          link={`/TwitchKillMe/${lang.name}/presets/summon`}
        >
          {lang.menu.presets.summon}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("give")}
          link={`/TwitchKillMe/${lang.name}/presets/give`}
        >
          {lang.menu.presets.give}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("armor")}
          link={`/TwitchKillMe/${lang.name}/presets/armor`}
        >
          {lang.menu.presets.armor}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("drop")}
          link={`/TwitchKillMe/${lang.name}/presets/drop`}
        >
          {lang.menu.presets.drop}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("console-command")}
          link={`/TwitchKillMe/${lang.name}/presets/console-command`}
        >
          {lang.menu.presets["console-command"]}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("gamemode")}
          link={`/TwitchKillMe/${lang.name}/presets/gamemode`}
        >
          {lang.menu.presets.gamemode}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("void-chunk")}
          link={`/TwitchKillMe/${lang.name}/presets/void-chunk`}
        >
          {lang.menu.presets["void-chunk"]}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("freeze")}
          link={`/TwitchKillMe/${lang.name}/presets/freeze`}
        >
          {lang.menu.presets.freeze}
        </MenuElement>
        <MenuElement
          active={currentPathMenu.includes("teleport")}
          link={`/TwitchKillMe/${lang.name}/presets/teleport`}
        >
          {lang.menu.presets.teleport}
        </MenuElement>
      </MenuSection>
      <MenuSection title="Rewards collection">
        <MenuElement>Zombies reward</MenuElement>
      </MenuSection>
    </div>
  );
}

export default Menu;
