import { useStore } from "@nanostores/react";
import { itemsStorage, addCartItem } from "../stores/cartStorage";
import { MaterialType, GivePreset, Preset, PresetType } from "../types";
import PresetContainer from "./PresetContainer";

const givePreset: GivePreset = {
  name: "xd",
  "custom-model": 0,
  amount: 1,
  lore: ["a"],
  slot: -1,
  material: MaterialType.ACACIA_LEAVES,
};

const give = new Preset(PresetType.GivePreset, givePreset);

export default function ShopCart() {
  const items = useStore(itemsStorage);

  function click() {
    addCartItem(give);
  }

  const listPresets = Object.keys(items).map((key) => {
    const reward = items[key];
    return <PresetContainer id={key} item={reward} />;
  });

  return (
    <div className="w-full px-2">
      <div>
        <button
          onClick={click}
          className="text-tkm_white bg-tkm_purple_dark p-3 rounded-md active:bg-tkm_purple transition-all"
        >
          Add item!
        </button>
      </div>
      <div>{listPresets}</div>
    </div>
  );
}
