import React from "react";
import ToggleDarkMode from "../components/Button/ToggleDarkMode";

const Header = () => {
  return (
    <header>
      TicTacToe
      <ToggleDarkMode />
    </header>
  );
};

export default Header;
