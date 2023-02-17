import { useState } from "react";
import Menu from "./menu/Menu";

function Header({ title, lang, currentPathMenu }) {
  const [hideMenu, setHideMenu] = useState(true);
  const togleMenu = () => {
    setHideMenu(!hideMenu);
  };

  return (
    <div className="flex items-center justify-between flex-wrap w-full bg-tkm_purple text-tkm_white p-3">
      <div className="flex items-center w-4/5">
        <div className="w-1/4 md:w-1/6 lg:w-1/12">
          <img src="/TwitchKillMe/icon.png" alt="icon.png" />
        </div>
        <h1 className="ml-3 font-bold text-lg md:text-xl">Documentation</h1>
      </div>
      <button type="button" onClick={togleMenu} className="font-bold lg:hidden">
        <svg
          width="24"
          height="24"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M22 18.0048C22 18.5544 21.5544 19 21.0048 19H12.9952C12.4456 19 12 18.5544 12 18.0048C12 17.4552 12.4456 17.0096 12.9952 17.0096H21.0048C21.5544 17.0096 22 17.4552 22 18.0048Z"
            fill="currentColor"
          />
          <path
            d="M22 12.0002C22 12.5499 21.5544 12.9954 21.0048 12.9954H2.99519C2.44556 12.9954 2 12.5499 2 12.0002C2 11.4506 2.44556 11.0051 2.99519 11.0051H21.0048C21.5544 11.0051 22 11.4506 22 12.0002Z"
            fill="currentColor"
          />
          <path
            d="M21.0048 6.99039C21.5544 6.99039 22 6.54482 22 5.99519C22 5.44556 21.5544 5 21.0048 5H8.99519C8.44556 5 8 5.44556 8 5.99519C8 6.54482 8.44556 6.99039 8.99519 6.99039H21.0048Z"
            fill="currentColor"
          />
        </svg>
      </button>
      <div className="lg:hidden w-full">
        <Menu
          lang={lang}
          currentPathMenu={currentPathMenu}
          active={!hideMenu}
        />
      </div>
    </div>
  );
}

export default Header;
