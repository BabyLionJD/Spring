package Week6.policy;

public class StaffSubmissionPolicy implements Week6.policy.SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}
