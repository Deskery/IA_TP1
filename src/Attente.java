public class Attente extends BotGoal {
    public Attente(Bot Owner) {
        super(Owner);
    }


    @Override
    public void Terminate(){
        BOwner.setGoal(BOwner.getGoal());

    }


    @Override
    public void Display() {
        super.Display();
        System.out.println("en attente");
    }
}
