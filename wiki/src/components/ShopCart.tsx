import { useContext } from "react";
import { ShopContext } from "../contexts/Shop";
import { MaterialType, GivePreset, Preset, PresetType } from "../types";
import PresetContainer from "./PresetContainer";

const givePreset: GivePreset = {
  name: "",
  "custom-model": 0,
  amount: 1,
  lore: ["a"],
  slot: -1,
  material: MaterialType.ACACIA_LEAVES,
};

const give = new Preset(PresetType.GivePreset, givePreset);

export default function ShopCart() {
  const context = useContext(ShopContext);

  return JSON.stringify(context);
}
