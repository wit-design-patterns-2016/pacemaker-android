package org.pacemaker.pacemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ActivitiesList extends AppCompatActivity
{

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activities_list);

    Bundle extras = getIntent().getExtras();
    List<MyActivity> activities  = extras.getParcelableArrayList("activities");

    for (MyActivity activity : activities)
    {
      Log.v("Pacemaker", "Activity: " + activity);
    }
  }
}
