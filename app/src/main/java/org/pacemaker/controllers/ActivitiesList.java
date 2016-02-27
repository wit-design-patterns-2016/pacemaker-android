package org.pacemaker.controllers;

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

import org.pacemaker.R;
import org.pacemaker.main.PacemakerApp;
import org.pacemaker.models.MyActivity;

import java.util.List;

public class ActivitiesList extends  android.app.Activity
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
    super(context, R.layout.activity_row_layout, activities);
    this.context   = context;
    this.activities = activities;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent)
  {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View     view      = inflater.inflate(R.layout.activity_row_layout, parent, false);
    MyActivity activity  = activities.get(position);
    TextView type      = (TextView) view.findViewById(R.id.type);
    TextView location  = (TextView) view.findViewById(R.id.location);
    TextView distance  = (TextView) view.findViewById(R.id.distance);

    type.setText(activity.type);
    location.setText(activity.location);
    distance.setText("" + activity.distance);
    return view;
  }

  @Override
  public int getCount()
  {
    return activities.size();
  }
}