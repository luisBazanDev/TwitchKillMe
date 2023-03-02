import {
  SummonPresetEditable,
  SummonPresetValues,
} from "./SummonPresetDisplay";
import { FunctionComponent } from "react";

export function ResolveDisplay({ preset, reward, type }) {
  var editable: FunctionComponent = null;
  var values: FunctionComponent = null;
  switch (preset) {
    case 1:
      editable = SummonPresetEditable;
      values = SummonPresetValues;
      break;
  }

  if (!editable || !values) return null;

  switch (type) {
    case 0:
      return values(reward);
    case 1:
      return editable(reward);
  }

  return null;
}
