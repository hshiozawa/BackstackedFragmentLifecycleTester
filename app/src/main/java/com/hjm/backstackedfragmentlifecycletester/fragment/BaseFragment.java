package com.hjm.backstackedfragmentlifecycletester.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hjm.backstackedfragmentlifecycletester.R;

public class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView text = view.findViewById(R.id.message);
        text.setText(getClass().getSimpleName());

        return view;
    }
}
