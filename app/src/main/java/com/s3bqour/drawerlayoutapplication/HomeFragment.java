package com.s3bqour.drawerlayoutapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;


public class HomeFragment extends Fragment {

    private HomeFragment.OnFragmentInteractionListener mListener;

    private BottomAppBar botAppBar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_home, container, false);

        botAppBar = parentView.findViewById(R.id.bottomMenuBar);

        return parentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //  attach menu to your BottomAppBar
        botAppBar.replaceMenu(R.menu.content_fragment_menu);

        botAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.action_rig_dra:
                        mListener.openDrawer();
                        Toast.makeText(getActivity(), "Opened Drawer", Toast.LENGTH_SHORT).show();
                        return true;

                }


                return false;
            }
        });
   }




    public interface OnFragmentInteractionListener {
        void openDrawer();
        void closeDrawer();
    }

}