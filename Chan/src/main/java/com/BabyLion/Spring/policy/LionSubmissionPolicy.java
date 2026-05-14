package com.BabyLion.Spring.policy;

public class LionSubmissionPolicy implements com.BabyLion.Spring.policy.SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}
