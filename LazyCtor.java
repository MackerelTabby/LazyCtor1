package edu.gcccd.csis;

public class LazyCtor {
    // static members
    private static final int K = 30;
    private static int instanceCounter = 0;

    // instance variables
    private final int id;

    // only constructor is private
    private LazyCtor(final int id) {
        this.id = id;
        instanceCounter++;
    }

    public static int getNumOfInstancesAllowed()
    {
        return LazyCtor.K;
    }

    public static int getNumOfInstancesCreated()
    {
        return LazyCtor.instanceCounter;
    }

    public static LazyCtor getInstance() {
        LazyCtor x = null;

        if (instanceCounter < K)
            x = new LazyCtor(instanceCounter);
        return x;
    }

    public int getId()
    {
        return this.id;
    }

    @Override
    public String toString()
    {
        return String.format("I'm the edu.gcccd.csis.LazyCtor Object, with the id: %d", id);
    }


}
