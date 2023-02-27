import { Preset } from "./Presets";

export type Shop = {
  items: Preset[];
  addItem: (Preset) => void;
};
