import React, { useState, useEffect } from "react";

function ToggleDarkMode() {
  const [darkMode, setDarkMode] = useState(
    localStorage.getItem("theme") === "dark"
  );

  useEffect(() => {
    const html = document.documentElement; // <html> tag
    if (darkMode) {
      html.classList.add("dark");
      localStorage.setItem("theme", "dark");
    } else {
      html.classList.remove("dark");
      localStorage.setItem("theme", "light");
    }
  }, [darkMode]);

  return (
    <div className="h-screen flex items-center justify-center bg-white dark:bg-gray-900 text-gray-900 dark:text-white">
      <div className="text-center">
        <h1 className="text-3xl font-bold mb-4">
          Giao diện {darkMode ? "Tối" : "Sáng"}
        </h1>
        <button
          onClick={() => setDarkMode(!darkMode)}
          className="px-4 py-2 bg-blue-600 dark:bg-yellow-400 text-white dark:text-black rounded"
        >
          Chuyển sang {darkMode ? "Sáng" : "Tối"}
        </button>
      </div>
    </div>
  );
}

export default ToggleDarkMode;
