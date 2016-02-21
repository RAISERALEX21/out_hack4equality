package module.travel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack4equality.out.R;

/**
 * Created by RaiserAlex on 21/02/16.
 */
public class Fragment_visit_1 extends Fragment{

    final static public String TAG = "visit1";
    static String LOG_TAG = "FragmentVisit_1";

    static Context context;
    public android.support.v4.app.Fragment fragment;
    public FragmentTransaction fragmentTransaction;
    public FragmentManager fragmentManager;

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_visit_1, container, false);
        return view;
    }
}
