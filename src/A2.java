public class A2 extends BotGoal {

    public A2(Bot Owner) {
        super(Owner);
    }


    @Override
    public void Terminate(){
        BOwner.setGoal(new A1(BOwner));

    }


    @Override
    public void Display() {
        super.Display();
        System.out.println("A2");
    }
}
