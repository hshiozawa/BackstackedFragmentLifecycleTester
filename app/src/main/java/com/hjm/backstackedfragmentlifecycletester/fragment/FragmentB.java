package com.hjm.backstackedfragmentlifecycletester.fragment;

import android.support.v4.app.Fragment;

public class FragmentB extends BaseFragment {

    @Override
    Fragment getNextFragment() {
        return new FragmentC();
    }
}
