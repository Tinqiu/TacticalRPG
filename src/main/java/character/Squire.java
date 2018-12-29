package character;

public class Squire extends Character {

    public Squire(){
        super(5,2,10,7,3,5,5,6,4, MovementType.FOOT);
    }

    //Skills
    //  Shield Bash (damage + chance of pushing target away + chance of making target fall on back)
    //      actor STR - opponent STR = 2 -> higher chance of effect proc
    //      actor STR - opponent STR >= 4 -> guaranteed effects
    //  Sprint (trade an action point for movement points)

}
