package com.muh_sam.studentinformationsystem.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.muh_sam.studentinformationsystem.R;
import com.muh_sam.studentinformationsystem.Security.LoginActivity;
import com.muh_sam.studentinformationsystem.data.Utility;


public class TimetableDetailActivity extends ActionBarActivity {

    public static final String TIMETABLE_KEY = "timetableId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_detail);
        if (savedInstanceState == null) {
            String timetableId = getIntent().getStringExtra(TIMETABLE_KEY);
            Bundle arguments = new Bundle();
            arguments.putString(TimetableDetailActivity.TIMETABLE_KEY, timetableId);

            TimetableDetailFragment fragment = new TimetableDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.timetable_detail_container, fragment)
                    .commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timetable_detail, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Utility.Logout(this);
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
