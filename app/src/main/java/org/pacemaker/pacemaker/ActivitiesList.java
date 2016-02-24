package org.pacemaker.pacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ActivitiesList extends AppCompatActivity
{
  private ListView activitiesListView;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activities_list);

    Bundle extras = getIntent().getExtras();
    List<MyActivity> activities  = extras.getParcelableArrayList("activities");

    activitiesListView = (ListView) findViewById(R.id.activitiesListView);

    for (MyActivity activity : activities)
    {
      Log.v("Pacemaker", "Activity: " + activity);
    }

    ArrayAdapter<MyActivity> activitiesAdapter = new ArrayAdapter<MyActivity>(this, android.R.layout.simple_list_item_1, activities);
    activitiesListView.setAdapter(activitiesAdapter);
    activitiesAdapter.notifyDataSetChanged();
  }
}
