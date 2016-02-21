package module.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack4equality.out.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RaiserAlex on 20/02/16.
 */
public class Fragment_home extends Fragment{
    final static public String TAG = "home";
    static String LOG_TAG = "FragHome";

    static Context context;

    RecyclerView recyclerView;
    GestureDetectorCompat detector;
    View view;

    private List<HomeObject> homeObjectList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_out_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_home_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        addRecyclerV();

        return view;
    }

    public void addRecyclerV(){
        Log.d(LOG_TAG,"Init addRecyckerV......");

        homeObjectList = new ArrayList<>();

        homeObjectList.add(
                new HomeObject("CAsA AZUL",
                               "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t UN LUGAR SEGURO PARA ESTAR SOLO O ACOMPAÑADO",
                               "450.00")
        );

        homeObjectList.add(
                new HomeObject("PARA TUS FIESTAS",
                               "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t DISFRUTA DE NUESTROS LUGARES DE ARTE COMO UNA RICA COMIDA",
                               "650.00")
        );

        homeObjectList.add(
                new HomeObject("CASA ROSA",
                               "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t LO MEJORES BARES DEL DF PARA PASAR UN RATO DIVERTIDO",
                                "850.00")
        );

        homeObjectList.add(
                new HomeObject("MODESTO",
                        "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t UN LUGAR SEGURO PARA ESTAR SOLO O ACOMPAÑADO",
                        "350.00")
        );

        homeObjectList.add(
                new HomeObject("CASA CON BALCON",
                        "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t DISFRUTA DE NUESTROS LUGARES DE ARTE COMO UNA RICA COMIDA",
                        "1050.00")
        );

        homeObjectList.add(
                new HomeObject("TRES CAMAS",
                        "UBICACION: \n\t ZONA ROSA \n\n DESCRIPCION: \n\t LO MEJORES BARES DEL DF PARA PASAR UN RATO DIVERTIDO",
                        "5001.00")
        );

        ItemAdapterHome itemAdapterHome = new ItemAdapterHome(homeObjectList,getContext(),getFragmentManager());
        recyclerView.setAdapter(itemAdapterHome);
        itemAdapterHome.notifyDataSetChanged();



    }
}
