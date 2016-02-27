package org.pacemaker.controllers;

import org.pacemaker.R;
import org.pacemaker.main.PacemakerApp;
import org.pacemaker.main.SyncUpdate;
import org.pacemaker.models.MyActivity;
import org.pacemaker.models.MyActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends android.app.Activity implements SyncUpdate
{
  private PacemakerApp   app;
  private Button         createActivityButton;
  private TextView       activityType;
  private TextView       activityLocation;
  private NumberPicker   distancePicker;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);

    app = (PacemakerApp) getApplication();

    createActivityButton = (Button)       findViewById(R.id.createActivityButton);
    activityType         = (TextView)     findViewById(R.id.activityType);
    activityLocation     = (TextView)     findViewById(R.id.activityLocation);
    distancePicker       = (NumberPicker) findViewById(R.id.numberPicker);

    distancePicker.setMinValue(0);
    distancePicker.setMaxValue(20);
  }

  public void createActivityButtonPressed (View view)
  {
    double distance     = distancePicker.getValue();
    MyActivity activity = new MyActivity (activityType.getText().toString(), activityLocation.getText().toString(), distance);

    app.createActivity(this, activity, this);
  }

  @Override
  public void userSyncComplete()
  { }

  @Override
  public void activitiesSyncComplete()
  {
    Toast toast = Toast.makeText(this, "Activity Created", Toast.LENGTH_SHORT);
    toast.show();
  }

  @Override
  public void syncError(Exception e)
  {
    Toast toast = Toast.makeText(this, "Failed to create Activity", Toast.LENGTH_SHORT);
    toast.show();
  }

  public void listActivityButtonPressed (View view)
  {
    Log.v("Pacemaker", "List Activities Button Pressed");
    startActivity (new Intent(this, ActivitiesList.class));
  }
}
