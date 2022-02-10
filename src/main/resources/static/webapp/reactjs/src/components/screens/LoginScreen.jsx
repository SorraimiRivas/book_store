import React, { useState } from "react";
import {
  BoxContainer,
  TopContainer,
  BackDrop,
  HeaderContainer,
  SmallText,
  HeaderText,
  InnerContainer,
} from "../styles/formStyles";
import { LoginForm } from "../forms/loginForm";
import { SignupForm } from "../forms/signupForm";
import { FormContext } from "../formContext";

const backdropVariants = {
  expanded: {
    width: "233%",
    height: "1005px",
    borderRadius: "20%",
    transform: "rotate(60deg)",
  },

  collapsed: {
    width: "160%",
    height: "550px",
    borderRadius: "50%",
    transform: "rotate(60deg)",
  },
};

const expandingTransition = {
  type: "spring",
  duration: 2.3,
  stiffness: 30,
};

function Login() {
  const [isExpanded, setExpanded] = useState(false);
  const [active, setActive] = useState("signin");

  const playExpandingAnimation = () => {
    setExpanded(true);
    setTimeout(() => {
      setExpanded(false);
    }, expandingTransition.duration * 1000 - 1500);
  };

  const switchToSignup = () => {
    playExpandingAnimation();
    setTimeout(() => {
      setActive("signup");
    }, 400);
  };

  const switchToSignin = () => {
    playExpandingAnimation();
    setTimeout(() => {
      setActive("signin");
    }, 400);
  };

  const contextValue = { switchToSignin, switchToSignup };
  return (
    <FormContext.Provider value={contextValue}>
      <BoxContainer>
        <TopContainer>
          <BackDrop
            initial={false}
            animate={isExpanded ? "expanded" : "collapsed"}
            variants={backdropVariants}
            transition={expandingTransition}
          />
          {active === "signin" && (
            <HeaderContainer>
              <HeaderText>Welcome to Kodigo's Book Store </HeaderText>
              <SmallText>Please sign-in to continue.</SmallText>
            </HeaderContainer>
          )}
          {active === "signup" && (
            <HeaderContainer>
              <HeaderText>Create an account</HeaderText>
              <SmallText>Please sign-up to continue.</SmallText>
            </HeaderContainer>
          )}
        </TopContainer>
        <InnerContainer>
          {active === "signin" && <LoginForm />}
          {active === "signup" && <SignupForm />}
        </InnerContainer>
      </BoxContainer>
    </FormContext.Provider>
  );
}

export default Login;
