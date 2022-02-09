import "./App.css";
import styled from "styled-components";
// import { AccountForm } from "./components/accountForm";
// import { BrowserRouter as Router } from "react-router-dom";
import Navbar from "./components/Navbar";
import { NavbarLink } from "./components/accountForm/common";
// import HomeScreen from "./components/screens/HomeScreen";

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
    // <AppContainer>
    //   <AccountForm />
    <Navbar></Navbar>
    // </AppContainer>
    // <HomeScreen />
  );
}

export default App;
