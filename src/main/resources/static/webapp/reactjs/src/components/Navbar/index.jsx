import React from "react";
import { BrowserRouter as Router } from "react-router-dom";

import {
  NavbarInnerContainer,
  LeftContainer,
  NavbarContainer,
  RightContainer,
  NavbarLink,
  Logo,
} from "../styles/styles";

function Navbar() {
  return (
    <NavbarContainer>
      <NavbarInnerContainer>
        <LeftContainer>
          <NavbarLink to="/">Home</NavbarLink>
          <NavbarLink to="/orders">Orders</NavbarLink>
        </LeftContainer>
        <RightContainer>
          <NavbarLink to="/login">Login</NavbarLink>
        </RightContainer>
      </NavbarInnerContainer>
    </NavbarContainer>
  );
}

export default Navbar;
