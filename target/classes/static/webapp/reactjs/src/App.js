import React from "react";
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomeScreen from "./components/screens/HomeScreen";
import OrderScreen from "./components/screens/itemDetailScreen";
import Login from "./components/screens/LoginScreen";
import ButtonAppBar from "./components/Navbar";
import ItemDetailScreen from "./components/screens/itemDetailScreen";

function App() {
  return (
    <Router>
      <ButtonAppBar />
      <Routes>
        <Route path="/" element={<HomeScreen />} />
        <Route path="/orders" element={<OrderScreen />} />
        <Route path="/login" element={<Login />} />
        <Route path="/details" element={<ItemDetailScreen />} />
      </Routes>
    </Router>
  );
}

export default App;
