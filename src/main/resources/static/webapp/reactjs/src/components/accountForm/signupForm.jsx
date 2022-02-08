import React, { useContext } from "react";
import { AccountContext } from "../accountContext";
import { Marginer } from "../Margin";
import {
  BoxContainer,
  FormContainer,
  Input,
  MutedLink,
  SubmitButton,
  BoldLink,
} from "./common";

export function SignupForm(props) {
  const { switchToSignin } = useContext(AccountContext);

  return (
    <BoxContainer>
      <FormContainer>
        <Input type="text" placeholder="Name" />
        <Input type="text" placeholder="Last Name" />
        <Input type="email" placeholder="Email" />
        <Input type="password" placeholder="Password" />
        <Input type="password" placeholder="Confirm Password" />
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <SubmitButton type="submit">Submit</SubmitButton>
      <Marginer direction="vertical" margin="0.4em" />

      <MutedLink href="#">
        Already have an account?
        <BoldLink href="#" onClick={switchToSignin}>
          Signin
        </BoldLink>
      </MutedLink>
    </BoxContainer>
  );
}
