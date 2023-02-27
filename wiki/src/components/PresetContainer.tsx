import { PresetType } from "../types";

export default function PresetContainer({ item }) {
  return <div className="">{JSON.stringify(item)}</div>;
}

function getPresets() {
  const keys = Object.keys(PresetType);
  return keys.slice(keys.length / 2);
}
