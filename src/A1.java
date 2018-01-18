public class A1 extends BotGoal{


    public A1(Bot Owner) {
        super(Owner);
    }


    @Override
    public void Terminate(){
        BOwner.setGoal(new A2(BOwner));

    }


    @Override
    public void Display() {
        super.Display();
        System.out.println("A1");
    }
}
