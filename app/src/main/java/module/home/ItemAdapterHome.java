package module.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hack4equality.out.R;

import java.util.List;



/**
 * Created by RaiserAlex21 on 03/11/15.
 */
public class ItemAdapterHome extends RecyclerView.Adapter<ItemAdapterHome.PersonViewHolder> implements RecyclerView.OnItemTouchListener{

    List<HomeObject> homeObjects;
    Context context;
    FragmentManager fragmentManager;
    private int lastPosition = -1;
    private int position = 0;

    private AdapterView.OnItemClickListener mListener;
    GestureDetector mGestureDetector;

    ItemAdapterHome(List<HomeObject> homeObjects, Context context, FragmentManager fragmentManager){
        this.homeObjects = homeObjects;
        this.context     = context;
        this.fragmentManager    = fragmentManager;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home_item_cardview, viewGroup, false);


        PersonViewHolder personViewHolder = new PersonViewHolder(v);

        return personViewHolder;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int position) {

        Log.d("ItemAdapterHome",homeObjects.get(position).title + "   " + homeObjects.get(position).description + "   " + homeObjects.get(position).pay);
        personViewHolder.home_title.setText(homeObjects.get(position).title);
        personViewHolder.home_description.setText(homeObjects.get(position).description);
        personViewHolder.home_pay.setText(homeObjects.get(position).pay);
        this.position = position;

        personViewHolder.but_home_rv_favotite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /// button click event
                Toast.makeText(context,"AGREGADO " + homeObjects.get(position).title + " A FAVORITOS",Toast.LENGTH_LONG).show();
            }
        });

        personViewHolder.but_home_rv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_dialog_home fragment_dialog_home = new Fragment_dialog_home();
                fragment_dialog_home.show(fragmentManager, Fragment_dialog_home.TAG);

            }
        });
        setAnimation(personViewHolder.container, position);

    }

    @Override
    public int getItemCount() {
        return homeObjects.size();
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Toast.makeText(context,"HOLA",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;

        TextView home_title,
                 home_description,
                 home_pay;

        Button but_home_rv_favotite,
                but_home_rv_more;

        FrameLayout container;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv_home);

            home_title         = (TextView) itemView.findViewById(R.id.tv_home_item_title);
            home_description   = (TextView) itemView.findViewById(R.id.tv_home_item_description);
            home_pay           = (TextView) itemView.findViewById(R.id.tv_home_item_pay);

            but_home_rv_favotite = (Button) itemView.findViewById(R.id.but_home_rv_favorite);
            but_home_rv_more     = (Button) itemView.findViewById(R.id.but_home_rv_more);

            container          = (FrameLayout) itemView.findViewById(R.id.frame_item_container);
        }
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(final View viewToAnimate, final int position) {
        // If the bound view wasn't previously displayed on screen, it's animated


                if (position > lastPosition) {

                     Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                    viewToAnimate.startAnimation(animation);
                    lastPosition = position;
                }
    }

}