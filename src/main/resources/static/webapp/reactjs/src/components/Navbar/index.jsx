import React from "react";

import {
  NavbarInnerContainer,
  LeftContainer,
  NavbarContainer,
  RightContainer,
  NavbarLink,
  Logo,
} from "../accountForm/common";

function Navbar() {
  return (
    <NavbarContainer>
      <NavbarInnerContainer>
        <LeftContainer>
          <NavbarContainer>
            <Logo></Logo>
            {/* <NavbarLink to="/">Home</NavbarLink> */}
          </NavbarContainer>
        </LeftContainer>
        <RightContainer></RightContainer>
      </NavbarInnerContainer>
    </NavbarContainer>
  );
}

export default Navbar;
