public class BotGoal{

    int Status;
    Bot BOwner;
    public BotGoal(Bot Owner) {
        BOwner = Owner;
        BOwner.setGoal(this);
    }

    public void Activate(){

        Status=1;

    }
    public int Process(){
        if(Status != 1){
            Activate();

        }

        return Status;
    }


    public void Terminate(){}


    public int getStatus() {
        return Status;
    }

    public void setStatus(int iStatus) {
        this.Status = Status;
    }

    public Bot getBOwner() {
        return BOwner;
    }

    public void setBOwner(Bot BOwner) {
        this.BOwner = BOwner;
    }

    public void Display()
    {
        System.out.print("Je suis ");
    }
}
