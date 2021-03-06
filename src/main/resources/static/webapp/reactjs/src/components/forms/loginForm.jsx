import React, { useContext } from "react";
import { FormContext } from "../formContext";
import { Marginer } from "../Margin";
import {
  FormContainer,
  Input,
  MutedLink,
  SubmitButton,
  BoldLink,
} from "../styles/styles";

export function LoginForm() {
  const { switchToSignup } = useContext(FormContext);

  return (
    <div>
      <FormContainer>
        <Input type="email" placeholder="Email" />
        <Input type="password" placeholder="Password" />
      </FormContainer>
      <Marginer direction="vertical" margin={10} />
      <MutedLink href="#">Forgot your password?</MutedLink>
      <Marginer direction="vertical" margin="1em" />
      <SubmitButton type="submit">Signin</SubmitButton>
      <Marginer direction="vertical" margin="1em" />
      <MutedLink href="#">
        Don't have an account?
        <BoldLink href="#" onClick={switchToSignup}>
          Signup
        </BoldLink>
      </MutedLink>
    </div>
  );
}
