import { useState } from "react";

function MenuSection(props) {
  const [drop, setDrop] = useState(props.drop);
  function toggleDrop() {
    setDrop(!drop);
  }

  function Content() {
    if (!drop) return null;
    return <div className="mt-2 mb-4">{props.children}</div>;
  }

  return (
    <div className="my-1">
      <div className="font-bold text-lg" onClick={toggleDrop}>
        {props.title}
      </div>
      <Content />
    </div>
  );
}

export default MenuSection;
