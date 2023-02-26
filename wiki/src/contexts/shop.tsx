import { createContext } from "react";
import { Shop } from "../types";

const ShopContext = createContext<Shop>({
  items: [],
});
