import {
  EntityType,
  ArmorSlots,
  MaterialType,
  DropSlots,
  Gamemodes,
  AlertType,
  PotionType,
} from "./SpigotTypes";

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

export interface ConsoleCommandPreset {
  interval: number;
  commands: string[];
}

export interface GamemodePreset {
  gamemode: Gamemodes;
  time: number;
  alert: AlertType;
}

export interface VoidChunkPreset {}

export interface FreezePreset {
  time: number;
  alert: AlertType;
}

export interface CordsRange {
  min: number;
  max: number;
}

export interface TeleportPreset {
  center: string;
  x: CordsRange;
  y: CordsRange;
  z: CordsRange;
}

export interface PlaceableBlock {
  material: MaterialType;
  cords: number[];
}

export interface PlacePreset {
  blocks: PlaceableBlock[];
}

export interface ClearInventoryPreset {}

export interface RandomRewardPreset {
  rewards: string[];
}

export interface MultiRewardPreset {
  rewards: string[];
}

export interface PotionEffect {
  effect: PotionType;
  amount: number;
  amplifier: number;
  durationInTicks: number;
}

export interface PotionRainPreset {
  radius: number;
  effects: PotionEffect;
}

export type Preset =
  | SummonPreset
  | GivePreset
  | ArmorPreset
  | DropPresets
  | ConsoleCommandPreset
  | GamemodePreset
  | VoidChunkPreset
  | FreezePreset
  | TeleportPreset
  | PlacePreset
  | ClearInventoryPreset
  | RandomRewardPreset
  | MultiRewardPreset
  | PotionRainPreset;
