package animals;

import animals.utils.DateFormatUtils;
import animals.utils.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;


public abstract class AbstractAnimal implements Animal {

    protected String breed;
    protected String name;
    protected BigDecimal cost;
    protected String character;

    protected LocalDate birthDate;

    protected AbstractAnimal(String cost) {
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.HALF_UP);
        birthDate = RandomUtils.genRandomDate();
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getCost() {
        return this.cost;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public LocalDate getBirthDate() { return birthDate; }


    @Override
    public String toString() {

        return "breed: " + this.breed + "\n" +
                "name: " + this.name + "\n" +
                "cost: " + this.cost + "\n" +
                "character: " + this.character + "\n" +
                "birthDate: " + DateFormatUtils.formatDate(this.birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj.getClass() != this.getClass()) return false;
        AbstractAnimal other = (AbstractAnimal) obj;
        return (other.breed.equals(this.breed) &&
                other.name.equals(this.name) &&
                other.character.equals(this.character) &&
                other.cost.equals(this.cost) &&
                other.birthDate.equals(this.birthDate)
        );
    }
}
