package datastrcture.interview;

public class MySingleton implements Cloneable{
    private static volatile MySingleton instance = null;

    private MySingleton(){
    }


    public static MySingleton getInstance(){
        if (instance == null){
            synchronized (MySingleton.class){
                if (instance == null)
                    instance = new MySingleton();
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
