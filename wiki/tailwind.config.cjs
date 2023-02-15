/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}"],
  theme: {
    colors: {
      tkm_purple: "#9146ff",
      tkm_purple_light: "#A76AFF",
      tkm_purple_dark: "#4a00b9",
      tkm_white: "#ffffff",
      tkm_black: "#151515",
      tkm_gray: "#323232",
      tkm_gray_dark: "#252525",
    },
    extend: {
      fontFamily: {
        ubuntu: "'Ubuntu', sans-serif",
      },
    },
  },
  plugins: [],
};
