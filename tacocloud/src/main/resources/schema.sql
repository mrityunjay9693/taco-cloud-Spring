CREATE TABLE IF NOT EXISTS Ingredient (
    id VARCHAR(4) NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);
CREATE TABLE IF NOT EXISTS Taco (
    id IDENTITY,
    name VARCHAR (50) NOT NULL,
    createdAt timestamp NOT NULL
);
CREATE TABLE IF NOT EXISTS Taco_Ingredients (
    taco BIGINT NOT NULL,
    ingredient VARCHAR(4) NOT NULL
);
ALTER TABLE Taco_Ingredients
ADD FOREIGN KEY (taco) REFERENCES Taco (id);
ALTER TABLE Taco_Ingredients
ADD FOREIGN KEY (ingredient) REFERENCES Ingredient (id);