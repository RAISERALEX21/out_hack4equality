package module.favorite;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack4equality.out.R;

import java.util.ArrayList;

/**
 * Created by RaiserAlex on 20/02/16.
 */
public class Fragment_favorite extends Fragment{

    final static public String TAG = "favorite";
    static String LOG_TAG = "FragFavorite";

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

        view = inflater.inflate(R.layout.fragment_out_favorite, container, false);

        return view;
    }

}
