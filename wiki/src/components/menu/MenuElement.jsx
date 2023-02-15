import React from "react";

function MenuElement({ children, active, link }) {
  return (
    <a
      className="flex hover:text-tkm_purple cursor-pointer select-none"
      href={link}
    >
      <div
        className={`h-auto ${
          active ? "bg-tkm_purple w-1" : "bg-tkm_purple_dark w-0.5"
        }`}
      ></div>
      <div className={`ml-2 py-1 ${active ? "font-bold" : ""}`}>{children}</div>
    </a>
  );
}

export default MenuElement;
