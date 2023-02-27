import {
  EntityType,
  ArmorSlots,
  MaterialType,
  DropSlots,
  Gamemodes,
  AlertType,
  PotionType,
  Ticks,
  Seconds,
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
  interval: Ticks;
  commands: string[];
}

export interface GamemodePreset {
  gamemode: Gamemodes;
  time: Seconds;
  alert: AlertType;
}

export interface VoidChunkPreset {}

export interface FreezePreset {
  time: Seconds;
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

export type PlaceableBlock = {
  material: MaterialType;
  cords: number[];
};

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

export type PotionEffect = {
  effect: PotionType;
  amount: number;
  amplifier: number;
  duration: Ticks;
};

export interface PotionRainPreset {
  radius: number;
  effects: PotionEffect;
}

type RawPresets =
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

export enum PresetType {
  "SummonPreset",
  "GivePreset",
  "ArmorPreset",
  "DropPresets",
  "ConsoleCommandPreset",
  "GamemodePreset",
  "VoidChunkPreset",
  "FreezePreset",
  "TeleportPreset",
  "PlacePreset",
  "ClearInventoryPreset",
  "RandomRewardPreset",
  "MultiRewardPreset",
  "PotionRainPreset",
}

export class Preset {
  preset: PresetType;
  reward: RawPresets;
  constructor(preset: PresetType, reward: RawPresets) {
    this.preset = preset;
    this.reward = reward;
  }
}
