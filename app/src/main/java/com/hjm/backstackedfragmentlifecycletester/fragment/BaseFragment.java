package com.hjm.backstackedfragmentlifecycletester.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hjm.backstackedfragmentlifecycletester.R;

abstract public class BaseFragment extends Fragment {

    private static final int DELAY = 1000;
    private static final String STOPPED = "stopped";
    private boolean isStopped = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate()");
        if (savedInstanceState != null) {
            isStopped = savedInstanceState.getBoolean(STOPPED, false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        log("onCreateView()");
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView text = view.findViewById(R.id.message);
        text.setText(getClass().getSimpleName());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        log("onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("onResume()");

        final Fragment nextFragment = getNextFragment();
        if (nextFragment != null) {
            postReplaceFragment(nextFragment);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        log("onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop()");
        isStopped = true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        log("onSavedInstanceState()");
        outState.putBoolean(STOPPED, isStopped);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy()");
    }

    private void postReplaceFragment(@NonNull final Fragment fragment) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isStopped) {
                    String message = "replace " + BaseFragment.this.getClass().getSimpleName()
                            + " to " + fragment.getClass().getSimpleName();

                    log(message);
                    replaceFragment(fragment);
                }
            }
        }, DELAY);
    }

    abstract Fragment getNextFragment();

    void replaceFragment(Fragment fragment) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void log(String message) {
        Log.i(getClass().getName(), message);
    }
}
