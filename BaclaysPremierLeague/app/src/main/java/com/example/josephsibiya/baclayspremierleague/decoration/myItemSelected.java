package com.example.josephsibiya.baclayspremierleague.decoration;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.josephsibiya.baclayspremierleague.R;

/**
 * Created by josephsibiya on 2017/08/31.
 */

public class myItemSelected implements PopupMenu.OnMenuItemClickListener{

    private Context context;

    public myItemSelected(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.teamDet:
                Toast.makeText(context, "Team details", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.players:
                Toast.makeText(context, "Team players", Toast.LENGTH_SHORT).show();
                return  true;
            default:

        }
        return false;
    }
}
