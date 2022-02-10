import "./App.css";
import styled from "styled-components";
import { AccountForm } from "./components/accountForm";
import { NavbarLink } from "./components/styles/styles";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Routes } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen";
import { Route } from "react-router";
import LoginScreen from "./components/screens/LoginScreen";
import OrderScreen from "./components/screens/OrdersScreen";

const AppContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

function App() {
  return (
    <Router>
      <AppContainer>
        <Navbar>
          <Routes>
            <Route path="/login" element={<LoginScreen />} />
            <Route path="/home" element={<HomeScreen />} />
            <Route path="/orders" element={<OrderScreen />} />
          </Routes>
        </Navbar>
      </AppContainer>
    </Router>
  );
}

export default App;
