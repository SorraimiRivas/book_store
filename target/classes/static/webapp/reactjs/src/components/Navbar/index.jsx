import React from "react";
import {
  NavbarInnerContainer,
  LeftContainer,
  NavbarContainer,
  RightContainer,
  NavbarLink,
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
