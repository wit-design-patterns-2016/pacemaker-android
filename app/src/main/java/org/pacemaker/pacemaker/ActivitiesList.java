package org.pacemaker.pacemaker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

    ActivityAdapter activitiesAdapter = new ActivityAdapter(this,  activities);
    activitiesListView.setAdapter(activitiesAdapter);
    activitiesAdapter.notifyDataSetChanged();
  }
}

class ActivityAdapter extends ArrayAdapter<MyActivity>
{
  private Context        context;
  public  List<MyActivity> activities;

  public ActivityAdapter(Context context, List<MyActivity> activities)
  {
    super(context, android.R.layout.simple_list_item_1, activities);
    this.context   = context;
    this.activities = activities;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent)
  {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View     view     = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
    MyActivity activity = activities.get(position);
    TextView textView = (TextView) view.findViewById(android.R.id.text1);

    textView.setText("" + activity);

    return view;
  }

  @Override
  public int getCount()
  {
    return activities.size();
  }
}
