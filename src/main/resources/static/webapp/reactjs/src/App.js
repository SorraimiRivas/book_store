import "./App.css";
import styled from "styled-components";
import { NavbarLink } from "./components/styles/styles";
import Navbar from "./components/Navbar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen";
import OrderScreen from "./components/screens/OrdersScreen";
import Login from "./components/screens/loginScreen";

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
            <Route path="/login" element={<Login />} />
            <Route path="/" element={<HomeScreen />} />
            <Route path="/orders" element={<OrderScreen />} />
          </Routes>
        </Navbar>
      </AppContainer>
    </Router>
    // <Login />
  );
}

export default App;
