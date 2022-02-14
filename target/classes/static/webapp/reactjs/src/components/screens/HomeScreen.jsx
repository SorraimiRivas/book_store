import React from "react";
import ItemCard from "../Cards/card";
import { styles } from "../styles/cardStyle";

const array = [];
for (let i = 0; i < 20; i++) {
  array.push(i);
}

const item = array;

const HomeScreen = () => {
  return (
    <div style={styles.homeContainer}>
      {item.map((item) => (
        <ItemCard id={item.id} />
      ))}
    </div>
  );
};

export default HomeScreen;
