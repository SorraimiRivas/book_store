import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import { NavbarLink } from "../styles/styles";

const { faker } = require("@faker-js/faker");

const useStyles = makeStyles({
  root: {
    maxWidth: 300,
    margin: 25,
  },
  media: {
    height: 140,
  },
});

const bookTitle = faker.commerce.productName();
const bookCover = faker.image.image();

export default function ItemCard() {
  const classes = useStyles();

  return (
    <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          className={classes.media}
          image={bookCover}
          title={bookTitle}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            {bookTitle}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum,
            tempore cupiditate quia beatae sunt suscipit ut saepe quisquam
            nesciunt minima.
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <NavbarLink to="/details">
          <Button size="small" color="primary">
            Details
          </Button>
        </NavbarLink>
        <Button size="small" color="primary">
          Add to cart
        </Button>
      </CardActions>
    </Card>
  );
}
