package com.pk.example;

import java.util.List;
import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.pk.example.entity.ScheduleEntity;

public class ScheduleAdapter extends ArrayAdapter<ScheduleEntity> {
    private List<ScheduleEntity> scheduleEntities = null;
    private Context context;
    SwitchCompat switchCompat;
    ToggleButton b;


    public ScheduleAdapter(Context context, int textViewResourceId,
                               List<ScheduleEntity> scheduleEntities) {
        super(context, textViewResourceId, scheduleEntities);
        this.context = context;
        this.scheduleEntities = scheduleEntities;
    }

    @Override
    public int getCount() {
        return ((null != scheduleEntities) ? scheduleEntities.size() : 0);
    }

    @Override
    public ScheduleEntity getItem(int position) {
        return ((null != scheduleEntities) ? scheduleEntities.get(position) : null);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view) {
            LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.schedule_list_row, null);
        }

        ScheduleEntity schedule = scheduleEntities.get(position);
        if (null != schedule) {
            TextView scheduleName = (TextView) view.findViewById(R.id.name);
            b = (ToggleButton) view.findViewById(R.id.toggBtn);

            scheduleName.setText(schedule.getName());
            b.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (b.isChecked()) {
                        ProfileScheduler.enableSchedule(context, getItem(position));
                        //TODO UPDATE SCHEDULE IS ENABLED IN DATABASE
                    } else {
                        ProfileScheduler.disableSchedule(context, getItem(position));

                    }
                }
            });


            //still need to set info
            //appName.setText(applicationInfo.loadLabel(packageManager));
            //packageName.setText(applicationInfo.packageName);
            //iconview.setImageDrawable(applicationInfo.loadIcon(packageManager));
        }
        return view;
    }
}
