import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button";
import { NavbarLink } from "../styles/styles";
import { createTheme } from "@material-ui/core/styles";
import { ThemeProvider } from "@material-ui/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    backgroundColor: "blue",
    font: "poppins",
  },
  font: {
    fontSize: "14px",
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1,
    paddingRight: theme.spacing(4),
    color: "white",
  },
}));

const theme = createTheme({
  palette: {
    primary: {
      main: "#03a9f4",
    },
    secondary: {
      main: "#f44336",
    },
  },
});

export default function ButtonAppBar() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <ThemeProvider theme={theme}>
        <AppBar color={"primary"} position="static">
          <Toolbar>
            <Typography variant="h6" className={classes.title}>
              Kodibook Store
              <NavbarLink className={classes.font} to="/">
                Home
              </NavbarLink>
              <NavbarLink to="/orders">Orders</NavbarLink>
            </Typography>
            <NavbarLink to="/login">
              <Button font="Poppins" color="inherit">
                Login
              </Button>
            </NavbarLink>
          </Toolbar>
        </AppBar>
      </ThemeProvider>
    </div>
  );
}
