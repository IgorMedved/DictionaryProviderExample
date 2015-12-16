package android.example.com.dictionaryproviderexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Admin User on 12/16/2015.
 */
public class ViewHolder extends RecyclerView.ViewHolder
{
    private TextView mTextView;


    public ViewHolder (View itemView)
    {
        super(itemView);
        //mTextView = (TextView)itemView.findViewById(R.id.textcell);

    }
}
