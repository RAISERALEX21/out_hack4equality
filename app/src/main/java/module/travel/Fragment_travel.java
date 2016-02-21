package module.travel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack4equality.out.R;

import java.util.ArrayList;

/**
 * Created by RaiserAlex on 20/02/16.
 */
public class Fragment_travel extends Fragment {

    final static public String TAG = "tavel";
    static String LOG_TAG = "FragTravel";

    static Context context;
    public ViewPager viewPager;

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_out_travel, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new Fragment_visit_1());
        fragments.add(new Fragment_visit_2());
        fragments.add(new Fragment_visit_3());
        fragments.add(new Fragment_visit_4());


        ScreenSlidePagerAdapter screenSlidePagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPager.setAdapter(screenSlidePagerAdapter);

        return view;
    }
}
