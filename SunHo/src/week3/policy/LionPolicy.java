package week3.policy;

public class LionPolicy implements Policy {
    @Override
    public boolean isSubmittable() {
        return true;
    } // Lion은 true 반환
}
