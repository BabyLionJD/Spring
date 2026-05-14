package com.BabyLion.Spring.policy;

public class StaffSubmissionPolicy implements com.BabyLion.Spring.policy.SubmissionPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}
