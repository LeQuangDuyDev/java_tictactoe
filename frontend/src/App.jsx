import "./App.css";
import ToggleDarkMode from "./components/Button/ToggleDarkMode";
import MainLayout from "./layout/MainLayout";
import LoginPage from "./pages/LoginPage";

function App() {
  return (
    <>
      <MainLayout>
        <LoginPage></LoginPage>
      </MainLayout>
    </>
  );
}

export default App;
