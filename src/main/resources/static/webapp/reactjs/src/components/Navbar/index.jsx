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
      <LeftContainer>
        <NavbarInnerContainer>
          <NavbarLink to="/home">Home</NavbarLink>
          <NavbarLink to="/orders">Orders</NavbarLink>
          <NavbarLink to="/login">Log In</NavbarLink>
        </NavbarInnerContainer>
      </LeftContainer>
      <RightContainer></RightContainer>
    </NavbarContainer>
  );
}

export default Navbar;
