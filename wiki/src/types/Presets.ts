import { EntityType, ArmorSlots, MaterialType, DropSlots } from "./SpigotTypes";

export interface SummonPreset {
  type: EntityType;
  amount: number;
  "summon-radius": number;
  name: string;
  "equip-default": boolean;
  health: number;
  "top-world": boolean;
}

export interface GivePreset {
  slot: number;
  amount: number;
  "custom-model": number;
  material: MaterialType;
  name: string;
  lore: string[];
}

export interface ArmorPreset {
  slot: ArmorSlots;
  "custom-model": number;
  material: MaterialType;
  name: string;
  lore: string[];
}

export interface DropPresets {
  slot?: DropSlots;
  slots?: DropSlots[];
}

export type Preset = SummonPreset | GivePreset | ArmorPreset | DropPresets;
