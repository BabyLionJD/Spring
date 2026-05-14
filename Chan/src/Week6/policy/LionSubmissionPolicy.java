package Week6.policy;

import Week6.policy.SubmissionPolicy;

public class LionSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}
