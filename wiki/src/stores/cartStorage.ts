import { map } from "nanostores";
import { v4 as uuid } from "uuid";
import { Preset, Item } from "../types";

export const itemsStorage = map<Record<string, Preset>>({});

export function addCartItem(preset: Preset): Item {
  const item: Item = {
    key: uuid(),
    preset,
  };

  itemsStorage.setKey(item.key, preset);

  return item;
}
