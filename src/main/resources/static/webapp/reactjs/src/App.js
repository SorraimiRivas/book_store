import React from "react";
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen";
import OrderScreen from "./components/screens/OrdersScreen";
import Login from "./components/screens/LoginScreen";
import ButtonAppBar from "./components/Navbar";

function App() {
  return (
    <Router>
      <ButtonAppBar />
      <Routes>
        <Route path="/" element={<HomeScreen />} />
        <Route path="/orders" element={<OrderScreen />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;
