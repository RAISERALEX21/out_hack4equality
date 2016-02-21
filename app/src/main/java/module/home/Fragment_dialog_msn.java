package module.home;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.hack4equality.out.R;

/**
 * Created by RaiserAlex on 21/02/16.
 */
public class Fragment_dialog_msn extends DialogFragment implements View.OnClickListener {

    final static public String TAG = "dialogMsn";
    static String LOG_TAG = "TAG_dialogMsn_FRAGMENT";

    static Context context;
    public android.support.v4.app.Fragment fragment;
    public FragmentTransaction fragmentTransaction;
    public FragmentManager fragmentManager;


    Button but_dialog_salir,
           but_dialog_rentar;


    View view;
    Bundle extras;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity().getApplicationContext();
        extras = getArguments();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_dialog_msn, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        but_dialog_salir  = (Button) view.findViewById(R.id.dialog_msn_exit);

        but_dialog_salir.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.dialog_msn_exit:
                    dismiss();
                break;



        }
    }
}
