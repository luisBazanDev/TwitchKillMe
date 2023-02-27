import { createContext, useState } from "react";
import { Shop, Preset } from "../types";

const ShopContext = createContext<Shop | {}>({});

function ShopProvider({ children }) {
  const [items, setItems] = useState<Preset[]>([]);

  const shopValues: Shop = {
    items,
    addItem: (item) => {
      setItems([item, ...items]);
    },
  };

  return (
    <ShopContext.Provider value={shopValues}>{children}</ShopContext.Provider>
  );
}

export { ShopContext, ShopProvider };
