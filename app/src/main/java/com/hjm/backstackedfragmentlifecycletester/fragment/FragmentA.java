package com.hjm.backstackedfragmentlifecycletester.fragment;

import android.support.v4.app.Fragment;

public class FragmentA extends BaseFragment {

    @Override
    Fragment getNextFragment() {
        return new FragmentB();
    }
}
