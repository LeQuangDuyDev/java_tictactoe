import React from "react";
import logo from "./../assets/logo/logo128.png";
import Button from "../components/Button/Button";
import ToggleDarkMode from "../components/Button/ToggleDarkMode";

const Header = () => {
  return (
    <header>
      <nav class="bg-white border-gray-200 dark:bg-gray-900">
        <div class="flex flex-wrap items-center justify-between max-w-screen-xl mx-auto p-4">
          <a href="#" class="flex items-center space-x-3 rtl:space-x-reverse">
            <img src={logo} class="h-8" alt="TicTacToe" />
            <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">
              TicTacToe
            </span>
          </a>
          <div class="flex items-center md:order-2 space-x-1 md:space-x-2 rtl:space-x-reverse">
            <Button>Đăng nhập</Button>
            <Button>Đăng ký</Button>
            <ToggleDarkMode></ToggleDarkMode>
          </div>
        </div>
      </nav>
    </header>
  );
};

export default Header;
