import "./App.css";
import styled from "styled-components";
import { AccountForm } from "./components/accountForm";
import { LoginForm } from "./components/accountForm/loginForm";

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
    <AppContainer>
      <AccountForm />
    </AppContainer>
  );
}

export default App;
