package character;

public abstract class Character {
    private int movementPoints; //default: 5
    private int actionPoints;   //default: 2
    private int hitpoints;      //max: 99

    private int strength;       //min: 1 | max: 10
    private int agility;        //min: 1 | max: 10
    private int willpower;      //min: 1 | max: 10
    private int intelligence;   //min: 1 | max: 10

    private int luck;           //min: 1 | max: 99
    private int size;           //min: 1 | max: 5

    private MovementType movementType;

    public Character(){
        this.movementPoints = 5;
        this.actionPoints = 2;
        this.hitpoints = 10;
        this.movementType = MovementType.FOOT;
    }

    public Character(int movementPoints, int actionPoints, int hitpoints, int strength, int agility, int willpower, int intelligence, int luck, int size, MovementType movementType) {
        this.movementPoints = movementPoints;
        this.actionPoints = actionPoints;
        this.hitpoints = hitpoints;
        this.strength = strength;
        this.agility = agility;
        this.willpower = willpower;
        this.intelligence = intelligence;
        this.luck = luck;
        this.size = size;
        this.movementType = movementType;
    }
}
