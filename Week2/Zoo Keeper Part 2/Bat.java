public class Bat extends Mammal{
    public Bat(){
        super(300);
    }

    void fly(){
        System.out.println("The bat starts flying!");
        energyLevel -= 50;
        displayEnergy();
    }

    void eatHumans(){
        System.out.println("The bat eats a human and gains 25 energy."); //Now how does it fit a whole human in there?
        energyLevel += 25;
        displayEnergy();
    }

    void attackTown(){
        System.out.println("The bat sets a town and loses 100 energy."); //Am I writing about a bat or a dragon?
        energyLevel -= 100;
        displayEnergy();
    }
}
