

package com.pk.example;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import com.pk.example.dao.ProfileDao;
import com.pk.example.entity.ProfileEntity;
import com.pk.example.entity.ScheduleEntity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.Toast;

import java.util.Calendar;

public class ScheduleViewActivity extends Activity{
    private String flag;
    private ScheduleEntity scheduleEntity; // for edit/delete
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = String.valueOf(getIntent().getStringExtra("flag"));

        // create profile mode
        if (flag.equals("create")) {
            setContentView(R.layout.activity_schedule_view);
            btnDatePicker=(Button)findViewById(R.id.btn_date);
            btnTimePicker=(Button)findViewById(R.id.btn_time);
            txtDate=(EditText)findViewById(R.id.in_date);
            txtTime=(EditText)findViewById(R.id.in_time);



        }
    }
    //DATE CANT BE PAST

    public void buttonClicked(View v) {

        if(v.getId() == R.id.btn_date){

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();

        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
    }
}
//
//import android.graphics.RectF;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.TypedValue;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import com.alamkanak.weekview.DateTimeInterpreter;
//import com.alamkanak.weekview.MonthLoader;
//import com.alamkanak.weekview.WeekView;
//import com.alamkanak.weekview.WeekViewEvent;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Locale;
//
//public class ScheduleViewActivity extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener, WeekView.EmptyViewLongPressListener {
//
//    private static final int TYPE_DAY_VIEW = 1;
//    private static final int TYPE_THREE_DAY_VIEW = 2;
//    private static final int TYPE_WEEK_VIEW = 3;
//    private int mWeekViewType = TYPE_THREE_DAY_VIEW;
//    private WeekView mWeekView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_schedule_view);
//
//        // Get a reference for the week view in the layout.
//        mWeekView = (WeekView) findViewById(R.id.weekView);
//
//        // Show a toast message about the touched event.
//        mWeekView.setOnEventClickListener(this);
//
//        // The week view has infinite scrolling horizontally. We have to provide the events of a
//        // month every time the month changes on the week view.
//        mWeekView.setMonthChangeListener(this);
//
//        // Set long press listener for events.
//        mWeekView.setEventLongPressListener(this);
//
//        // Set long press listener for empty view
//        mWeekView.setEmptyViewLongPressListener(this);
//
//        // Set up a date time interpreter to interpret how the date and time will be formatted in
//        // the week view. This is optional.
//        setupDateTimeInterpreter(false);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        setupDateTimeInterpreter(id == R.id.action_week_view);
//        switch (id){
//            case R.id.action_today:
//                mWeekView.goToToday();
//                return true;
//            case R.id.action_day_view:
//                if (mWeekViewType != TYPE_DAY_VIEW) {
//                    item.setChecked(!item.isChecked());
//                    mWeekViewType = TYPE_DAY_VIEW;
//                    mWeekView.setNumberOfVisibleDays(1);
//
//                    // Lets change some dimensions to best fit the view.
//                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
//                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
//                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
//                }
//                return true;
//            case R.id.action_three_day_view:
//                if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
//                    item.setChecked(!item.isChecked());
//                    mWeekViewType = TYPE_THREE_DAY_VIEW;
//                    mWeekView.setNumberOfVisibleDays(3);
//
//                    // Lets change some dimensions to best fit the view.
//                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
//                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
//                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
//                }
//                return true;
//            case R.id.action_week_view:
//                if (mWeekViewType != TYPE_WEEK_VIEW) {
//                    item.setChecked(!item.isChecked());
//                    mWeekViewType = TYPE_WEEK_VIEW;
//                    mWeekView.setNumberOfVisibleDays(7);
//
//                    // Lets change some dimensions to best fit the view.
//                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
//                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
//                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
//                }
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * Set up a date time interpreter which will show short date values when in week view and long
//     * date values otherwise.
//     * @param shortDate True if the date values should be short.
//     */
//    private void setupDateTimeInterpreter(final boolean shortDate) {
//        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
//            @Override
//            public String interpretDate(Calendar date) {
//                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
//                String weekday = weekdayNameFormat.format(date.getTime());
//                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());
//
//                // All android api level do not have a standard way of getting the first letter of
//                // the week day name. Hence we get the first char programmatically.
//                // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
//                if (shortDate)
//                    weekday = String.valueOf(weekday.charAt(0));
//                return weekday.toUpperCase() + format.format(date.getTime());
//            }
//
//            @Override
//            public String interpretTime(int hour) {
//                return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
//            }
//        });
//    }
//
//    protected String getEventTitle(Calendar time) {
//        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH)+1, time.get(Calendar.DAY_OF_MONTH));
//    }
//
//    @Override
//    public void onEventClick(WeekViewEvent event, RectF eventRect) {
//        Toast.makeText(this, "Clicked " + event.getName(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
//        Toast.makeText(this, "Long pressed event: " + event.getName(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onEmptyViewLongPress(Calendar time) {
//        Toast.makeText(this, "Empty view long pressed: " + getEventTitle(time), Toast.LENGTH_SHORT).show();
//    }
//
//    public WeekView getWeekView() {
//        return mWeekView;
//    }
//}