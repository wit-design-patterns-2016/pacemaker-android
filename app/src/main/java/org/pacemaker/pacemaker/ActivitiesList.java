package org.pacemaker.pacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ActivitiesList extends AppCompatActivity
{
  private PacemakerApp app;
  private ListView     activitiesListView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activities_list);

    app = (PacemakerApp) getApplication();

    activitiesListView = (ListView) findViewById(R.id.activitiesListView);

    List<MyActivity> activities  = app.actvities;

    ArrayAdapter <MyActivity>activitiesAdapter = new ArrayAdapter<MyActivity>(this, android.R.layout.simple_list_item_1, activities);
    activitiesListView.setAdapter(activitiesAdapter);
    activitiesAdapter.notifyDataSetChanged();
  }
}
