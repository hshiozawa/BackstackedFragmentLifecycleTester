package com.hjm.backstackedfragmentlifecycletester.fragment;

import android.support.v4.app.Fragment;

public class FragmentC extends BaseFragment {

    @Override
    Fragment getNextFragment() {
        // FragmentC does not have next fragment.
        return null;
    }
}
