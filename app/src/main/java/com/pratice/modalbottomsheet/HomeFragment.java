package com.pratice.modalbottomsheet;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Arpit Jain on 10/3/2017.
 */

public class HomeFragment extends Fragment {
    public static final String TAG = HomeFragment.class.getSimpleName();

    private BottomSheetBehavior mBottomSheetBehavior;
    private LinearLayout buttonLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);



        //HomeAdpter adapter = new HomeAdapter(getContext());
        //recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonLayout = (LinearLayout) getView().findViewById(R.id.button_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            buttonLayout.getForeground().setAlpha(0);
        }
        View bottomSheet = getView().findViewById( R.id.bottom_sheet );
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(mBottomSheetBehavior.STATE_COLLAPSED);
        Log.d(TAG, "Height "+ mBottomSheetBehavior.getPeekHeight());;
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                if(newState != mBottomSheetBehavior.STATE_DRAGGING){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        Log.d(TAG, "Not Sliding");
                        buttonLayout.getForeground().setAlpha(0);
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d(TAG, "Sliding");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    buttonLayout.getForeground().setAlpha(99);
                }
            }
        });
        Button button1 = (Button) getView().findViewById( R.id.button_1 );
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }

    /* Notes *

    1)If you want to add or remove items from the adapter, you will need to explicitly inform to the adapter
        --> public void add(ViewModel item, int position) {
                items.add(position, item);
                notifyItemInserted(position);
            }

            public void remove(ViewModel item) {
                int position = items.indexOf(item);
                items.remove(position);
                notifyItemRemoved(position);
            }

    2)
     */
}
